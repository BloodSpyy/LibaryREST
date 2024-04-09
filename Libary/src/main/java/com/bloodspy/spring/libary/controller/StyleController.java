package com.bloodspy.spring.libary.controller;

import com.bloodspy.spring.libary.model.Style;
import com.bloodspy.spring.libary.service.StyleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/styles")
@Tag(name = "Styles", description = "CRUD operations")
public class StyleController {

    @Autowired
    public StyleController(StyleService styleService) {
        this.styleService = styleService;
    }

    StyleService styleService;

    @GetMapping
    public List<Style> getAllStyle() {
        List<Style> styles = styleService.getAllStyle();

        return styles;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Style> getStyle(@PathVariable(name = "id") int id) {
        return styleService.getStyle(id);
    }

    @PostMapping
    public ResponseEntity<Style> addStyle(@RequestBody Style style) {
        return styleService.addStyle(style);
    }

    @PutMapping
    public ResponseEntity<Style> updateStyle(@RequestBody Style style) {
        return styleService.updateStyle(style);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStyle(@PathVariable(name = "id") int id) {
        return styleService.deleteStyle(id);
    }
}