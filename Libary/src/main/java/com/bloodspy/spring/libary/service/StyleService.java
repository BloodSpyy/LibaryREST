package com.bloodspy.spring.libary.service;

import com.bloodspy.spring.libary.dao.StyleRepository;
import com.bloodspy.spring.libary.exceptionHandler.exceptions.NoSuchElementException;
import com.bloodspy.spring.libary.model.Author;
import com.bloodspy.spring.libary.model.Style;
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

import java.util.List;

@Service
public class StyleService {
    public final String entityName = "Style";
    @Autowired
    public StyleService(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    StyleRepository styleRepository;
    public ResponseEntity<Page<Style>> getAllStyle(int page, int size) {

        AppUtils.validatePageNumberAndSize(page, size);
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, AppConstant.ID);

        Page<Style> styles = styleRepository.findAll(pageable);

        return new ResponseEntity<>(styles, HttpStatus.OK);
    }

    public ResponseEntity<Style> getStyle(int id) {
        Style style = styleRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(entityName, id)
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
                () -> new NoSuchElementException(entityName, id)
        );

        styleRepository.delete(style);

        return new ResponseEntity<>("Style was deleted", HttpStatus.OK);
    }
}
