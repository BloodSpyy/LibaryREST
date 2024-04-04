package com.bloodspy.spring.libary.service;

import com.bloodspy.spring.libary.entity.LibaryCardEntity;

import java.util.List;

public interface LibaryCardService {
    public List<LibaryCardEntity> getAllLibaryCard();

    public LibaryCardEntity getLibaryCard(int id);

    public LibaryCardEntity saveLibaryCard(LibaryCardEntity libaryCard);

    public void deleteLibaryCard(int id);
}
