package com.bloodspy.spring.libary.controller;

import com.bloodspy.spring.libary.entity.StyleEntity;
import com.bloodspy.spring.libary.exceptionHandler.exceptions.NoSuchException;
import com.bloodspy.spring.libary.returnMessage.ContainerReturnMessage;
import com.bloodspy.spring.libary.returnMessage.ReturnMessageHandler;
import com.bloodspy.spring.libary.service.StyleService;
import com.bloodspy.spring.libary.service.StyleServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@Tag(name = "Styles", description = "CRUD operations")
public class StyleController {
    public final String entityName = "Style";

    @Autowired
    public StyleController(StyleServiceImpl styleService,
                           ReturnMessageHandler returnMessageHandler) {
        this.styleService = styleService;
        this.returnMessageHandler = returnMessageHandler;
    }

    StyleService styleService;
    ReturnMessageHandler returnMessageHandler;

    @GetMapping("/styles")
    public List<StyleEntity> getAllStyle() {
        List<StyleEntity> styles = styleService.getAllStyle();

        return styles;
    }

    @GetMapping("/styles/{id}")
    public StyleEntity getStyle(@PathVariable(name = "id") int id) {
        StyleEntity style = styleService.getStyle(id);

        if(style == null) {
            throw new NoSuchException(entityName, id);
        }

        return style;
    }

    @PostMapping("/styles")
    public ContainerReturnMessage addStyle(@RequestBody StyleEntity style) {
        styleService.saveStyle(style);

        return returnMessageHandler.getAddMessage(entityName, style.getId());
    }

    @PutMapping("/styles")
    public ContainerReturnMessage updateStyle(@RequestBody StyleEntity style) {
        styleService.saveStyle(style);

        return returnMessageHandler.getUpdateMessage(entityName, style.getId());
    }

    @DeleteMapping("/styles/{id}")
    public ContainerReturnMessage deleteStyle(@PathVariable(name = "id") int id) {
        StyleEntity style = styleService.getStyle(id);

        if(style == null) {
            throw new NoSuchException(entityName, id);
        }

        styleService.deleteStyle(id);

        return returnMessageHandler.getDeleteMessage(entityName, id);
    }
}