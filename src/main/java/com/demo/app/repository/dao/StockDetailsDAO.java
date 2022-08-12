package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.models.entities.StockDetails;

public interface StockDetailsDAO extends DAO<StockDetails> {

    @Override
    int delete(int id) throws SQLException;

    @Override
    StockDetails findById(int id) throws SQLException;

    @Override
    List<StockDetails> getAll() throws SQLException;

    @Override
    int insert(StockDetails obj) throws SQLException;

    @Override
    int update(StockDetails obj) throws SQLException;

    public List<StockDetails> findByQuantity(int quantity) throws SQLException;

}
