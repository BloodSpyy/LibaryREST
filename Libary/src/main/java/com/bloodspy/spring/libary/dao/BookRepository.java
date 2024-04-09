package com.bloodspy.spring.libary.dao;

import com.bloodspy.spring.libary.model.Author;
import com.bloodspy.spring.libary.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
