package com.demo.app.api.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.demo.app.models.dtos.CustomerDTO;
import com.demo.app.services.abstracts.CustomerService;
import com.demo.app.services.implementations.CustomerServiceImpl;

/**
 * CustomerController
 */
@Path("customers")
public class CustomerController {
	private static CustomerService customerService = new CustomerServiceImpl();

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response all() {
		return Response.ok(customerService.getAll()).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response oneById(@PathParam("id") int id) {
		return Response.ok(customerService.getById(id))
				// .header(name, value)
				.build();
	}

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newCustomer(CustomerDTO customer) {
		boolean success = customerService.add(customer) == 1 ? true : false;
		if (success)
			return Response.ok(customer).build();
		else
			return Response.ok("Customer adding failed").build();
	}

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCustomer(@PathParam("id") int id, CustomerDTO customer) {
		boolean success = customerService.update(id, customer) == 1 ? true : false;
		if (success)
			return Response.ok(customerService.getById(id)).build();
		else
			return Response.ok("Customer updating failed").build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteCustomer(@PathParam("id") int id) {
		boolean success = customerService.delete(id) == 1 ? true : false;
		if (success)
			return Response.ok("Customer " + id + " deleted").build();
		else
			return Response.ok("Customer deletion failed").build();

	}

}
