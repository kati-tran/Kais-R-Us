package com.entities;

public class Item {
    String id;
    String firstPictureUrl;
    String secondPictureUrl;
    String name;
    Integer price;
    String type;
    String color;
    String description;
    String size;

    public Item(String id, String firstPictureUrl, String secondPictureUrl, String name, Integer price, String type,
                String color, String description, String size) {
        this.id = id;
        this.firstPictureUrl = firstPictureUrl;
        this.secondPictureUrl = secondPictureUrl;
        this.name = name;
        this.price = price;
        this.type = type;
        this.color = color;
        this.description = description;
        this.size = size;
    }

    public String toJson() {
        return "";
    }

    public String getId() {
        return id;
    }

    public String getFirstPictureUrl() {
        return firstPictureUrl;
    }

    public String getSecondPictureUrl() {
        return secondPictureUrl;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public String getSize() {
        return size;
    }
}