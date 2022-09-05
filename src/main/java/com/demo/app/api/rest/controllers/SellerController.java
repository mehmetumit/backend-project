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

import com.demo.app.models.dtos.SellerDTO;
import com.demo.app.services.abstracts.SellerService;
import com.demo.app.services.implementations.SellerServiceImpl;

/**
 * SellerController
 */
@Path("sellers")
public class SellerController {
	private static SellerService sellerService = new SellerServiceImpl();

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response all() {
		List<SellerDTO> sellers = sellerService.getAll();
		System.out.println(sellers);
		if (sellers != null && !sellers.isEmpty())
			return Response.ok(sellers).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Sellers not found").build();
	}

	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response oneById(@PathParam("id") int id) {
		SellerDTO seller = sellerService.getById(id);
		if (seller != null)
			return Response.ok(seller).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Seller " + id + " not found").build();
	}

	@GET
	@Path("/q")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBy(@QueryParam("address") String address,
			@QueryParam("phone_num") String phoneNum,
			@QueryParam("email") String email,
			@QueryParam("fax") String fax,
			@QueryParam("is_active") Boolean isActive,
			@QueryParam("invoice_id") Integer invoiceId) {
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("address", address);
		dataMap.put("phoneNum", phoneNum);
		dataMap.put("email", email);
		dataMap.put("fax", fax);
		dataMap.put("isActive", isActive);
		dataMap.put("invoiceId", invoiceId);

		List<SellerDTO> sellers = sellerService.findAll(dataMap);
		if (sellers != null && !sellers.isEmpty())
			return Response.ok(sellers).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Sellers not found").build();

	}

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newSeller(SellerDTO seller) {
		SellerDTO addedSeller = sellerService.add(seller);
		if (Objects.nonNull(addedSeller))
			return Response.ok(addedSeller).build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Seller adding failed").build();

	}

	@PUT
	@Path("id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSeller(@PathParam("id") int id, SellerDTO seller) {
		SellerDTO updatedSeller = sellerService.update(id, seller);
		if (Objects.nonNull(updatedSeller))
			return Response.ok(updatedSeller).build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Seller updating failed").build();
	}

	@DELETE
	@Path("id/{id}")
	public Response deleteInvoice(@PathParam("id") int id) {
		boolean success = sellerService.delete(id) == 1 ? true : false;
		if (success)
			return Response.ok("Seller " + id + " deleted").build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Seller deletion failed").build();

	}

}
