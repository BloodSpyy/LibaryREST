package com.bloodspy.spring.libary.dao;

import com.bloodspy.spring.libary.model.LibaryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibaryCardRepository extends JpaRepository<LibaryCard, Integer> {
}
