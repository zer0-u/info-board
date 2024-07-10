package com.example.persistence.entity;

public class Image {

    private Integer id;
    //    private Integer articleId;
    private String name;
    private String schema;
    private byte[] image;

    public Image() {
    }

    public Image(Integer id, String name, String schema, byte[] image) {
        this.id = id;
        this.name = name;
        this.schema = schema;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
