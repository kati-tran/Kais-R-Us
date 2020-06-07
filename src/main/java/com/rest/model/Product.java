/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.model;

/**
 *
 * @author nguyev12
 */

public class Product {
    String id;
    String picture;
    String picture2;
    String name;
    Integer price;
    String type;
    String color;
    String descrip;
    String size;

    public Product() {
    }

    public Product(String id, String picture, String picture2, String name, Integer price, String type, String color, String descrip, String size) {
        this.id = id;
        this.picture = picture;
        this.picture2 = picture2;
        this.name = name;
        this.price = price;
        this.type = type;
        this.color = color;
        this.descrip = descrip;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public String getPicture() {
        return picture;
    }

    public String getPicture2() {
        return picture2;
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

    public String getDescrip() {
        return descrip;
    }

    public String getSize() {
        return size;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setPicture2(String picture2) {
        this.picture2 = picture2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public void setSize(String size) {
        this.size = size;
    }
  
}
