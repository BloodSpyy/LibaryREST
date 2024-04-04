package com.bloodspy.spring.libary.service;

import com.bloodspy.spring.libary.dao.StyleRepository;
import com.bloodspy.spring.libary.entity.StyleEntity;
import org.hibernate.internal.build.AllowNonPortable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StyleServiceImpl implements StyleService{
    @Autowired
    public StyleServiceImpl(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    StyleRepository styleRepository;
    @Override
    public List<StyleEntity> getAllStyle() {
        List<StyleEntity> styles = styleRepository.findAll();

        return styles;
    }

    @Override
    public StyleEntity getStyle(int id) {
        StyleEntity style = styleRepository.findById(id).orElse(null);

        return style;
    }

    @Override
    public void saveStyle(StyleEntity style) {
        styleRepository.save(style);
    }

    @Override
    public void deleteStyle(int id) {
        styleRepository.deleteById(id);
    }
}
