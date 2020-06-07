/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.resource;

import com.entities.Cart;
import com.entities.Item;
import com.rest.model.Product;
import com.rest.service.ProductService;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
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
}

