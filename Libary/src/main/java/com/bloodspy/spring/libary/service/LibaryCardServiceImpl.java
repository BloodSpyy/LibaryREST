package com.bloodspy.spring.libary.service;

import com.bloodspy.spring.libary.dao.LibaryCardRepository;
import com.bloodspy.spring.libary.entity.LibaryCardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibaryCardServiceImpl implements LibaryCardService {
    @Autowired
    public LibaryCardServiceImpl(LibaryCardRepository libaryCardRepository) {
        this.libaryCardRepository = libaryCardRepository;
    }

    LibaryCardRepository libaryCardRepository;

    @Override
    public List<LibaryCardEntity> getAllLibaryCard() {
        List<LibaryCardEntity> libaryCards = libaryCardRepository.findAll();

        return libaryCards;
    }

    @Override
    public LibaryCardEntity getLibaryCard(int id) {
        LibaryCardEntity libaryCard = libaryCardRepository.findById(id).orElse(null);

        return libaryCard;
    }

    @Override
    public LibaryCardEntity saveLibaryCard(LibaryCardEntity libaryCard) {
        libaryCard = libaryCardRepository.save(libaryCard);

        return libaryCard;
    }

    @Override
    public void deleteLibaryCard(int id) {
        libaryCardRepository.deleteById(id);
    }
}
