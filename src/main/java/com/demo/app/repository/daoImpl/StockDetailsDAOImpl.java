package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.repository.dao.StockDetailsDAO;
import com.demo.app.models.entities.StockDetails;

public class StockDetailsDAOImpl implements StockDetailsDAO {

    @Override
    public StockDetails findById(long id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<StockDetails> getAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insert(StockDetails obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(StockDetails obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(long id) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<StockDetails> findByQuantity(int quantity) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
}
