package com.demo.app.api.rest.controllers;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.demo.app.models.dtos.OrderDTO;
import com.demo.app.services.abstracts.OrderService;
import com.demo.app.services.implementations.OrderServiceImpl;

/**
 * OrderController
 */
@Path("orders")
public class OrderController {
	private static OrderService orderService = new OrderServiceImpl();

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response all() {
		List<OrderDTO> orders = orderService.getAll();
		if (orders != null && !orders.isEmpty())
			return Response.ok(orders).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Orders not found").build();
	}

	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response oneById(@PathParam("id") int id) {
		OrderDTO order = orderService.getById(id);

		if (order != null)
			return Response.ok(order).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Order " + id + " not found").build();
	}

	@GET
	@Path("/q")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBy(@QueryParam("order_timestamp") Timestamp timestamp,
			@QueryParam("invoice_id") Integer invoiceId,
			@QueryParam("order_detail_id") Integer orderDetailId) {
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("orderTimestamp", timestamp);
		dataMap.put("invoiceId", invoiceId);
		dataMap.put("orderDetailId", orderDetailId);

		List<OrderDTO> orders = orderService.findAll(dataMap);
		if (orders != null && !orders.isEmpty())
			return Response.ok(orders).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Orders not found").build();
	}

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newOrder(OrderDTO order) {
		OrderDTO addedOrder = orderService.add(order);
		if (Objects.nonNull(addedOrder))
			return Response.ok(addedOrder).build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Order adding failed").build();

	}

	@PUT
	@Path("id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateOrder(@PathParam("id") int id, OrderDTO order) {
		OrderDTO updatedOrder = orderService.update(id, order);
		if (Objects.nonNull(updatedOrder))
			return Response.ok(updatedOrder).build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Order updating failed").build();
	}

	@DELETE
	@Path("id/{id}")
	public Response deleteOrder(@PathParam("id") int id) {
		boolean success = orderService.delete(id) == 1 ? true : false;
		if (success)
			return Response.ok("Order " + id + " deleted").build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Order deletion failed").build();

	}

}
