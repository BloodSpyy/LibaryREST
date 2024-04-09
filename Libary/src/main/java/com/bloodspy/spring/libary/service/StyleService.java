package com.bloodspy.spring.libary.service;

import com.bloodspy.spring.libary.dao.StyleRepository;
import com.bloodspy.spring.libary.exceptionHandler.exceptions.NoSuchException;
import com.bloodspy.spring.libary.model.Style;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StyleService {
    public final String entityName = "Style";
    @Autowired
    public StyleService(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    StyleRepository styleRepository;
    public List<Style> getAllStyle() {
        List<Style> styles = styleRepository.findAll();

        return styles;
    }

    public ResponseEntity<Style> getStyle(int id) {
        Style style = styleRepository.findById(id).orElseThrow(
                () -> new NoSuchException(entityName, id)
        );

        return new ResponseEntity<>(style, HttpStatus.OK);
    }

    public ResponseEntity<Style> addStyle(Style style) {
        style = styleRepository.save(style);

        return new ResponseEntity<>(style, HttpStatus.CREATED);
    }

    public ResponseEntity<Style> updateStyle(Style style) {
        style = styleRepository.save(style);

        return new ResponseEntity<>(style, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteStyle(int id) {
        Style style = styleRepository.findById(id).orElseThrow(
                () -> new NoSuchException(entityName, id)
        );

        styleRepository.delete(style);

        return new ResponseEntity<>("Style was deleted", HttpStatus.OK);
    }
}
