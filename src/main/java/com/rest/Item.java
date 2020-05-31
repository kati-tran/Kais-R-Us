package com.rest;

import com.queries.ItemQueries;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import com.google.gson.*;


@WebServlet(name = "Item", urlPatterns = "/v1/item")
public class Item extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()){
            String itemId = request.getParameter("itemId");
            if(itemId.length() < 1){
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
            else{
                try{
                    com.entities.Item item = ItemQueries.getItemById(itemId);
                    if(item == null){
                        out.println("no item found");
                        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    }
                    else{
                        response.setContentType("application/json");
                        out.println(new Gson().toJson(item));
                    }

                }
                catch(SQLException e){
                    out.println("sql exception");
                    out.println(e);
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
                catch(Exception e){
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
            }

        }
    }
}
