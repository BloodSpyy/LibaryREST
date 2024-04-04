package com.bloodspy.spring.libary.service;

import com.bloodspy.spring.libary.entity.AuthorEntity;

import java.util.List;

public interface AuthorService {
    public List<AuthorEntity> getAllAuthor();

    public AuthorEntity getAuthor(int id);

    public void saveAuthor(AuthorEntity author);

    public void deleteAuthor(int id);
}
