package com.bloodspy.spring.libary.controller;

import com.bloodspy.spring.libary.entity.AuthorEntity;
import com.bloodspy.spring.libary.exceptionHandler.exceptions.NoSuchException;
import com.bloodspy.spring.libary.returnMessage.ContainerReturnMessage;
import com.bloodspy.spring.libary.returnMessage.ReturnMessageHandler;
import com.bloodspy.spring.libary.service.AuthorService;
import com.bloodspy.spring.libary.service.AuthorServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@Tag(name="Authors", description = "CRUD operations")
public class AuthorController {
    private final String entityName = "Author";

    @Autowired
    public AuthorController(AuthorServiceImpl authorService,
                            ReturnMessageHandler returnMessageHandler) {
        this.authorService = authorService;
        this.returnMessageHandler = returnMessageHandler;

    }

    AuthorService authorService;

    ReturnMessageHandler returnMessageHandler;

    @GetMapping("/authors")
    public List<AuthorEntity> getAllAuthor() {
        List<AuthorEntity> authors = authorService.getAllAuthor();

        return authors;
    }

    @GetMapping("/authors/{id}")
    public AuthorEntity getAuthor(@PathVariable(name = "id") int id) {
        AuthorEntity author = authorService.getAuthor(id);

        if(author == null) {
            throw new NoSuchException(entityName, id);
        }

        return author;
    }

    @PostMapping("/authors")
    public ContainerReturnMessage addAuthor(@RequestBody AuthorEntity author) {
        authorService.saveAuthor(author);

        return returnMessageHandler.getAddMessage(entityName, author.getId());
    }

    @PutMapping("/authors")
    public ContainerReturnMessage updateAuthor(@RequestBody AuthorEntity author) {
        authorService.saveAuthor(author);

        return returnMessageHandler.getUpdateMessage(entityName, author.getId());
    }

    @DeleteMapping("/authors/{id}")
    public ContainerReturnMessage deleteAuthor(@PathVariable(name = "id") int id) {
        AuthorEntity author = authorService.getAuthor(id);

        if(author == null) {
            throw new NoSuchException(entityName, id);
        }

        authorService.deleteAuthor(id);

        return returnMessageHandler.getDeleteMessage(entityName, author.getId());
    }
}
