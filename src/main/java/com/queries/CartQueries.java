/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.queries;

import com.entities.Cart;
import com.project4.utils.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kati
 */
public class CartQueries {
    public static Cart getCartItemById(String id) throws SQLException, ClassNotFoundException {
        Database db = new Database();
        db.openConnection();
        ResultSet resultSet = db.executeQuery("SELECT * FROM shoppingcart WHERE sid = '" + id + "'");
        resultSet.next();
        Cart cart = new Cart(resultSet.getString("sid"), resultSet.getString("itemname"));
        db.closeConnection();
        return cart;
    }


    public static ArrayList<Cart> getAllCartItems() throws SQLException, ClassNotFoundException {
        Database db = new Database();
        db.openConnection();
        ResultSet resultSet = db.executeQuery("SELECT * FROM shoppingcart");
        ArrayList<Cart> items = new ArrayList<Cart>();
        while(resultSet.next()){
            items.add(
                new Cart(
                    resultSet.getString("sid"),
                    resultSet.getString("itemname")
                )
            );
        }
        db.closeConnection();
        return items;
    }
}
