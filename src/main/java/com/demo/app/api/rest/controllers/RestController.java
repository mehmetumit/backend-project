package com.demo.app.api.rest.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * RestController
 */
@ApplicationPath("/rest")
public class RestController extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public RestController() {
		this.singletons.add(new CustomerController());
		this.singletons.add(new InvoiceController());
		this.singletons.add(new OrderController());
		this.singletons.add(new OrderDetailController());
		this.singletons.add(new ProductController());
		this.singletons.add(new SellerController());
		this.singletons.add(new StockDetailController());
		this.singletons.add(new SupplierController());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
