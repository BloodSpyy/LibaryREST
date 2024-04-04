package com.bloodspy.spring.libary.controller;

import com.bloodspy.spring.libary.entity.LibaryCardEntity;
import com.bloodspy.spring.libary.service.LibaryCardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class LibaryCardController {
    @Autowired
    public LibaryCardController(LibaryCardServiceImpl libaryCardService) {
        this.libaryCardService = libaryCardService;
    }

    LibaryCardServiceImpl libaryCardService;

    @GetMapping("/libaryCards")
    public List<LibaryCardEntity> getAllLibaryCard() {
        List<LibaryCardEntity> libaryCards = libaryCardService.getAllLibaryCard();

        return libaryCards;
    }

    @GetMapping("/libaryCards/{id}")
    public LibaryCardEntity getLibaryCard(@PathVariable(name = "id") int id) {
        LibaryCardEntity libaryCard = libaryCardService.getLibaryCard(id);

        return libaryCard;
    }

    @PostMapping("/libaryCards")
    public LibaryCardEntity saveLibaryCard(@RequestBody LibaryCardEntity libaryCard) {
        libaryCard = libaryCardService.saveLibaryCard(libaryCard);

        return libaryCard;
    }

    @PutMapping("/libaryCards")
    public LibaryCardEntity updateLibaryCard(@RequestBody LibaryCardEntity libaryCard) {
        libaryCard = libaryCardService.saveLibaryCard(libaryCard);

        return libaryCard;
    }

    @DeleteMapping("/libaryCards/{id}")
    public String removeLibaryCard(@PathVariable(name = "id") int id) {
        libaryCardService.deleteLibaryCard(id);

        return "Libary card with " + id + " was deleted";
    }

}