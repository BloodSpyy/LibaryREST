package com.bloodspy.spring.libary.dao;

import com.bloodspy.spring.libary.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Integer> {
}
