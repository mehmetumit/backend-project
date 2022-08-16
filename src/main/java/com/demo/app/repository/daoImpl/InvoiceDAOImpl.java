package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.demo.app.repository.DatabaseEngine;
import com.demo.app.repository.dao.InvoiceDAO;

import org.hibernate.Session;

import com.demo.app.models.entities.Invoice;

public class InvoiceDAOImpl implements InvoiceDAO {
    DatabaseEngine databaseEngine = DatabaseEngine.getEngine();

    @Override
    public String getEntityName() {
        return Invoice.class.getSimpleName();
    }

    @Override
    public void delete(int id) throws SQLException {
        databaseEngine.delete(findById(id));
    }

    @Override
    public Invoice findById(int id) throws SQLException {
        return databaseEngine.findById(Invoice.class, id);
    }

    @Override
    public List<Invoice> getAll() throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName();

        List<Invoice> invoices = session.createQuery(query, Invoice.class).list();
        session.close();

        return invoices;
    }

    @Override
    public void insert(Invoice invoice) throws SQLException {
        databaseEngine.persist(invoice);
    }

    @Override
    public void update(Invoice invoice) throws SQLException {
        databaseEngine.merge(invoice);
    }

    @Override
    public List<Invoice> findByInvoiceTimestamp(Timestamp invoiceTimestamp) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " inv where inv.invoiceTimestamp = " + invoiceTimestamp;

        List<Invoice> invoices = session.createQuery(query, Invoice.class).list();
        session.close();

        return invoices;
    }

    @Override
    public List<Invoice> findByDueTimestamp(Timestamp dueTimestamp) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " inv where inv.dueTimestamp = " + dueTimestamp;

        List<Invoice> invoices = session.createQuery(query, Invoice.class).list();
        session.close();

        return invoices;
    }

    @Override
    public List<Invoice> findBySubTotal(double subTotal) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " inv where inv.subTotal = " + subTotal;

        List<Invoice> invoices = session.createQuery(query, Invoice.class).list();
        session.close();

        return invoices;
    }

    @Override
    public List<Invoice> findByDiscount(double discount) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " inv where inv.discount = " + discount;

        List<Invoice> invoices = session.createQuery(query, Invoice.class).list();
        session.close();

        return invoices;
    }

    @Override
    public List<Invoice> findByTaxRate(int taxRate) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " inv where inv.taxRate = " + taxRate;

        List<Invoice> invoices = session.createQuery(query, Invoice.class).list();
        session.close();

        return invoices;
    }

    @Override
    public List<Invoice> findByTotalTax(double totalTax) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " inv where inv.totalTax = " + totalTax;

        List<Invoice> invoices = session.createQuery(query, Invoice.class).list();
        session.close();

        return invoices;
    }

    @Override
    public List<Invoice> findByTotalPrice(double totalPrice) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " inv where inv.totalPrice = " + totalPrice;

        List<Invoice> invoices = session.createQuery(query, Invoice.class).list();
        session.close();

        return invoices;
    }

}
