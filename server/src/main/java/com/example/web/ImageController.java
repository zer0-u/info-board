package com.example.web;

import com.example.persistence.entity.Image;
import com.example.service.ImageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {

    private final ImageService service;

    public ImageController(ImageService service) {
        this.service = service;
    }

    @GetMapping
    public List<Image> getAll() {
        return service.getAllImages();
    }

    @GetMapping("/{id}")
    public Image getImage(@PathVariable Integer id) {
        return service.getImageById(id);
    }
}
