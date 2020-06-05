package com.entities;

//You will need to create a Java Object. Jersey uses these to contruct requests and responses.

public class Cart {
    private String sid;
    private String itemname;
    private int id;
   
    public Cart(String sid, String itemname) {
       this.sid = sid;
       this.itemname = itemname;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String summary) {
        this.sid = summary;
    }

    public String getItemName() {
        return itemname;
    }

    public void setItemName(String description) {
        this.itemname = description;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}