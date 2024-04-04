package com.bloodspy.spring.libary.controller;

import com.bloodspy.spring.libary.entity.StyleEntity;
import com.bloodspy.spring.libary.service.StyleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class StyleController {

    @Autowired
    public StyleController(StyleServiceImpl styleService) {
        this.styleService = styleService;
    }

    StyleServiceImpl styleService;

    @GetMapping("/styles")
    public List<StyleEntity> getAllStyle() {
        List<StyleEntity> styles = styleService.getAllStyle();

        return styles;
    }

    @GetMapping("/styles/{id}")
    public StyleEntity getStyle(@PathVariable(name = "id") int id) {
        StyleEntity style = styleService.getStyle(id);

        return style;
    }

    @PostMapping("/styles")
    public StyleEntity addStyle(@RequestBody StyleEntity style) {
        style = styleService.saveStyle(style);

        return style;
    }

    @PutMapping("/styles")
    public StyleEntity updateStyle(@RequestBody StyleEntity style) {
        style = styleService.saveStyle(style);

        return style;
    }

    @DeleteMapping("/styles/{id}")
    public String deleteStyle(@PathVariable(name = "id") int id) {
        styleService.deleteStyle(id);

        return "Style with id " + id + " was deleted";
    }
}