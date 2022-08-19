package com.demo.app.api.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.demo.app.models.dtos.CustomerDTO;
import com.demo.app.services.abstracts.CustomerService;
import com.demo.app.services.implementations.CustomerServiceImpl;

/**
 * CustomerController
 */
@Path("customerDemo")
public class CustomerController {
	private static CustomerService customerService = new CustomerServiceImpl();

	@GET
	@Path("info")
	@Produces(MediaType.APPLICATION_JSON)
	public Response demoCustomer() {
		return Response.ok().build();
		// return Response.ok(customerService.getById(1).getName()).build();
	}

}
