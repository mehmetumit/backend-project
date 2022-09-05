package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.demo.app.models.entities.StockDetail;

public interface StockDetailDAO extends DAO<StockDetail> {

    @Override
    void delete(int id) throws SQLException;

    @Override
    StockDetail findById(int id) throws SQLException;

    @Override
    List<StockDetail> getAll() throws SQLException;

    @Override
    StockDetail insert(StockDetail obj) throws SQLException;

    @Override
    StockDetail update(StockDetail obj) throws SQLException;

    public List<StockDetail> findByQuantity(int quantity) throws SQLException;

    @Override
    public List<StockDetail> findAll(HashMap<String, Object> dataMap) throws SQLException;

}
