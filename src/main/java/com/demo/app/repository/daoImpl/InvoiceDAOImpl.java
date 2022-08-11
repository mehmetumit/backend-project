package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.repository.dao.InvoiceDAO;
import com.demo.app.models.entities.Invoice;

public class InvoiceDAOImpl implements InvoiceDAO {

    @Override
    public int delete(Invoice obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Invoice findById(long id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Invoice> getAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insert(Invoice obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(Invoice obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Invoice findByName(String name) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
