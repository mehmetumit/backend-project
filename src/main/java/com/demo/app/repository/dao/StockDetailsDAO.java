package com.demo.app.repository.dao;

import java.sql.SQLException;
import java.util.List;

//import com.demo.app.models.entities.Product;
import com.demo.app.models.entities.StockDetails;
//import com.demo.app.models.entities.Supplier;

public interface StockDetailsDAO extends DAO<StockDetails> {
    // public Product findProductByStockDetailsId() throws SQLException;

    // public Supplier findSupplierByStockDetailsId() throws SQLException;

    public List<StockDetails> findByQuantity(int quantity) throws SQLException;

}
