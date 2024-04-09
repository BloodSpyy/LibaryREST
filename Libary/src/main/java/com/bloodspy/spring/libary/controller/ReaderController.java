package com.bloodspy.spring.libary.controller;

import com.bloodspy.spring.libary.model.Reader;
import com.bloodspy.spring.libary.service.ReaderService;
import com.bloodspy.spring.libary.utils.AppConstant;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<Page<Reader>> getAllReader(
            @RequestParam(name = "page", required = false, defaultValue = AppConstant.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(name = "size", required = false, defaultValue = AppConstant.DEFAULT_PAGE_SIZE) int size
    ) {
        return readerService.getAllReader(page, size);
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