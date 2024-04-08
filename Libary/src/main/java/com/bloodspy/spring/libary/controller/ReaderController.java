package com.bloodspy.spring.libary.controller;

import com.bloodspy.spring.libary.entity.ReaderEntity;
import com.bloodspy.spring.libary.exceptionHandler.exceptions.NoSuchException;
import com.bloodspy.spring.libary.returnMessage.ContainerReturnMessage;
import com.bloodspy.spring.libary.returnMessage.ReturnMessageHandler;
import com.bloodspy.spring.libary.service.ReaderService;
import com.bloodspy.spring.libary.service.ReaderServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@Tag(name = "Readers", description = "CRUD operations")
public class ReaderController {
    private final String entityName = "Reader";

    @Autowired
    public ReaderController(ReaderServiceImpl readerService,
                            ReturnMessageHandler returnMessageHandler) {
        this.readerService = readerService;
        this.returnMessageHandler = returnMessageHandler;
    }

    ReaderService readerService;
    ReturnMessageHandler returnMessageHandler;

    @GetMapping("/readers")
    public List<ReaderEntity> getAllReader() {
        List<ReaderEntity> readers = readerService.getAllReader();

        return readers;
    }

    @GetMapping("/readers/{id}")
    public ReaderEntity getReader(@PathVariable(name = "id") int id) {
        ReaderEntity reader = readerService.getReader(id);

        if(reader == null) {
            throw new NoSuchException(entityName, id);
        }

        return reader;
    }

    @PostMapping("/readers")
    public ContainerReturnMessage addReader(@RequestBody ReaderEntity reader) {
        readerService.saveReader(reader);

        return returnMessageHandler.getAddMessage(entityName, reader.getId());
    }

    @PutMapping("/readers")
    public ContainerReturnMessage updateReader(@RequestBody ReaderEntity reader) {
        readerService.saveReader(reader);

        return returnMessageHandler.getUpdateMessage(entityName, reader.getId());
    }

    @DeleteMapping("/readers/{id}")
    public ContainerReturnMessage deleteReader(@PathVariable(name = "id") int id) {
        ReaderEntity reader = readerService.getReader(id);

        if(reader == null) {
            throw new NoSuchException(entityName, id);
        }

        readerService.deleteReader(id);

        return returnMessageHandler.getDeleteMessage(entityName, reader.getId());
    }
}