package com.bloodspy.spring.libary.service;

import com.bloodspy.spring.libary.dao.ReaderRepository;
import com.bloodspy.spring.libary.exceptionHandler.exceptions.NoSuchElementException;
import com.bloodspy.spring.libary.model.Author;
import com.bloodspy.spring.libary.model.Reader;
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
public class ReaderService {
    private final String entityName = "Reader";

    @Autowired
    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    ReaderRepository readerRepository;

    public ResponseEntity<Page<Reader>> getAllReader(int page, int size) {
        AppUtils.validatePageNumberAndSize(page, size);
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, AppConstant.ID);

        Page<Reader> readers = readerRepository.findAll(pageable);

        return new ResponseEntity<>(readers, HttpStatus.OK);
    }

    public ResponseEntity<Reader> getReader(int id) {
        Reader reader = readerRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(entityName, id)
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
                () -> new NoSuchElementException(entityName, id)
        );

        readerRepository.delete(reader);

        return new ResponseEntity<>("Reader was deleted", HttpStatus.OK);
    }
}
