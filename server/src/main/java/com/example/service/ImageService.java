package com.example.service;

import com.example.persistence.ImageMapper;
import com.example.persistence.entity.Image;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    private final ImageMapper mapper;

    public ImageService(ImageMapper mapper) {
        this.mapper = mapper;
    }

    public Image getImageById(int id) {
        return mapper.getImageById(id);
    }

    public List<Image> getAllImages() {
        return mapper.findAll();
    }

    public void save(Image image) {
        mapper.insert(image);
    }
}
