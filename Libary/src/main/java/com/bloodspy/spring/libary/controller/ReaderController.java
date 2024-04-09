package com.bloodspy.spring.libary.controller;

import com.bloodspy.spring.libary.model.Reader;
import com.bloodspy.spring.libary.exceptionHandler.exceptions.NoSuchException;
import com.bloodspy.spring.libary.service.ReaderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readers")
@Tag(name = "Readers", description = "CRUD operations")
public class ReaderController {

    @Autowired
    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    ReaderService readerService;

    @GetMapping
    public List<Reader> getAllReader() {
        List<Reader> readers = readerService.getAllReader();

        return readers;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reader> getReader(@PathVariable(name = "id") int id) {
        return readerService.getReader(id);
    }

    @PostMapping
    public ResponseEntity<Reader> addReader(@RequestBody Reader reader) {
        return readerService.addReader(reader);
    }

    @PutMapping
    public ResponseEntity<Reader> updateReader(@RequestBody Reader reader) {
        return readerService.updateReader(reader);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReader(@PathVariable(name = "id") int id) {
        return readerService.deleteReader(id);
    }
}