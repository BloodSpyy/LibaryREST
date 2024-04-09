package com.bloodspy.spring.libary.service;

import com.bloodspy.spring.libary.dao.ReaderRepository;
import com.bloodspy.spring.libary.exceptionHandler.exceptions.NoSuchException;
import com.bloodspy.spring.libary.model.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {
    private final String entityName = "Reader";

    @Autowired
    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    ReaderRepository readerRepository;

    public List<Reader> getAllReader() {
        List<Reader> readers = readerRepository.findAll();

        return readers;
    }

    public ResponseEntity<Reader> getReader(int id) {
        Reader reader = readerRepository.findById(id).orElseThrow(
                () -> new NoSuchException(entityName, id)
        );

        return new ResponseEntity<>(reader, HttpStatus.OK);
    }

    public ResponseEntity<Reader> addReader(Reader reader) {
        reader = readerRepository.save(reader);

        return new ResponseEntity<>(reader, HttpStatus.CREATED);
    }

    public ResponseEntity<Reader> updateReader(Reader reader) {
        reader = readerRepository.save(reader);

        return new ResponseEntity<>(reader, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteReader(int id) {
        Reader reader = readerRepository.findById(id).orElseThrow(
                () -> new NoSuchException(entityName, id)
        );

        readerRepository.delete(reader);

        return new ResponseEntity<>("Reader was deleted", HttpStatus.OK);
    }
}
