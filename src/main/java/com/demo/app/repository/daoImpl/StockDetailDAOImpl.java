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
        QueryEngine<StockDetail> queryEngine = new QueryEngine<StockDetail>();
        String query = queryEngine.from(StockDetail.class).build();

        List<StockDetail> stockDetails = session.createQuery(query, StockDetail.class).list();
        session.close();

        return stockDetails;

    }

    @Override
    public StockDetail insert(StockDetail stockDetail) throws SQLException {
        System.out.println(stockDetail);
        return (StockDetail) databaseEngine.merge(stockDetail);
    }

    @Override
    public StockDetail update(StockDetail stockDetail) throws SQLException {
        StockDetail updatedStockDetail = findById(stockDetail.getId());
        updatedStockDetail.setProduct(Objects.nonNull(stockDetail.getProduct()) ? stockDetail.getProduct()
                : updatedStockDetail.getProduct())
                .setQuantity(Objects.nonNull(stockDetail.getQuantity()) ? stockDetail.getQuantity()
                        : updatedStockDetail.getQuantity());
        return (StockDetail) databaseEngine.merge(updatedStockDetail);

    }

    @Override
    public List<StockDetail> findByQuantity(int quantity) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<StockDetail> queryEngine = new QueryEngine<StockDetail>();
        String query = queryEngine.from(StockDetail.class).where().equal("quantity", quantity).build();

        List<StockDetail> stockDetails = session.createQuery(query, StockDetail.class).list();
        session.close();

        return stockDetails;
    }

    @Override
    public List<StockDetail> findAll(HashMap<String, Object> dataMap) throws SQLException {
        Session session = databaseEngine.openSession();

        QueryEngine<StockDetail> queryEngine = new QueryEngine<StockDetail>();
        String query;
        queryEngine.from(StockDetail.class);

        if (dataMap.get("productId") != null) {
            queryEngine.joinAs("product", "p");
            dataMap.put("p.id", dataMap.get("productId"));
            dataMap.remove("productId");
        }
        query = queryEngine.whereEqualEntityDataMap(dataMap).build();
        List<StockDetail> orderDetails = session.createQuery(query, StockDetail.class).list();
        System.out.println(query);
        session.close();

        return orderDetails;
    }

}
