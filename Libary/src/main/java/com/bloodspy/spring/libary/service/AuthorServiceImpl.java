package com.bloodspy.spring.libary.service;

import com.bloodspy.spring.libary.dao.AuthorRepository;
import com.bloodspy.spring.libary.entity.AuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    AuthorRepository authorRepository;


    @Override
    public List<AuthorEntity> getAllAuthor() {
        List<AuthorEntity> authors = authorRepository.findAll();

        return authors;
    }

    @Override
    public AuthorEntity getAuthor(int id) {
        AuthorEntity author = authorRepository.findById(id).orElse(null);

        return author;
    }

    @Override
    public AuthorEntity saveAuthor(AuthorEntity author) {
        author = authorRepository.save(author);

        return author;
    }

    @Override
    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }
}
