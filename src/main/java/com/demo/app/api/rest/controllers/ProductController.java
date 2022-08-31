package com.demo.app.api.rest.controllers;

import java.sql.Timestamp;
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

import com.demo.app.models.dtos.ProductDTO;
import com.demo.app.services.abstracts.ProductService;
import com.demo.app.services.implementations.ProductServiceImpl;
import javax.ws.rs.core.Response;

/**
 * ProductController
 */
@Path("products")
public class ProductController {
	private static ProductService productService = new ProductServiceImpl();

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response all() {
		List<ProductDTO> products = productService.getAll();
		if (products != null)
			return Response.ok(products).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Products not found").build();
	}

	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response one(@PathParam("id") int id) {
		ProductDTO product = productService.getById(id);
		if (product != null)
			return Response.ok(product).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Product " + id + " not found").build();
	}

	@GET
	@Path("/q")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBy(@QueryParam("category_name") String categoryName,
			@QueryParam("name") String name,
			@QueryParam("unit_price") Double unitPrice,
			@QueryParam("is_active") Boolean isActive) {
		// HashMap<String, Object> dataMap = customerService.getDataMap();
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("categoryName", categoryName);
		dataMap.put("name", name);
		dataMap.put("unitPrice", unitPrice);
		dataMap.put("isActive", isActive);

		List<ProductDTO> orders = productService.findAll(dataMap);
		if (orders != null && !orders.isEmpty())
			return Response.ok(orders).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Orders not found").build();
	}

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newProduct(ProductDTO product) {
		boolean success = productService.add(product) == 1 ? true : false;
		if (success)
			return Response.ok(product).build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Product adding failed").build();

	}

	@PUT
	@Path("id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProduct(@PathParam("id") int id, ProductDTO product) {
		boolean success = productService.update(id, product) == 1 ? true : false;
		if (success)
			return Response.ok(productService.getById(id)).build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Product updating failed").build();
	}

	@DELETE
	@Path("id/{id}")
	public Response deleteProduct(@PathParam("id") int id) {
		boolean success = productService.delete(id) == 1 ? true : false;
		if (success)
			return Response.ok("Product " + id + " deleted").build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Product deletion failed").build();

	}

}
