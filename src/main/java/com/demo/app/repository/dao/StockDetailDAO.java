package com.demo.app.repository.dao;

import java.sql.SQLException;
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
    void insert(StockDetail obj) throws SQLException;

    @Override
    void update(StockDetail obj) throws SQLException;

    public List<StockDetail> findByQuantity(int quantity) throws SQLException;

}
