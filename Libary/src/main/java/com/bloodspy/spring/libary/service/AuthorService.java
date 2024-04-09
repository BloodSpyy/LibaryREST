package com.bloodspy.spring.libary.service;

import com.bloodspy.spring.libary.dao.AuthorRepository;
import com.bloodspy.spring.libary.exceptionHandler.exceptions.NoSuchException;
import com.bloodspy.spring.libary.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final String entityName = "Author";
    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    AuthorRepository authorRepository;


    public List<Author> getAllAuthor() {
        List<Author> authors = authorRepository.findAll();

        return authors;
    }

    public ResponseEntity<Author> getAuthor(int id) {
        Author author = authorRepository.findById(id).orElseThrow(
                () -> new NoSuchException(entityName, id)
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
                () -> new NoSuchException(entityName, id)
        );

        authorRepository.delete(author);

        return new ResponseEntity<>("Author was deleted", HttpStatus.OK);
    }
}
