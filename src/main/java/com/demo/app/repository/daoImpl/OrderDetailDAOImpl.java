package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import com.demo.app.repository.DatabaseEngine;
import com.demo.app.repository.QueryEngine;
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
        QueryEngine<OrderDetail> queryEngine = new QueryEngine<OrderDetail>();

        String query = queryEngine.from(OrderDetail.class).build();

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
        OrderDetail updatedOrderDetail = findById(orderDetail.getId());
        updatedOrderDetail
                .setProduct(Objects.nonNull(orderDetail.getProduct()) ? orderDetail.getProduct()
                        : updatedOrderDetail.getProduct())
                .setQuantity(Objects.nonNull(orderDetail.getQuantitiy()) ? orderDetail.getQuantitiy()
                        : updatedOrderDetail.getQuantitiy());

        databaseEngine.merge(updatedOrderDetail);

    }

    @Override
    public List<OrderDetail> findByQuantity(int quantity) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<OrderDetail> queryEngine = new QueryEngine<OrderDetail>();

        // String query = "from " + getEntityName() + " where quantity = " + quantity;
        String query = queryEngine.from(OrderDetail.class).where().equal("quantity", quantity).build();

        List<OrderDetail> orderDetails = session.createQuery(query, OrderDetail.class).list();
        session.close();

        return orderDetails;
    }

    @Override
    public List<OrderDetail> findAll(HashMap<String, Object> dataMap) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<OrderDetail> queryEngine = new QueryEngine<OrderDetail>();

        // String query =
        // queryEngine.from(OrderDetail.class).whereEqualEntityDataMap(dataMap).build();
        String query;
        queryEngine.from(OrderDetail.class);
        if (dataMap.get("productId") != null) {
            queryEngine.joinAs("product", "p");
            dataMap.put("p.id", dataMap.get("productId"));
            dataMap.remove("productId");

        }
        query = queryEngine.whereEqualEntityDataMap(dataMap).build();

        List<OrderDetail> orderDetails = session.createQuery(query, OrderDetail.class).list();

        session.close();

        return orderDetails;
    }

}
