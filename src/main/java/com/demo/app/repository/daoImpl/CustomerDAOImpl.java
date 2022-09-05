package com.demo.app.repository.daoImpl;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import com.demo.app.repository.DatabaseEngine;
import com.demo.app.repository.QueryEngine;
import com.demo.app.repository.dao.CustomerDAO;

import org.hibernate.Session;

import jakarta.persistence.Column;

import com.demo.app.models.entities.Customer;
import com.demo.app.models.entities.Order;

public class CustomerDAOImpl implements CustomerDAO {
    DatabaseEngine databaseEngine = DatabaseEngine.getEngine();

    @Override
    public String getEntityName() {
        return Customer.class.getSimpleName();
    }

    @Override
    public void delete(int id) throws SQLException {
        databaseEngine.delete(findById(id));
    }

    @Override
    public Customer findById(int id) throws SQLException {
        return databaseEngine.findById(Customer.class, id);
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Customer> queryEngine = new QueryEngine<Customer>();
        String query = queryEngine.from(Customer.class).build();

        List<Customer> customers = session.createQuery(query, Customer.class).list();
        session.close();

        return customers;
    }

    @Override
    public void insert(Customer customer) throws SQLException {
        databaseEngine.merge(customer);
    }

    @Override
    public void update(Customer customer) throws SQLException {
        Customer updatedCustomer = findById(customer.getId());
        updatedCustomer
                .setName(Objects.nonNull(customer.getName()) ? customer.getName()
                        : updatedCustomer.getName())
                .setSurname(Objects.nonNull(customer.getSurname()) ? customer.getSurname()
                        : updatedCustomer.getSurname())
                .setPhoneNum(Objects.nonNull(customer.getPhoneNum()) ? customer.getPhoneNum()
                        : updatedCustomer.getPhoneNum())
                .setEmail(Objects.nonNull(customer.getEmail()) ? customer.getEmail() : updatedCustomer.getEmail())
                .setDiscountRate(Objects.nonNull(customer.getDiscountRate()) ? customer.getDiscountRate()
                        : updatedCustomer.getDiscountRate())
                .setOrders(!customer.getOrders().isEmpty() ? customer.getOrders()
                        : updatedCustomer.getOrders())
                .setActive(Objects.nonNull(customer.isActive()) ? customer.isActive()
                        : updatedCustomer.isActive());
        databaseEngine.merge(updatedCustomer);
    }

    @Override
    public List<Customer> findByName(String name) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Customer> queryEngine = new QueryEngine<Customer>();
        String query = queryEngine.from(Customer.class).where().equal("name", name).build();

        List<Customer> customers = session.createQuery(query, Customer.class).list();
        session.close();

        return customers;
    }

    @Override
    public List<Customer> findBySurname(String surname) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Customer> queryEngine = new QueryEngine<Customer>();
        String query = queryEngine.from(Customer.class).where().equal("surname", surname).build();

        List<Customer> customers = session.createQuery(query, Customer.class).list();
        session.close();

        return customers;
    }

    @Override
    public List<Customer> findByPhoneNum(String phoneNum) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Customer> queryEngine = new QueryEngine<Customer>();
        String query = queryEngine.from(Customer.class).where().equal("phone_num", phoneNum).build();

        List<Customer> customers = session.createQuery(query, Customer.class).list();
        session.close();

        return customers;
    }

    @Override
    public List<Customer> findByEmail(String email) throws SQLException {
        Session session = databaseEngine.getCurrentSession();
        QueryEngine<Customer> queryEngine = new QueryEngine<Customer>();
        String query = queryEngine.from(Customer.class).where().equal("email", email).build();

        List<Customer> customers = session.createQuery(query, Customer.class).list();
        session.close();

        return customers;
    }

    @Override
    public List<Customer> findByActive(boolean isActive) throws SQLException {
        Session session = databaseEngine.getCurrentSession();
        QueryEngine<Customer> queryEngine = new QueryEngine<Customer>();

        String query = queryEngine.from(Customer.class).where().equal("is_active", isActive).build();

        List<Customer> customers = session.createQuery(query, Customer.class).list();
        session.close();

        return customers;
    }

    @Override
    public List<Customer> findByDiscountRate(int discountRate) throws SQLException {
        Session session = databaseEngine.getCurrentSession();
        QueryEngine<Customer> queryEngine = new QueryEngine<Customer>();

        String query = queryEngine.from(Customer.class).where().equal("discount_rate", discountRate).build();

        List<Customer> customers = session.createQuery(query, Customer.class).list();
        session.close();

        return customers;
    }

    @Override
    public List<Customer> findAll(HashMap<String, Object> customerData) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Customer> queryEngine = new QueryEngine<Customer>();

        String query;
        queryEngine.from(Customer.class);
        if (customerData.get("orderId") != null) {
            customerData.put("o.id", customerData.get("orderId"));
            customerData.remove("orderId");
            queryEngine.joinAs("orders", "o");
        }
        query = queryEngine.whereEqualEntityDataMap(customerData).build();

        System.out.println(query);
        List<Customer> customers = session.createQuery(query, Customer.class).list();

        session.close();

        return customers;
    }

}
