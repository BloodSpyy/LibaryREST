package com.bloodspy.spring.libary.dao;

import com.bloodspy.spring.libary.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
}
