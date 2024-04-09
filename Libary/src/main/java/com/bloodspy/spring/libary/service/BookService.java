package com.bloodspy.spring.libary.service;

import com.bloodspy.spring.libary.dao.BookRepository;
import com.bloodspy.spring.libary.exceptionHandler.exceptions.NoSuchException;
import com.bloodspy.spring.libary.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
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
    public List<Book> getAllBook() {
        List<Book> books = bookRepository.findAll();

        return books;
    }

    public ResponseEntity<Book> getBook(int id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new NoSuchException(entityName, id)
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
                () -> new NoSuchException(entityName, id)
        );

        bookRepository.delete(book);

        return new ResponseEntity<>("Book was deleted", HttpStatus.OK);
    }
}
