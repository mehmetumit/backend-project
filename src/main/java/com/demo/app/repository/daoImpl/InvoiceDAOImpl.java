package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import com.demo.app.repository.DatabaseEngine;
import com.demo.app.repository.QueryEngine;
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
        Invoice updatedInvoice = findById(invoice.getId());
        updatedInvoice
                .setInvoiceTimestamp(Objects.nonNull(invoice.getInvoiceTimestamp()) ? invoice.getInvoiceTimestamp()
                        : updatedInvoice.getInvoiceTimestamp())
                .setDueTimestamp(Objects.nonNull(invoice.getDueTimestamp()) ? invoice.getDueTimestamp()
                        : updatedInvoice.getDueTimestamp())
                .setSubTotal(Objects.nonNull(invoice.getSubTotal()) ? invoice.getSubTotal()
                        : updatedInvoice.getSubTotal())
                .setDiscount(Objects.nonNull(invoice.getDiscount()) ? invoice.getDiscount()
                        : updatedInvoice.getDiscount())
                .setTaxRate(Objects.nonNull(invoice.getTaxRate()) ? invoice.getTaxRate()
                        : updatedInvoice.getTaxRate())
                .setTotalTax(Objects.nonNull(invoice.getTotalTax()) ? invoice.getTotalTax()
                        : updatedInvoice.getTotalTax())
                .setTotalPrice(Objects.nonNull(invoice.getTotalPrice()) ? invoice.getTotalPrice()
                        : updatedInvoice.getTotalPrice());

        databaseEngine.merge(updatedInvoice);
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

    @Override
    public List<Invoice> findAll(HashMap<String, Object> dataMap) throws SQLException {
        Session session = databaseEngine.openSession();

        QueryEngine<Invoice> queryEngine = new QueryEngine<Invoice>();
        String query = queryEngine.entityDataMapToQuery(dataMap, Invoice.class);
        List<Invoice> invoices = session.createQuery(query, Invoice.class).list();

        session.close();

        return invoices;
    }

}
