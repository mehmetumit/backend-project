package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.repository.dao.ProductDAO;
import com.demo.app.models.entities.Product;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public int delete(Product obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Product findById(long id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Product> getAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insert(Product obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(Product obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Product findByName(String name) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
