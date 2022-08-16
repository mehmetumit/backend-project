package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.repository.DatabaseEngine;
import com.demo.app.repository.dao.OrderDetailDAO;

import org.hibernate.Session;

import com.demo.app.models.entities.OrderDetail;

public class OrderDetailDAOImpl implements OrderDetailDAO {

    DatabaseEngine databaseEngine = DatabaseEngine.getEngine();

    @Override
    public String getEntityName() {
        return OrderDetail.class.getSimpleName();
    }

    @Override
    public void delete(int id) throws SQLException {
        databaseEngine.delete(findById(id));
    }

    @Override
    public OrderDetail findById(int id) throws SQLException {
        return databaseEngine.findById(OrderDetail.class, id);
    }

    @Override
    public List<OrderDetail> getAll() throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName();

        List<OrderDetail> orderDetails = session.createQuery(query, OrderDetail.class).list();
        session.close();

        return orderDetails;
    }

    @Override
    public void insert(OrderDetail orderDetail) throws SQLException {
        databaseEngine.persist(orderDetail);

    }

    @Override
    public void update(OrderDetail orderDetail) throws SQLException {
        databaseEngine.merge(orderDetail);

    }

    @Override
    public List<OrderDetail> findByQuantity(int quantity) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " where quantity = " + quantity;

        List<OrderDetail> orderDetails = session.createQuery(query, OrderDetail.class).list();
        session.close();

        return orderDetails;
    }

}