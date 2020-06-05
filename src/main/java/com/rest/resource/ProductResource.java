package com.rest.resource;

import com.rest.model.Product;
import com.rest.service.ProductService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyev12
 */

@Path("/product")
public class ProductResource {
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductById(@PathParam("id") String id) {
        Product product = ProductService.getProductById(id);
        
        if(product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
            }
        
        return Response.ok(product).build();
    }
}
