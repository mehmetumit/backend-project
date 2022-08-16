package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.demo.app.repository.DatabaseEngine;
import com.demo.app.repository.dao.OrderDAO;

import org.hibernate.Session;

import com.demo.app.models.entities.Invoice;
import com.demo.app.models.entities.Order;

public class OrderDAOImpl implements OrderDAO {
    DatabaseEngine databaseEngine = DatabaseEngine.getEngine();

    @Override
    public void delete(int id) throws SQLException {
        databaseEngine.delete(findById(id));
    }

    @Override
    public Order findById(int id) throws SQLException {
        return databaseEngine.findById(Order.class, id);
    }

    @Override
    public List<Order> getAll() throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from \"" + getEntityName() + "\"";

        List<Order> orders = session.createQuery(query, Order.class).list();
        session.close();

        return orders;
    }

    @Override
    public String getEntityName() {
        return Order.class.getSimpleName();
    }

    @Override
    public void insert(Order order) throws SQLException {
        databaseEngine.persist(order);
    }

    @Override
    public void update(Order order) throws SQLException {
        databaseEngine.merge(order);
    }

    @Override
    public List<Order> findByTimestamp(Timestamp timestamp) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from \"" + getEntityName() + "\" where timestamp = " + timestamp;

        List<Order> orders = session.createQuery(query, Order.class).list();
        session.close();

        return orders;
    }

    // @Override
    // public Invoice findOrderInvoiceById(int id) throws SQLException {
    // Session session = databaseEngine.getCurrentSession();
    // String query = "select inv from \"" + getEntityName()
    // + "\" ord left join ord.invoice inv where inv.order_id = "
    // + id;

    // Invoice invoice = session.createQuery(query,
    // Invoice.class).getSingleResult();
    // session.close();

    // return invoice;
    // }

}
