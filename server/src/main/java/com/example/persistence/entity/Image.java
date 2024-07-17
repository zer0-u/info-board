package com.example.persistence.entity;

import com.example.web.request.ImageRequest;

public class Image {

    private Integer id;
    private String name;
    private String header;
    private byte[] base64;

    public Image(ImageRequest request) {
        this.name = request.getName();
        this.header = request.getHeader();
        this.base64 = request.getBase64();
    }

    public Image(Integer id, String name, String header, byte[] base64) {
        this.id = id;
        this.name = name;
        this.header = header;
        this.base64 = base64;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public byte[] getBase64() {
        return base64;
    }
}
