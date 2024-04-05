package com.bloodspy.spring.libary.controller;

import com.bloodspy.spring.libary.entity.LibaryCardEntity;
import com.bloodspy.spring.libary.exceptionHandler.exceptions.NoSuchException;
import com.bloodspy.spring.libary.returnMessage.ContainerReturnMessage;
import com.bloodspy.spring.libary.returnMessage.ReturnMessageHandler;
import com.bloodspy.spring.libary.service.LibaryCardService;
import com.bloodspy.spring.libary.service.LibaryCardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class LibaryCardController {
    private final String entityName = "Libary card";

    @Autowired
    public LibaryCardController(LibaryCardServiceImpl libaryCardService,
                                ReturnMessageHandler returnMessageHandler) {
        this.libaryCardService = libaryCardService;
        this.returnMessageHandler = returnMessageHandler;
    }

    LibaryCardService libaryCardService;
    ReturnMessageHandler returnMessageHandler;

    @GetMapping("/libaryCards")
    public List<LibaryCardEntity> getAllLibaryCard() {
        List<LibaryCardEntity> libaryCards = libaryCardService.getAllLibaryCard();

        return libaryCards;
    }

    @GetMapping("/libaryCards/{id}")
    public LibaryCardEntity getLibaryCard(@PathVariable(name = "id") int id) {
        LibaryCardEntity libaryCard = libaryCardService.getLibaryCard(id);

        if(libaryCard == null) {
            throw new NoSuchException(entityName, id);
        }

        return libaryCard;
    }

    @PostMapping("/libaryCards")
    public ContainerReturnMessage addLibaryCard(@RequestBody LibaryCardEntity libaryCard) {
        libaryCardService.saveLibaryCard(libaryCard);

        return returnMessageHandler.getAddMessage(entityName, libaryCard.getId());
    }

    @PutMapping("/libaryCards")
    public ContainerReturnMessage updateLibaryCard(@RequestBody LibaryCardEntity libaryCard) {
        libaryCardService.saveLibaryCard(libaryCard);

        return returnMessageHandler.getUpdateMessage(entityName, libaryCard.getId());
    }

    @DeleteMapping("/libaryCards/{id}")
    public ContainerReturnMessage removeLibaryCard(@PathVariable(name = "id") int id) {
        LibaryCardEntity libaryCard = libaryCardService.getLibaryCard(id);

        if(libaryCard == null) {
            throw new NoSuchException(entityName, id);
        }

        libaryCardService.deleteLibaryCard(id);

        return returnMessageHandler.getDeleteMessage(entityName, libaryCard.getId());
    }

}
