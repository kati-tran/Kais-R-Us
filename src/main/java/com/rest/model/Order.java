/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.model;

/**
 * 
 * @author viviannguyen
 */
//ORDER POJO
public class Order {
    String firstName;
    String lastName;
    String phoneNum;
    String street;
    String city;
    String state;
    String zip;
    String shippingMethod;
    String ccn;
    String exp;
    String cvv;
    String cartitems;
    String total;

    public Order() {
    }

    public Order(String firstName, String lastName, String phoneNum, String street, String city, String state, String zip, String shippingMethod, String ccn, String exp, String cvv, String cartitems, String total) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.shippingMethod = shippingMethod;
        this.ccn = ccn;
        this.exp = exp;
        this.cvv = cvv;
        this.cartitems = cartitems;
        this.total = total;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
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

    public String getZip() {
        return zip;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public String getCcn() {
        return ccn;
    }

    public String getExp() {
        return exp;
    }

    public String getCvv() {
        return cvv;
    }

    public String getCartitems() {
        return cartitems;
    }

    public String getTotal() {
        return total;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public void setCcn(String ccn) {
        this.ccn = ccn;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setCartitems(String cartitems) {
        this.cartitems = cartitems;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
