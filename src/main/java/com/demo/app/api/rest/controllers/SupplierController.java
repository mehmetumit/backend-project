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

import com.demo.app.models.dtos.SupplierDTO;
import com.demo.app.services.abstracts.SupplierService;
import com.demo.app.services.implementations.SupplierServiceImpl;

/**
 * SupplierController
 */
@Path("suppliers")
public class SupplierController {
	private static SupplierService supplierService = new SupplierServiceImpl();

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response all() {
		List<SupplierDTO> suppliers = supplierService.getAll();
		if (suppliers != null && !suppliers.isEmpty())
			return Response.ok(suppliers).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Suppliers not found").build();
	}

	@GET
	@Path("/q")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBy(@QueryParam("address") String address,
			@QueryParam("phone_num") String phoneNum,
			@QueryParam("name") String name,
			@QueryParam("is_active") Boolean isActive,
			@QueryParam("stock_detail_id") Integer stockDetailId) {

		HashMap<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("address", address);
		dataMap.put("name", name);
		dataMap.put("phoneNum", phoneNum);
		dataMap.put("isActive", isActive);
		dataMap.put("stockDetailId", stockDetailId);

		List<SupplierDTO> suppliers = supplierService.findAll(dataMap);
		if (suppliers != null && !suppliers.isEmpty())
			return Response.ok(suppliers).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Suppliers not found").build();
	}

	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response oneById(@PathParam("id") int id) {
		SupplierDTO supplier = supplierService.getById(id);

		if (supplier != null)
			return Response.ok(supplier).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Supplier " + id + " not found").build();

	}

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newSupplier(SupplierDTO supplier) {
		SupplierDTO addedSupplier = supplierService.add(supplier);
		if (Objects.nonNull(addedSupplier))
			return Response.ok(addedSupplier).build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Supplier adding failed").build();

	}

	@PUT
	@Path("id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSupplier(@PathParam("id") int id, SupplierDTO supplier) {
		SupplierDTO updatedSupplier = supplierService.update(id, supplier);
		if (Objects.nonNull(updatedSupplier))
			return Response.ok(updatedSupplier).build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Supplier updating failed").build();
	}

	@DELETE
	@Path("id/{id}")
	public Response deleteSupplier(@PathParam("id") int id) {
		boolean success = supplierService.delete(id) == 1 ? true : false;
		if (success)
			return Response.ok("Supplier " + id + " deleted").build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Supplier deletion failed").build();

	}

}
