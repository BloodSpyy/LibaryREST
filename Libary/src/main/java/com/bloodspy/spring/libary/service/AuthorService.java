package com.bloodspy.spring.libary.service;

import com.bloodspy.spring.libary.dao.AuthorRepository;
import com.bloodspy.spring.libary.exceptionHandler.exceptions.NoSuchElementException;
import com.bloodspy.spring.libary.model.Author;
import com.bloodspy.spring.libary.utils.AppConstant;
import com.bloodspy.spring.libary.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final String entityName = "Author";
    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    AuthorRepository authorRepository;


    public ResponseEntity<Page<Author>> getAllAuthor(int page, int size) {
        AppUtils.validatePageNumberAndSize(page, size);
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, AppConstant.ID);

        Page<Author> authors = authorRepository.findAll(pageable);

        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    public ResponseEntity<Author> getAuthor(int id) {
        Author author = authorRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(entityName, id)
        );

        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    public ResponseEntity<Author> addAuthor(Author author) {
        author = authorRepository.save(author);

        return new ResponseEntity<>(author, HttpStatus.CREATED);
    }

    public ResponseEntity<Author> updateAuthor(Author author) {
        author = authorRepository.save(author);

        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteAuthor(int id) {
        Author author = authorRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(entityName, id)
        );

        authorRepository.delete(author);

        return new ResponseEntity<>("Author was deleted", HttpStatus.OK);
    }
}
