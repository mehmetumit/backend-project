package com.demo.app.api.rest.controllers;

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

import com.demo.app.models.dtos.OrderDetailDTO;
import com.demo.app.services.abstracts.OrderDetailService;
import com.demo.app.services.implementations.OrderDetailServiceImpl;

/**
 * OrderDetailController
 */
@Path("order_details")
public class OrderDetailController {
	private static OrderDetailService orderDetailService = new OrderDetailServiceImpl();

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response all() {
		List<OrderDetailDTO> orderDetails = orderDetailService.getAll();
		if (orderDetails != null && !orderDetails.isEmpty())
			return Response.ok(orderDetails).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Order Details not found").build();

	}

	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response oneById(@PathParam("id") int id) {
		OrderDetailDTO orderDetail = orderDetailService.getById(id);

		if (orderDetail != null)
			return Response.ok(orderDetail).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Order Detail " + id + " not found").build();
	}

	@GET
	@Path("/q")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBy(@QueryParam("quantity") Integer quantity,
			@QueryParam("product_id") Integer productId) {
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("quantity", quantity);
		dataMap.put("productId", productId);

		List<OrderDetailDTO> orderDetails = orderDetailService.findAll(dataMap);
		if (orderDetails != null && !orderDetails.isEmpty())
			return Response.ok(orderDetails).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Order Details not found").build();
	}

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newOrderDetail(OrderDetailDTO orderDetail) {
		OrderDetailDTO addedOrderDetail = orderDetailService.add(orderDetail);
		if (Objects.nonNull(addedOrderDetail))
			return Response.ok(addedOrderDetail).build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("OrderDetail adding failed").build();

	}

	@PUT
	@Path("id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateOrderDetail(@PathParam("id") int id, OrderDetailDTO orderDetail) {
		OrderDetailDTO updatedOrderDetail = orderDetailService.update(id, orderDetail);
		if (Objects.nonNull(updatedOrderDetail))
			return Response.ok(updatedOrderDetail).build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Order Detail updating failed").build();
	}

	@DELETE
	@Path("id/{id}")
	public Response deleteOrderDetail(@PathParam("id") int id) {
		boolean success = orderDetailService.delete(id) == 1 ? true : false;
		if (success)
			return Response.ok("Order Detail " + id + " deleted").build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Order Detail deletion failed").build();

	}
}
