package com.bloodspy.spring.libary.dao;

import com.bloodspy.spring.libary.entity.AuthorEntity;
import com.bloodspy.spring.libary.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
}
