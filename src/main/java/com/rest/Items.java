package com.rest;

import com.entities.Item;
import com.queries.ItemQueries;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import com.google.gson.*;

@WebServlet(name = "Items", urlPatterns = "/v1/items")
public class Items extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()){
            try{
                ArrayList<Item> items = ItemQueries.getAllItems();
                response.setContentType("application/json");
                out.println(new Gson().toJson(items));
            }
            catch(SQLException e){
                out.println("sql exception");
                out.println(e);
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
            catch(Exception e){
                out.println(e);
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }
}
