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
import javax.ws.rs.core.Response;

import com.demo.app.models.dtos.InvoiceDTO;
import com.demo.app.services.abstracts.InvoiceService;
import com.demo.app.services.implementations.InvoiceServiceImpl;

/**
 * InvoiceController
 */
@Path("invoices")
public class InvoiceController {
	private static InvoiceService invoiceService = new InvoiceServiceImpl();

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response all() {
		List<InvoiceDTO> invoices = invoiceService.getAll();
		if (invoices != null && !invoices.isEmpty())
			return Response.ok(invoices).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Invoices not found").build();

	}

	@GET
	@Path("/q")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBy(@QueryParam("invoice_timestamp") Timestamp invoiceTimestamp,
			@QueryParam("due_timestamp") Timestamp dueTimestamp,
			@QueryParam("sub_total") Double subTotal,
			@QueryParam("discount") Double discount,
			@QueryParam("tax_rate") Integer taxRate,
			@QueryParam("total_tax") Integer totalTax,
			@QueryParam("total_price") Double totalPrice) {
		// HashMap<String, Object> dataMap = customerService.getDataMap();
		HashMap<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("invoiceTimestamp", invoiceTimestamp);
		dataMap.put("dueTimestamp", dueTimestamp);
		dataMap.put("subTotal", subTotal);
		dataMap.put("discount", discount);
		dataMap.put("taxRate", taxRate);
		dataMap.put("totalTax", totalTax);
		dataMap.put("totalPrice", totalPrice);

		List<InvoiceDTO> invoices = invoiceService.findAll(dataMap);
		if (invoices != null && !invoices.isEmpty())
			return Response.ok(invoices).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Invoices not found").build();
	}

	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response oneById(@PathParam("id") int id) {
		InvoiceDTO invoice = invoiceService.getById(id);

		if (invoice != null)
			return Response.ok(invoice).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Invoice " + id + " not found").build();

	}

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response newInvoice(InvoiceDTO invoice) {
		boolean success = invoiceService.add(invoice) == 1 ? true : false;
		if (success)
			return Response.ok(invoice).build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Invoice adding failed").build();

	}

	@PUT
	@Path("id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateInvoice(@PathParam("id") int id, InvoiceDTO invoice) {
		boolean success = invoiceService.update(id, invoice) == 1 ? true : false;
		if (success)
			return Response.ok(invoiceService.getById(id)).build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Invoice updating failed").build();
	}

	@DELETE
	@Path("id/{id}")
	public Response deleteInvoice(@PathParam("id") int id) {
		boolean success = invoiceService.delete(id) == 1 ? true : false;
		if (success)
			return Response.ok("Invoice " + id + " deleted").build();
		else
			return Response.status(Response.Status.BAD_REQUEST).entity("Invoice deletion failed").build();

	}

}
