package com.entities;

public class Confirm {
    String itemName;
    String amount;
    String first;
    String last;
    String phone;
    String street;
    String city;
    String state;
    String zipecode;
    String speed;
    String credit;
    String expire;
    String ccv;

    public Confirm(String itemName, String amount, String first, String last, String phone, String street, String city, String state, String zipecode, String speed, String credit, String expire, String ccv) {
        this.itemName = itemName;
        this.amount = amount;
        this.first = first;
        this.last = last;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipecode = zipecode;
        this.speed = speed;
        this.credit = credit;
        this.expire = expire;
        this.ccv = ccv;
    }

    public String getItemName() {
        return itemName;
    }

    public String getAmount() {
        return amount;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getPhone() {
        return phone;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipecode() {
        return zipecode;
    }

    public String getSpeed() {
        return speed;
    }

    public String getCredit() {
        return credit;
    }

    public String getExpire() {
        return expire;
    }

    public String getCcv() {
        return ccv;
    }

    public String toInsertValue(){
        return String.format("('%s','%s','%s','%s','%s','%s','%s','%s','%s')",first, last, phone, street, city, state, zipecode, speed, credit, expire, ccv);
    }
}
