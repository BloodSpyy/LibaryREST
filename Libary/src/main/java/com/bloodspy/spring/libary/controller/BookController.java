package com.bloodspy.spring.libary.controller;

import com.bloodspy.spring.libary.model.Book;
import com.bloodspy.spring.libary.service.BookService;
import com.bloodspy.spring.libary.utils.AppConstant;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(name="Books", description = "CRUD operations")
public class BookController {

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    BookService bookService;

    @GetMapping
    public ResponseEntity<Page<Book>> getAllBook(
            @RequestParam(name = "page", required = false, defaultValue = AppConstant.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(name = "size", required = false, defaultValue = AppConstant.DEFAULT_PAGE_SIZE) int size)
    {
        return bookService.getAllBook(page, size);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBook(@PathVariable(name = "id") int id) {
        return bookService.getBook(id);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
       return bookService.addBook(book);
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable(name = "id") int id) {
        return bookService.deleteBook(id);
    }
}
