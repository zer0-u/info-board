package com.example.web;

import com.example.persistence.entity.Image;
import com.example.service.ImageService;
import com.example.web.request.ImageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Void> addImage(@RequestBody ImageRequest request) {
        Image image = new Image(request);
        service.save(image);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .pathSegment(image.getId().toString())
                .build().encode()
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
