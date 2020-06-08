/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.service;

import com.project4.utils.Database;
import com.rest.model.Order;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author viviannguyen
 */
public class OrderService {

    public static boolean AddOrder(Order order) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO confirm_order (FIRST_NAME, LAST_NAME, PHONE_NUMBER, STREET, CITY, STATE, ZIP, SHIPPING_SPEED, CCN, EXP, CVV, CONTENTS, TOTAL_PRICE)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Database database = new Database();
        database.openConnection();

        Connection connection = database.conn;
        return Database.performDBUpdate(connection, sql, order.getFirstName(), order.getLastName(), order.getPhoneNum(),
                order.getStreet(), order.getCity(), order.getState(), order.getZip(), order.getShippingMethod(),
                order.getCcn(), order.getExp(), order.getCvv(), order.getCartitems(), order.getTotal());

    }

    public static Order GetMostRecentOrder() throws SQLException, ClassNotFoundException {
        Database db = new Database();
        db.openConnection();
        ResultSet results = db.executeQuery("SELECT * FROM CONFIRM_ORDER Order By id DESC LIMIT 1");
        Order order = new Order();
        if (results.next()) {
            order.setFirstName(results.getString("FIRST_NAME"));
            order.setLastName(results.getString("LAST_NAME"));
            order.setPhoneNum(results.getString("PHONE_NUMBER"));
            order.setStreet(results.getString("STREET"));
            order.setCity(results.getString("CITY"));
            order.setState(results.getString("STATE"));
            order.setZip(results.getString("ZIP"));
            order.setShippingMethod(results.getString("SHIPPING_SPEED"));
            order.setCcn(results.getString("CCN"));
            order.setExp(results.getString("EXP"));
            order.setCvv(results.getString("CVV"));
            order.setCartitems(results.getString("CONTENTS"));
            order.setTotal(results.getString("TOTAL_PRICE"));
        }
        db.closeConnection();
        return order;
    }

}
