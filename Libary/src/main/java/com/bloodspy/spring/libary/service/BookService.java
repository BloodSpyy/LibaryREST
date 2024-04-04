package com.bloodspy.spring.libary.service;

import com.bloodspy.spring.libary.entity.BookEntity;

import java.util.List;

public interface BookService {
    public List<BookEntity> getAllBook();

    public BookEntity getBook(int id);

    public void saveBook(BookEntity book);

    public void deleteBook(int id);
}
