package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import com.demo.app.repository.DatabaseEngine;
import com.demo.app.repository.QueryEngine;
import com.demo.app.repository.dao.OrderDAO;

import org.hibernate.Session;

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
        QueryEngine<Order> queryEngine = new QueryEngine<Order>();
        String query = queryEngine.from(Order.class).build();
        session.beginTransaction();

        List<Order> orders = session.createQuery(query, Order.class).list();
        session.close();

        return orders;
    }

    @Override
    public String getEntityName() {
        return Order.class.getSimpleName();
    }

    @Override
    public Order insert(Order order) throws SQLException {
        return (Order) databaseEngine.merge(order);
    }

    @Override
    public Order update(Order order) throws SQLException {
        Order updatedOrder = findById(order.getId());

        updatedOrder
                .setInvoice(Objects.nonNull(order.getInvoice()) ? order.getInvoice()
                        : updatedOrder.getInvoice())
                .setTimestamp(Objects.nonNull(order.getTimestamp()) ? order.getTimestamp()
                        : updatedOrder.getTimestamp())
                .setOrderDetails(Objects.nonNull(order.getOrderDetails()) ? order.getOrderDetails()
                        : updatedOrder.getOrderDetails());

        return (Order) databaseEngine.merge(updatedOrder);
    }

    @Override
    public List<Order> findByTimestamp(Timestamp timestamp) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Order> queryEngine = new QueryEngine<Order>();
        String query = queryEngine.from(Order.class).where().equal("timestamp", timestamp).build();

        List<Order> orders = session.createQuery(query, Order.class).list();
        session.close();

        return orders;
    }

    @Override
    public List<Order> findAll(HashMap<String, Object> dataMap) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Order> queryEngine = new QueryEngine<Order>();
        session.beginTransaction();

        String query;
        queryEngine.from(Order.class);

        if (dataMap.get("invoiceId") != null) {
            queryEngine.joinAs("invoice", "inv");
            dataMap.put("inv.id", dataMap.get("invoiceId"));
            dataMap.remove("invoiceId");

        }
        if (dataMap.get("orderDetailId") != null) {
            queryEngine.joinAs("orderDetails", "od");
            dataMap.put("od.id", dataMap.get("orderDetailId"));
            dataMap.remove("orderDetailId");
        }
        query = queryEngine.whereEqualEntityDataMap(dataMap).build();
        List<Order> orders = session.createQuery(query, Order.class).list();

        session.close();
        return orders;
    }
}
