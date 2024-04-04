package com.bloodspy.spring.libary.controller;

import com.bloodspy.spring.libary.entity.BookEntity;
import com.bloodspy.spring.libary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    BookService bookService;

    @GetMapping("/books")
    public List<BookEntity> getAllBook() {
        List<BookEntity> books = bookService.getAllBook();

        return books;
    }

    @GetMapping("/books/{id}")
    public BookEntity getBook(@PathVariable(name = "id") int id) {
        BookEntity book = bookService.getBook(id);

        return book;
    }

    @PostMapping("/books")
    public String addBook(@RequestBody BookEntity book) {
       bookService.saveBook(book);

       return "Book with id " + book.getId() + " was saved";
    }

    @PutMapping("/books")
    public String updateBook(@RequestBody BookEntity book) {
        bookService.saveBook(book);

        return "Book with id " + book.getId() + " was updated";
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable(name = "id") int id) {
        bookService.deleteBook(id);

        return "Book with id " + id + " was deleted";
    }
}
