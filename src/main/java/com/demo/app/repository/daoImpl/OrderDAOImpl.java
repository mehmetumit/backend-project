package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.repository.dao.OrderDAO;
import com.demo.app.models.entities.Order;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public int delete(Order obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Order findById(long id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Order> getAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insert(Order obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(Order obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Order findByName(String name) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
