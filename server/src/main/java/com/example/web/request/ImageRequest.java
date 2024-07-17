package com.example.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Arrays;

public class ImageRequest {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String header;

    @NotNull
    private byte[] base64;

    public ImageRequest(String name, String header, byte[] base64) {
        this.name = name;
        this.header = header;
        this.base64 = base64;
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

    @Override
    public String toString() {
        return "ImageRequest{" +
                "name='" + name + '\'' +
                ", header='" + header + '\'' +
                ", base64=" + Arrays.toString(base64) +
                '}';
    }
}
