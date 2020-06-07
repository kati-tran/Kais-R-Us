/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.resource;

import com.rest.model.Order;
import com.rest.service.OrderService;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author viviannguyen
 */
@Path("/confirm")
public class OrderResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addConfirm(Order order) throws ClassNotFoundException, SQLException {
        if (OrderService.AddOrder(order)) {
            return Response.ok().entity("Order Added Successfully").build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    @POST
    @Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
    public Response addConfirm(@FormParam("first_name") String first_name, @FormParam("last_name") String last_name,
            @FormParam("phone") String phone, @FormParam("address") String address, @FormParam("city") String city,
            @FormParam("state") String state, @FormParam("zip") String zip, @FormParam("shipping") String shipping,
            @FormParam("cardnum") String cardnum, @FormParam("expire") String expire,
            @FormParam("security") String security) throws ClassNotFoundException, SQLException {

        Order order = new Order(first_name, last_name, phone, address, city, state, zip, shipping, cardnum, expire,
                security);
        if (OrderService.AddOrder(order)) {
            return Response.ok().entity("Order Added Successfully").build();
        }

        System.out.println(order);

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

    }
}
