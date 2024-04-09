package com.bloodspy.spring.libary.service;

import com.bloodspy.spring.libary.dao.BookRepository;
import com.bloodspy.spring.libary.exceptionHandler.exceptions.NoSuchElementException;
import com.bloodspy.spring.libary.model.Book;
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

import java.util.List;

@Service
public class BookService {
    private final String entityName = "Book";

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    BookRepository bookRepository;
    public ResponseEntity<Page<Book>> getAllBook(int page, int size) {
        AppUtils.validatePageNumberAndSize(page, size);

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, AppConstant.ID);
        Page<Book> books = bookRepository.findAll(pageable);

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    public ResponseEntity<Book> getBook(int id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(entityName, id)
        );

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    public ResponseEntity<Book> addBook(Book book) {
        book = bookRepository.save(book);

        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    public ResponseEntity<Book> updateBook(Book book) {
        book = bookRepository.save(book);

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteBook(int id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(entityName, id)
        );

        bookRepository.delete(book);

        return new ResponseEntity<>("Book was deleted", HttpStatus.OK);
    }
}
