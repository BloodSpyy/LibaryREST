package com.bloodspy.spring.libary.dao;

import com.bloodspy.spring.libary.entity.ReaderEntity;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<ReaderEntity, Integer> {
}
