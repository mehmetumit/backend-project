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
        String query = "from " + getEntityName();

        List<Customer> customers = session.createQuery(query, Customer.class).list();
        session.close();

        return customers;
    }

    @Override
    public void insert(Customer customer) throws SQLException {
        databaseEngine.persist(customer);
    }

    @Override
    public void update(Customer customer) throws SQLException {
        System.out.println("DISCOUNT RATE: " + Objects.nonNull(customer.getDiscountRate()));
        Customer updatedCustomer = findById(customer.getId());
        updatedCustomer.setName(Objects.nonNull(customer.getName()) ? customer.getName()
                : updatedCustomer.getName())
                .setSurname(
                        Objects.nonNull(customer.getSurname()) ? customer.getSurname()
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
        String query = "from " + getEntityName() + " where name = " + name;

        List<Customer> customers = session.createQuery(query, Customer.class).list();
        session.close();

        return customers;
    }

    @Override
    public List<Customer> findBySurname(String surname) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " where surname = " + surname;

        List<Customer> customers = session.createQuery(query, Customer.class).list();
        session.close();

        return customers;
    }

    @Override
    public List<Customer> findByPhoneNum(String phoneNum) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " where phone_num = " + phoneNum;

        List<Customer> customers = session.createQuery(query, Customer.class).list();
        session.close();

        return customers;
    }

    @Override
    public List<Customer> findByEmail(String email) throws SQLException {
        Session session = databaseEngine.getCurrentSession();
        String query = "from " + getEntityName() + " where email = " + email;

        List<Customer> customers = session.createQuery(query, Customer.class).list();
        session.close();

        return customers;
    }

    @Override
    public List<Customer> findByActive(boolean isActive) throws SQLException {
        Session session = databaseEngine.getCurrentSession();
        String query = "from " + getEntityName() + " where is_active = " + isActive;

        List<Customer> customers = session.createQuery(query, Customer.class).list();
        session.close();

        return customers;
    }

    @Override
    public List<Customer> findByDiscountRate(int discountRate) throws SQLException {
        Session session = databaseEngine.getCurrentSession();
        String query = "from " + getEntityName() + " where discount_rate = " + discountRate;

        List<Customer> customers = session.createQuery(query, Customer.class).list();
        session.close();

        return customers;
    }

    @Override
    public List<Customer> findAll(HashMap<String, Object> customerData) throws SQLException {
        Session session = databaseEngine.openSession();

        QueryEngine<Customer> queryEngine = new QueryEngine<Customer>();
        String query = queryEngine.entityDataMapToQuery(customerData, Customer.class);
        List<Customer> customers = session.createQuery(query, Customer.class).list();

        session.close();

        return customers;
    }

    // @Override
    // public List<Order> findCustomerOrdersById(int id) throws SQLException {
    // Session session = databaseEngine.getCurrentSession();
    // String query = "select ord from " + getEntityName() + " c left join c.orders
    // ord where ord.customerId = " + id;

    // List<Order> customerOrders = session.createQuery(query, Order.class).list();
    // session.close();

    // return customerOrders;
    // }

}
