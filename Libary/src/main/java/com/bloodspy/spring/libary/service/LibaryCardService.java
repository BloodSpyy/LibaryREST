package com.bloodspy.spring.libary.service;

import com.bloodspy.spring.libary.dao.LibaryCardRepository;
import com.bloodspy.spring.libary.exceptionHandler.exceptions.NoSuchException;
import com.bloodspy.spring.libary.model.LibaryCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibaryCardService {
    private final String entityName = "Libary card";

    @Autowired
    public LibaryCardService(LibaryCardRepository libaryCardRepository) {
        this.libaryCardRepository = libaryCardRepository;
    }

    LibaryCardRepository libaryCardRepository;

    public List<LibaryCard> getAllLibaryCard() {
        List<LibaryCard> libaryCards = libaryCardRepository.findAll();

        return libaryCards;
    }

    public ResponseEntity<LibaryCard> getLibaryCard(int id) {
        LibaryCard libaryCard = libaryCardRepository.findById(id).orElseThrow(
                () -> new NoSuchException(entityName, id)
        );

        return new ResponseEntity<>(libaryCard, HttpStatus.OK);
    }

    public ResponseEntity<LibaryCard> addLibaryCard(LibaryCard libaryCard) {
        libaryCard = libaryCardRepository.save(libaryCard);

        return new ResponseEntity<>(libaryCard, HttpStatus.CREATED);
    }

    public ResponseEntity<LibaryCard> updateLibaryCard(LibaryCard libaryCard) {
        libaryCard = libaryCardRepository.save(libaryCard);

        return new ResponseEntity<>(libaryCard, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteLibaryCard(int id) {
        LibaryCard libaryCard = libaryCardRepository.findById(id).orElseThrow(
                () -> new NoSuchException(entityName, id)
        );

        libaryCardRepository.delete(libaryCard);

        return new ResponseEntity<>("Libary card was deleted", HttpStatus.OK);
    }
}
