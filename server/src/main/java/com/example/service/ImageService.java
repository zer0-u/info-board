package com.example.service;

import com.example.persistence.ImageMapper;
import com.example.persistence.entity.Image;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private final ImageMapper mapper;

    public ImageService(ImageMapper mapper) {
        this.mapper = mapper;
    }

    public Image getImageById(int id) {
        return mapper.getImageById(id);
    }
}
