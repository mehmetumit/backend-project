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
        QueryEngine<Invoice> queryEngine = new QueryEngine<Invoice>();
        // String query = "from " + getEntityName();
        String query = queryEngine.from(Invoice.class).build();

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
        QueryEngine<Invoice> queryEngine = new QueryEngine<Invoice>();
        // String query = "from " + getEntityName() + " inv where inv.invoiceTimestamp =
        // " + invoiceTimestamp;
        String query = queryEngine.from(Invoice.class).where().equal("invoiceTimestamp", invoiceTimestamp).build();

        List<Invoice> invoices = session.createQuery(query, Invoice.class).list();
        session.close();

        return invoices;
    }

    @Override
    public List<Invoice> findByDueTimestamp(Timestamp dueTimestamp) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Invoice> queryEngine = new QueryEngine<Invoice>();
        // String query = "from " + getEntityName() + " inv where inv.dueTimestamp = " +
        // dueTimestamp;
        String query = queryEngine.from(Invoice.class).where().equal("dueTimestamp", dueTimestamp).build();

        List<Invoice> invoices = session.createQuery(query, Invoice.class).list();
        session.close();

        return invoices;
    }

    @Override
    public List<Invoice> findBySubTotal(double subTotal) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Invoice> queryEngine = new QueryEngine<Invoice>();
        // String query = "from " + getEntityName() + " inv where inv.subTotal = " +
        // subTotal;
        String query = queryEngine.from(Invoice.class).equal("subTotal", subTotal).build();

        List<Invoice> invoices = session.createQuery(query, Invoice.class).list();
        session.close();

        return invoices;
    }

    @Override
    public List<Invoice> findByDiscount(double discount) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Invoice> queryEngine = new QueryEngine<Invoice>();
        // String query = "from " + getEntityName() + " inv where inv.discount = " +
        // discount;
        String query = queryEngine.from(Invoice.class).where().equal("discount", discount).build();

        List<Invoice> invoices = session.createQuery(query, Invoice.class).list();
        session.close();

        return invoices;
    }

    @Override
    public List<Invoice> findByTaxRate(int taxRate) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Invoice> queryEngine = new QueryEngine<Invoice>();
        // String query = "from " + getEntityName() + " inv where inv.taxRate = " +
        // taxRate;
        String query = queryEngine.from(Invoice.class).where().equal("taxRate", taxRate).build();

        List<Invoice> invoices = session.createQuery(query, Invoice.class).list();
        session.close();

        return invoices;
    }

    @Override
    public List<Invoice> findByTotalTax(double totalTax) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Invoice> queryEngine = new QueryEngine<Invoice>();
        // String query = "from " + getEntityName() + " inv where inv.totalTax = " +
        // totalTax;
        String query = queryEngine.from(Invoice.class).where().equal("totalTax", totalTax).build();

        List<Invoice> invoices = session.createQuery(query, Invoice.class).list();
        session.close();

        return invoices;
    }

    @Override
    public List<Invoice> findByTotalPrice(double totalPrice) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Invoice> queryEngine = new QueryEngine<Invoice>();

        // String query = "from " + getEntityName() + " inv where inv.totalPrice = " +
        // totalPrice;
        String query = queryEngine.from(Invoice.class).where().equal("totalPrice", totalPrice).build();

        List<Invoice> invoices = session.createQuery(query, Invoice.class).list();
        session.close();

        return invoices;
    }

    @Override
    public List<Invoice> findAll(HashMap<String, Object> dataMap) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Invoice> queryEngine = new QueryEngine<Invoice>();

        String query = queryEngine.from(Invoice.class).whereEqualEntityDataMap(dataMap).build();

        List<Invoice> invoices = session.createQuery(query, Invoice.class).list();

        session.close();

        return invoices;
    }

}
