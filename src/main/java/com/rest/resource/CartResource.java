/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.resource;

import com.entities.Cart;
import com.entities.Confirm;
import com.entities.Item;
import com.rest.model.Order;
import com.rest.model.Product;
import com.rest.service.OrderService;
import com.rest.service.ProductService;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Kati
 */
@Path("/cart")
public class CartResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTodo(Cart cart) throws ClassNotFoundException, SQLException {
        if(ProductService.AddCart(cart)) {
            return Response.ok().entity("TODO Added Successfully").build();
        }
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
    
    //Similar to the method above.
    @POST
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED}) //This method accepts form parameters.
    //If you were to send a POST through a form submit, this method would be called.
    public Response addTodo(@FormParam("summary") String summary,
                            @FormParam("description") String description) throws ClassNotFoundException, SQLException {
        Cart cart = new Cart(summary, description);
        
        System.out.println(cart);

        if(ProductService.AddCart(cart)) {
            return null;
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCartItems() throws SQLException, ClassNotFoundException {
        ArrayList<Product> cart = ProductService.GetCartItems();
        if(cart.size() > 0)
            return Response.ok(cart).build();
        else
            return Response.status(Response.Status.NO_CONTENT).build();
    }

    @Path("/receipt")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerInfo() throws SQLException, ClassNotFoundException {
        Order o = OrderService.GetMostRecentOrder();
        return Response.ok(o).build();
    }
    
    //This method represents a DELETE request where the id is provided as a path parameter and the request body is provided in JSON
    @DELETE
    @Path("/delete")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    public Response deleteTodo() throws ClassNotFoundException, SQLException {

        // This calls the JDBC method which in turn calls the DELETE SQL command.
        if(ProductService.ClearCart()) {
            return Response.ok().entity("TODO Deleted Successfully").build();
        }

        //return Response.ok().entity("Die in a hole").build();
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

    }
    
}

