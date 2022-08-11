package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.repository.dao.OrderDetailsDAO;
import com.demo.app.models.entities.OrderDetails;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {

    @Override
    public OrderDetails findById(long id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<OrderDetails> getAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insert(OrderDetails obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(OrderDetails obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(long id) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<OrderDetails> findByQuantity(int quantity) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
