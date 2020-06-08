/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.service;

import com.entities.Cart;
import com.rest.model.Product;
import com.project4.utils.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author viviannguyen
 */
public class ProductService {
    public static Product getProductById(String id) {
        try {
            // Establish connection to database.
            Class.forName("com.mysql.cj.jdbc.Driver");
            Database database = new Database();
            database.openConnection();
            Connection connection = database.conn;

            // Retrieve result from database.
            ResultSet results = database.executeQuery("SELECT * FROM items WHERE id = '" + id + "'");
            if (results != null) {
                while (results.next()) {

                    // Create and populate the Product Model (resource)
                    Product product = new Product();

                    product.setId(results.getString("id"));
                    product.setPicture(results.getString("picture"));
                    product.setPicture2(results.getString("picture2"));
                    product.setName(results.getString("name"));
                    product.setPrice(results.getInt("price"));
                    product.setType(results.getString("type"));
                    product.setColor(results.getString("color"));
                    product.setDescrip(results.getString("descrip"));
                    product.setSize(results.getString("size"));
                    database.closeConnection();

                    // Return Resource to the ProductResource handler.
                    return product;
                }
            }
            database.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean AddCart(Cart cart) throws ClassNotFoundException, SQLException {

        String sql = "INSERT INTO shoppingcart (sid, itemname)" + "VALUES (?, ?)";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Database database = new Database();
        database.openConnection();
        Connection connection = database.conn;
        return Database.performDBUpdate(connection, sql, cart.getSid(), cart.getItemName());

    }

    public static boolean ClearCart() throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM shoppingcart";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Database database = new Database();
        database.openConnection();
        Connection connection = database.conn;
        return Database.performDBUpdate(connection, sql);

    }

    public static ArrayList<Product> GetCartItems() throws ClassNotFoundException, SQLException {
        Database db = new Database();
        db.openConnection();
        ResultSet resultSet = db.executeQuery("SELECT * FROM shoppingcart JOIN items ON items.id = shoppingcart.sid");
        ArrayList<Product> cart = new ArrayList<>();
        if (resultSet != null) {
            while (resultSet.next()) {
                cart.add(new Product(resultSet.getString("id"), resultSet.getString("picture"),
                        resultSet.getString("picture2"), resultSet.getString("name"), resultSet.getInt("price"),
                        resultSet.getString("type"), resultSet.getString("color"), resultSet.getString("descrip"),
                        resultSet.getString("size")));
            }
        }

        db.closeConnection();
        return cart;
    }

}
