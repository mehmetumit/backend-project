package com.demo.app.repository.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.app.services.DatabaseService;
import com.demo.app.repository.dao.CustomerDAO;
import com.demo.app.models.entities.Customer;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public int delete(Customer customer) throws SQLException {
        Connection conn = DatabaseService.getConnection();
        String query = "DELETE FROM customer WHERE customer_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setLong(1, customer.getId());

        int result = ps.executeUpdate();

        DatabaseService.closePreparedStatement(ps);
        DatabaseService.closeConnection(conn);

        return result;
    }

    @Override
    public Customer findById(long id) throws SQLException {
        Connection conn = DatabaseService.getConnection();
        String query = "SELECT * FROM customer WHERE customer_id = " + id;

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        Customer customer = null;
        if (rs.next()) {
            customer = new Customer(rs.getLong("customer_id"),
                    rs.getString("customer_name"),
                    rs.getString("surname"),
                    rs.getString("phone_num"),
                    rs.getString("email"),
                    rs.getInt("discount_rate"),
                    rs.getBoolean("is_active"));

        }

        // We no longer need them
        DatabaseService.closeResultSet(rs);
        DatabaseService.closeStatement(st);

        return customer;
    }

    @Override
    public List<Customer> findAll() throws SQLException {
        Connection conn = DatabaseService.getConnection();
        String query = "SELECT * FROM customer";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        List<Customer> allCustomers = new ArrayList<Customer>();
        while (rs.next()) {
            allCustomers.add(new Customer(rs.getLong("customer_id"),
                    rs.getString("customer_name"),
                    rs.getString("surname"),
                    rs.getString("phone_num"),
                    rs.getString("email"),
                    rs.getInt("discount_rate"),
                    rs.getBoolean("is_active")));
        }
        return allCustomers;
    }

    @Override
    public int insert(Customer customer) throws SQLException {
        Connection conn = DatabaseService.getConnection();
        String query = "INSERT INTO customer(customer_id, customer_name, surname, phone_num, email, discount_rate, is_active) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setLong(1, customer.getId());
        ps.setString(2, customer.getName());
        ps.setString(3, customer.getSurname());
        ps.setString(4, customer.getPhoneNum());
        ps.setString(5, customer.getEmail());
        ps.setInt(6, customer.getDiscountRate());
        ps.setBoolean(7, customer.isActive());

        int result = ps.executeUpdate();

        DatabaseService.closePreparedStatement(ps);
        DatabaseService.closeConnection(conn);

        return result;
    }

    @Override
    public int update(Customer customer) throws SQLException {
        Connection conn = DatabaseService.getConnection();
        String query = "UPDATE customer SET customer_name = ?, surname = ?, phone_num = ?, email = ?, discount_rate = ?, is_active = ? WHERE customer_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1, customer.getName());
        ps.setString(2, customer.getSurname());
        ps.setString(3, customer.getPhoneNum());
        ps.setString(4, customer.getEmail());
        ps.setInt(5, customer.getDiscountRate());
        ps.setBoolean(6, customer.isActive());
        ps.setLong(7, customer.getId());

        int result = ps.executeUpdate();

        return result;
    }

    @Override
    public Customer findByName(String name) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
