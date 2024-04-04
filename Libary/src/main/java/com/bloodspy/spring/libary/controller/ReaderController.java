package com.bloodspy.spring.libary.controller;

import com.bloodspy.spring.libary.entity.ReaderEntity;
import com.bloodspy.spring.libary.service.ReaderService;
import com.bloodspy.spring.libary.service.ReaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ReaderController {
    @Autowired
    public ReaderController(ReaderServiceImpl readerService) {
        this.readerService = readerService;
    }

    ReaderService readerService;

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
    public String saveReader(@RequestBody ReaderEntity reader) {
        readerService.saveReader(reader);

        return "Reader with id " + reader.getId() + " was saved";
    }

    @PutMapping("/readers")
    public String updateReader(@RequestBody ReaderEntity reader) {
        readerService.saveReader(reader);

        return "Reader with id " + reader.getId() + " was updated";
    }

    @DeleteMapping("/readers/{id}")
    public String deleteReader(@PathVariable(name = "id") int id) {
        readerService.deleteReader(id);

        return "Reader with id " + id + " was deleted";
    }
}