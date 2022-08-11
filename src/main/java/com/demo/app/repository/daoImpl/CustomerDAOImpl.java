package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.repository.dao.CustomerDAO;
import com.demo.app.models.entities.Customer;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public Customer findById(long id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insert(Customer obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(Customer obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(long id) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Customer> findByName(String name) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Customer> findBySurname(String name) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Customer> findByPhoneNum(String phoneNum) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Customer> findByEmail(String email) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Customer> findByActive(boolean isActive) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Customer> findByDiscountRate(int discountRate) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
