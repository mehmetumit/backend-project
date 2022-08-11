package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.demo.app.repository.dao.InvoiceDAO;
import com.demo.app.models.entities.Invoice;

public class InvoiceDAOImpl implements InvoiceDAO {

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
    public int delete(long id) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Invoice> findByInvoiceTimestamp(Timestamp invoiceTimestamp) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Invoice> findByDueTimestamp(Timestamp dueTimestamp) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Invoice> findBySubTotal(double subTotal) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Invoice> findByDiscount(double discount) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Invoice> findByTaxRate(int taxRate) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Invoice> findByTotalTax(double totalTax) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Invoice> findByTotalPrice(double totalPrice) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
