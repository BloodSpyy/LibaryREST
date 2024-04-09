package com.bloodspy.spring.libary.controller;

import com.bloodspy.spring.libary.exceptionHandler.exceptions.NoSuchException;
import com.bloodspy.spring.libary.model.LibaryCard;
import com.bloodspy.spring.libary.service.LibaryCardService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libaryCards")
@Tag(name = "Libary card", description = "CRUD operations")
public class LibaryCardController {

    @Autowired
    public LibaryCardController(LibaryCardService libaryCardService) {
        this.libaryCardService = libaryCardService;
    }

    LibaryCardService libaryCardService;

    @GetMapping
    public List<LibaryCard> getAllLibaryCard() {
        List<LibaryCard> libaryCards = libaryCardService.getAllLibaryCard();

        return libaryCards;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibaryCard> getLibaryCard(@PathVariable(name = "id") int id) {
        return libaryCardService.getLibaryCard(id);
    }

    @PostMapping
    public ResponseEntity<LibaryCard> addLibaryCard(@RequestBody LibaryCard libaryCard) {
        return libaryCardService.addLibaryCard(libaryCard);
    }

    @PutMapping
    public ResponseEntity<LibaryCard> updateLibaryCard(@RequestBody LibaryCard libaryCard) {
        return libaryCardService.updateLibaryCard(libaryCard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeLibaryCard(@PathVariable(name = "id") int id) {
        return libaryCardService.deleteLibaryCard(id);
    }
}
