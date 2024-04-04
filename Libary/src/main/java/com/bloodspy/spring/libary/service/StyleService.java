package com.bloodspy.spring.libary.service;

import com.bloodspy.spring.libary.entity.StyleEntity;

import java.util.List;

public interface StyleService {
    public List<StyleEntity> getAllStyle();

    public StyleEntity getStyle(int id);

    public void saveStyle(StyleEntity style);

    public void deleteStyle(int id);
}
