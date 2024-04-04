package com.bloodspy.spring.libary.controller;

import com.bloodspy.spring.libary.entity.AuthorEntity;
import com.bloodspy.spring.libary.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AuthorController {
    @Autowired
    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    AuthorServiceImpl authorService;

    @GetMapping("/authors")
    public List<AuthorEntity> getAllAuthor() {
        List<AuthorEntity> authors = authorService.getAllAuthor();

        return authors;
    }

    @GetMapping("/authors/{id}")
    public AuthorEntity getAuthor(@PathVariable(name = "id") int id) {
        AuthorEntity author = authorService.getAuthor(id);

        return author;
    }

    @PostMapping("/authors")
    public AuthorEntity addAuthor(@RequestBody AuthorEntity author) {
        author = authorService.saveAuthor(author);

        return author;
    }

    @PutMapping("/authors")
    public AuthorEntity updateAuthor(@RequestBody AuthorEntity author) {
        author = authorService.saveAuthor(author);

        return author;
    }

    @DeleteMapping("/authors/{id}")
    public String deleteAuthor(@PathVariable(name = "id") int id) {
        authorService.deleteAuthor(id);

        return "Author with " + id + " was deleted";
    }
}
