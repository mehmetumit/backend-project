package com.demo.app;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.models.entities.Order;
import com.demo.app.repository.dao.CustomerDAO;
import com.demo.app.repository.daoImpl.CustomerDAOImpl;

class App {

	public static void main(String[] args) {
		CustomerDAO customerDAO = new CustomerDAOImpl();
		List<Order> orders;
		try {
			orders = customerDAO.findCustomerOrdersById(1);
			System.out.println(orders);
		} catch (SQLException ex) {
			System.out.println(ex);
		}

	}
}
