package com.queries;

import com.project4.utils.*;
import com.entities.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemQueries {

    public static Item getItemById(String id) throws SQLException, ClassNotFoundException {
        Database db = new Database();
        db.openConnection();
        ResultSet resultSet = db.executeQuery("SELECT * FROM items WHERE id=" + id);
        resultSet.next();
        Item item = new Item(
                resultSet.getString("id"),
                resultSet.getString("picture"),
                resultSet.getString("picture2"),
                resultSet.getString("name"),
                resultSet.getInt("price"),
                resultSet.getString("type"),
                resultSet.getString("color"),
                resultSet.getString("descrip"),
                resultSet.getString("size")
        );
        db.closeConnection();
        return item;
    }


    public static ArrayList<Item> getAllItems() throws SQLException, ClassNotFoundException {
        Database db = new Database();
        db.openConnection();
        ResultSet resultSet = db.executeQuery("SELECT * FROM items");
        ArrayList<Item> items = new ArrayList<Item>();
        while(resultSet.next()){
            items.add(
                new Item(
                    resultSet.getString("id"),
                    resultSet.getString("picture"),
                    resultSet.getString("picture2"),
                    resultSet.getString("name"),
                    resultSet.getInt("price"),
                    resultSet.getString("type"),
                    resultSet.getString("color"),
                    resultSet.getString("descrip"),
                    resultSet.getString("size")
                )
            );
        }
        db.closeConnection();
        return items;
    }


}