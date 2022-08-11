package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.demo.app.repository.dao.OrderDAO;
import com.demo.app.models.entities.Order;

public class OrderDAOImpl implements OrderDAO {

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
    public int delete(long id) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Order> findByTimestamp(Timestamp timestamp) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
