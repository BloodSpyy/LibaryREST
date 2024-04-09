package com.bloodspy.spring.libary.service;

import com.bloodspy.spring.libary.dao.LibaryCardRepository;
import com.bloodspy.spring.libary.exceptionHandler.exceptions.NoSuchElementException;
import com.bloodspy.spring.libary.model.LibaryCard;
import com.bloodspy.spring.libary.utils.AppConstant;
import com.bloodspy.spring.libary.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.w3c.dom.css.CSSPageRule;

import java.util.List;

@Service
public class LibaryCardService {
    private final String entityName = "Libary card";

    @Autowired
    public LibaryCardService(LibaryCardRepository libaryCardRepository) {
        this.libaryCardRepository = libaryCardRepository;
    }

    LibaryCardRepository libaryCardRepository;

    public ResponseEntity<Page<LibaryCard>> getAllLibaryCard(int page, int size) {
        AppUtils.validatePageNumberAndSize(page, size);

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, AppConstant.ID);
        Page<LibaryCard> libaryCards = libaryCardRepository.findAll(pageable);

        return new ResponseEntity<>(libaryCards, HttpStatus.OK);
    }

    public ResponseEntity<LibaryCard> getLibaryCard(int id) {
        LibaryCard libaryCard = libaryCardRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(entityName, id)
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
                () -> new NoSuchElementException(entityName, id)
        );

        libaryCardRepository.delete(libaryCard);

        return new ResponseEntity<>("Libary card was deleted", HttpStatus.OK);
    }
}
