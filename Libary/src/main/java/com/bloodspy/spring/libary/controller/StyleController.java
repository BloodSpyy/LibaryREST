package com.bloodspy.spring.libary.controller;

import com.bloodspy.spring.libary.model.Style;
import com.bloodspy.spring.libary.service.StyleService;
import com.bloodspy.spring.libary.utils.AppConstant;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Page<Style>> getAllStyle(
            @RequestParam(name = "page", required = false, defaultValue = AppConstant.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(name = "size", required = false, defaultValue = AppConstant.DEFAULT_PAGE_SIZE) int size
    ) {
        return styleService.getAllStyle(page, size);
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