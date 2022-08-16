package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.models.entities.StockDetail;
import com.demo.app.repository.DatabaseEngine;
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
        databaseEngine.merge(stockDetail);

    }

    @Override
    public List<StockDetail> findByQuantity(int quantity) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " where quantity = " + quantity;

        List<StockDetail> stockDetails = session.createQuery(query, StockDetail.class).list();
        session.close();

        return stockDetails;
    }

}
