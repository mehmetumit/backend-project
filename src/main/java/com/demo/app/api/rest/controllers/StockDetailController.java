package com.demo.app.api.rest.controllers;

import java.util.HashMap;
import java.util.List;

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

import com.demo.app.models.dtos.StockDetailDTO;
import com.demo.app.services.abstracts.StockDetailService;
import com.demo.app.services.implementations.StockDetailServiceImpl;

/**
 * StockDetailController
 */
@Path("stock_details")
public class StockDetailController {
	private static StockDetailService stockDetailService = new StockDetailServiceImpl();

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response all() {
		List<StockDetailDTO> stockDetails = stockDetailService.getAll();
		if (stockDetails != null && !stockDetails.isEmpty())
			return Response.ok(stockDetails).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Stock Details not found").build();

	}

	@GET
	@Path("/q")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBy(@QueryParam("quantity") Integer quantity) {
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("quantity", quantity);

		List<StockDetailDTO> stockDetails = stockDetailService.findAll(dataMap);
		if (stockDetails != null && !stockDetails.isEmpty())
			return Response.ok(stockDetails).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Stock Details not found").build();
	}

	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response oneById(@PathParam("id") int id) {
		StockDetailDTO stockDetail = stockDetailService.getById(id);

		if (stockDetail != null)
			return Response.ok(stockDetail).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Stock Detail " + id + " not found").build();

	}

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newStockDetail(StockDetailDTO stockDetail) {
		boolean success = stockDetailService.add(stockDetail) == 1 ? true : false;
		if (success)
			return Response.ok(stockDetail).build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Stock Detail adding failed").build();

	}

	@PUT
	@Path("id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStockDetail(@PathParam("id") int id, StockDetailDTO stockDetail) {
		boolean success = stockDetailService.update(id, stockDetail) == 1 ? true : false;
		if (success)
			return Response.ok(stockDetailService.getById(id)).build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Stock Detail updating failed").build();
	}

	@DELETE
	@Path("id/{id}")
	public Response seleteStockDetail(@PathParam("id") int id) {
		boolean success = stockDetailService.delete(id) == 1 ? true : false;
		if (success)
			return Response.ok("Stock Detail " + id + " deleted").build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Stock Detail deletion failed").build();

	}

}
