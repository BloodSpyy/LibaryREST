package com.bloodspy.spring.libary.controller;

import com.bloodspy.spring.libary.entity.BookEntity;
import com.bloodspy.spring.libary.exceptionHandler.exceptions.NoSuchException;
import com.bloodspy.spring.libary.returnMessage.ContainerReturnMessage;
import com.bloodspy.spring.libary.returnMessage.ReturnMessageHandler;
import com.bloodspy.spring.libary.service.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@Tag(name="Books", description = "CRUD operations")
public class BookController {
    private final String entityName = "Book";

    @Autowired
    public BookController(BookService bookService,
                          ReturnMessageHandler returnMessageHandler) {
        this.bookService = bookService;
        this.returnMessageHandler = returnMessageHandler;
    }

    BookService bookService;

    ReturnMessageHandler returnMessageHandler;

    @GetMapping("/books")
    public List<BookEntity> getAllBook() {
        List<BookEntity> books = bookService.getAllBook();

        return books;
    }

    @GetMapping("/books/{id}")
    public BookEntity getBook(@PathVariable(name = "id") int id) {
        BookEntity book = bookService.getBook(id);

        if(book == null) {
            throw new NoSuchException(entityName, id);
        }

        return book;
    }

    @PostMapping("/books")
    public ContainerReturnMessage addBook(@RequestBody BookEntity book) {
       bookService.saveBook(book);

       return returnMessageHandler.getAddMessage(entityName, book.getId());
    }

    @PutMapping("/books")
    public ContainerReturnMessage updateBook(@RequestBody BookEntity book) {
        bookService.saveBook(book);

        return returnMessageHandler.getUpdateMessage(entityName, book.getId());
    }

    @DeleteMapping("/books/{id}")
    public ContainerReturnMessage deleteBook(@PathVariable(name = "id") int id) {
        BookEntity book = bookService.getBook(id);

        if(book == null) {
            throw new NoSuchException(entityName, id);
        }

        bookService.deleteBook(id);

        return returnMessageHandler.getDeleteMessage(entityName, book.getId());
    }
}
