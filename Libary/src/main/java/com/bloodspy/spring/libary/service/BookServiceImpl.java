package com.bloodspy.spring.libary.service;

import com.bloodspy.spring.libary.dao.BookRepository;
import com.bloodspy.spring.libary.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    BookRepository bookRepository;

    @Override
    public List<BookEntity> getAllBook() {
        List<BookEntity> books = bookRepository.findAll();

        return books;
    }

    @Override
    public BookEntity getBook(int id) {
        BookEntity book = bookRepository.findById(id).orElse(null);

        return book;
    }

    @Override
    public void saveBook(BookEntity book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}
