package com.bloodspy.spring.libary.controller;

import com.bloodspy.spring.libary.entity.LibaryCardEntity;
import com.bloodspy.spring.libary.entity.ReaderEntity;
import com.bloodspy.spring.libary.service.LibaryCardServiceImpl;
import com.bloodspy.spring.libary.service.ReaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ReaderController {
    public ReaderController(ReaderServiceImpl readerService, LibaryCardServiceImpl libaryCardService) {
        this.readerService = readerService;
        this.libaryCardService = libaryCardService;
    }

    ReaderServiceImpl readerService;
    LibaryCardServiceImpl libaryCardService;

    @GetMapping("/readers")
    public List<ReaderEntity> getAllReader() {
        List<ReaderEntity> readers = readerService.getAllReader();

        return readers;
    }

    @GetMapping("/readers/{id}")
    public ReaderEntity getReader(@PathVariable(name = "id") int id) {
        ReaderEntity reader = readerService.getReader(id);

        return reader;
    }

    @PostMapping("/readers")
    public ReaderEntity saveReader(@RequestBody ReaderEntity reader) {
        reader = readerService.saveReader(reader);

        return reader;
    }

    @PutMapping("/readers")
    public ReaderEntity updateReader(@RequestBody ReaderEntity reader) {
        reader = readerService.saveReader(reader);

        return reader;
    }

    @DeleteMapping("/readers/{id}")
    public String deleteReader(@PathVariable(name = "id") int id) {
        readerService.deleteReader(id);

        return "Reader with id " + id + " was deleted";
    }
}