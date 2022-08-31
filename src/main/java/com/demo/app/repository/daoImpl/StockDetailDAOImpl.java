package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import com.demo.app.models.entities.StockDetail;
import com.demo.app.repository.DatabaseEngine;
import com.demo.app.repository.QueryEngine;
import com.demo.app.repository.dao.StockDetailDAO;

import org.hibernate.Session;

public class StockDetailDAOImpl implements StockDetailDAO {

    DatabaseEngine databaseEngine = DatabaseEngine.getEngine();

    @Override
    public String getEntityName() {
        return StockDetail.class.getSimpleName();
    }

    @Override
    public void delete(int id) throws SQLException {
        databaseEngine.delete(findById(id));
    }

    @Override
    public StockDetail findById(int id) throws SQLException {
        return databaseEngine.findById(StockDetail.class, id);
    }

    @Override
    public List<StockDetail> getAll() throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName();

        List<StockDetail> stockDetails = session.createQuery(query, StockDetail.class).list();
        session.close();

        return stockDetails;

    }

    @Override
    public void insert(StockDetail stockDetail) throws SQLException {
        databaseEngine.persist(stockDetail);
    }

    @Override
    public void update(StockDetail stockDetail) throws SQLException {
        StockDetail updatedStockDetail = findById(stockDetail.getId());
        updatedStockDetail.setProduct(Objects.nonNull(stockDetail.getProduct()) ? stockDetail.getProduct()
                : updatedStockDetail.getProduct())
                .setQuantity(Objects.nonNull(stockDetail.getQuantity()) ? stockDetail.getQuantity()
                        : updatedStockDetail.getQuantity());
        databaseEngine.merge(updatedStockDetail);

    }

    @Override
    public List<StockDetail> findByQuantity(int quantity) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " where quantity = " + quantity;

        List<StockDetail> stockDetails = session.createQuery(query, StockDetail.class).list();
        session.close();

        return stockDetails;
    }

    @Override
    public List<StockDetail> findAll(HashMap<String, Object> dataMap) throws SQLException {
        Session session = databaseEngine.openSession();

        QueryEngine<StockDetail> queryEngine = new QueryEngine<StockDetail>();
        String query = queryEngine.entityDataMapToQuery(dataMap, StockDetail.class);
        List<StockDetail> orderDetails = session.createQuery(query, StockDetail.class).list();

        session.close();

        return orderDetails;
    }

}
