package com.bloodspy.spring.libary.service;

import com.bloodspy.spring.libary.entity.ReaderEntity;

import java.util.List;

public interface ReaderService {
    public List<ReaderEntity> getAllReader();

    public ReaderEntity getReader(int id);

    public ReaderEntity saveReader(ReaderEntity reader);

    public void deleteReader(int id);
}
