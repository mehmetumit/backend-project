package com.demo.app.daoImpl;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.dao.SupplierDAO;
import com.demo.app.models.Supplier;

public interface SupplierDAOImpl extends SupplierDAO{

    @Override
    int delete(Supplier obj) throws SQLException;

    @Override
    Supplier get(long id) throws SQLException;

    @Override
    List<Supplier> getAll() throws SQLException;

    @Override
    int insert(Supplier obj) throws SQLException;

    @Override
    int save(Supplier obj) throws SQLException;

    @Override
    int update(Supplier obj) throws SQLException;

}