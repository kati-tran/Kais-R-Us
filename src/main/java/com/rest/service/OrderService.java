/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.service;

import com.project4.utils.Database;
import com.rest.model.Order;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viviannguyen
 */
public class OrderService {

    public static boolean AddOrder(Order order) throws SQLException {
        try {
            String sql = "INSERT INTO CONFIRM_ORDER" +
                    "VALUES(" + order.getFirstName() + "," +
                    order.getLastName() + "," +
                    order.getPhoneNum() + "," + 
                    order.getStreet() + "," +
                    order.getStreet() + "," +
                    order.getCity() + "," +
                    order.getState() + "," +
                    order.getZip() + "," +
                    order.getShippingMethod() + "," +
                    order.getCcn() +  "," +
                    order.getExp() +  "," +
                    order.getCvv() + ");"; //TODO add shopping cart
                    
            Class.forName("com.mysql.cj.jdbc.Driver");
            Database database = new Database();
            database.openConnection();
            
            Connection connection = database.conn;
            return Database.performDBUpdate(connection, sql);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
