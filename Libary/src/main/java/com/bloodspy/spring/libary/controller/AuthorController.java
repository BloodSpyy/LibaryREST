package com.bloodspy.spring.libary.controller;

import com.bloodspy.spring.libary.entity.AuthorEntity;
import com.bloodspy.spring.libary.service.AuthorService;
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

    AuthorService authorService;

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
    public String addAuthor(@RequestBody AuthorEntity author) {
        authorService.saveAuthor(author);

        return "Author with " + author.getId() + " was saved";

    }

    @PutMapping("/authors")
    public String updateAuthor(@RequestBody AuthorEntity author) {
        authorService.saveAuthor(author);

        return "Author with " + author.getId() + " was updated";
    }

    @DeleteMapping("/authors/{id}")
    public String deleteAuthor(@PathVariable(name = "id") int id) {
        authorService.deleteAuthor(id);

        return "Author with " + id + " was deleted";
    }
}
