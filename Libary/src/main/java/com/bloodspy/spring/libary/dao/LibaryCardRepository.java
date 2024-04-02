package com.bloodspy.spring.libary.dao;

import com.bloodspy.spring.libary.entity.LibaryCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibaryCardRepository extends JpaRepository<LibaryCardEntity, Integer> {
}
