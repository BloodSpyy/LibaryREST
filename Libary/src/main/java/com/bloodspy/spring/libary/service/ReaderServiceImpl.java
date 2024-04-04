package com.bloodspy.spring.libary.service;

import com.bloodspy.spring.libary.dao.ReaderRepository;
import com.bloodspy.spring.libary.entity.ReaderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    public ReaderServiceImpl(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    ReaderRepository readerRepository;

    @Override
    public List<ReaderEntity> getAllReader() {
        List<ReaderEntity> readers = readerRepository.findAll();

        return readers;
    }

    @Override
    public ReaderEntity getReader(int id) {
        ReaderEntity reader = readerRepository.findById(id).orElse(null);

        return reader;
    }

    @Override
    public ReaderEntity saveReader(ReaderEntity reader) {

        reader = readerRepository.save(reader);

        return reader;
    }

    @Override
    public void deleteReader(int id) {
        readerRepository.deleteById(id);
    }
}
