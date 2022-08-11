package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.repository.dao.SupplierDAO;
import com.demo.app.models.entities.Supplier;

public class SupplierDAOImpl implements SupplierDAO {

    @Override
    public Supplier findById(long id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Supplier> getAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insert(Supplier obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(Supplier obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(long id) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Supplier findByAddress(String address) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Supplier findByPhoneNum(String phoneNum) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Supplier> findByActive(boolean isActive) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
}
