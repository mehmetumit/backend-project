package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.repository.dao.SellerDAO;
import com.demo.app.models.entities.Seller;

public class SellerDAOImpl implements SellerDAO {

    @Override
    public Seller findById(long id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Seller> getAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insert(Seller obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(Seller obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(long id) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Seller findByAddress(String address) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Seller findByPhoneNum(String phoneNum) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Seller findByEmail(String email) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Seller findByFax(String fax) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Seller> findByActive(boolean isActive) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
}
