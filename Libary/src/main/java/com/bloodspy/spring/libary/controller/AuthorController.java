package com.bloodspy.spring.libary.controller;

import com.bloodspy.spring.libary.model.Author;
import com.bloodspy.spring.libary.service.AuthorService;
import com.bloodspy.spring.libary.utils.AppConstant;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@Tag(name="Authors", description = "CRUD operations")
public class AuthorController {

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;

    }

    AuthorService authorService;

    @GetMapping
    public ResponseEntity<Page<Author>> getAllAuthor(
            @RequestParam(name = "page", required = false, defaultValue = AppConstant.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(name = "size", required = false, defaultValue = AppConstant.DEFAULT_PAGE_SIZE) int size
    ) {
        return authorService.getAllAuthor(page, size);
    }

    @GetMapping("{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable(name = "id") int id) {
        return authorService.getAuthor(id);
    }

    @PostMapping
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @PutMapping
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author) {
        return authorService.updateAuthor(author);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable(name = "id") int id) {
        return authorService.deleteAuthor(id);
    }
}
