package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import com.demo.app.repository.DatabaseEngine;
import com.demo.app.repository.QueryEngine;
import com.demo.app.repository.dao.ProductDAO;

import org.hibernate.Session;

import com.demo.app.models.entities.Product;

public class ProductDAOImpl implements ProductDAO {

    DatabaseEngine databaseEngine = DatabaseEngine.getEngine();

    @Override
    public String getEntityName() {
        return Product.class.getSimpleName();
    }

    @Override
    public void delete(int id) throws SQLException {
        databaseEngine.delete(findById(id));
    }

    @Override
    public Product findById(int id) throws SQLException {
        return databaseEngine.findById(Product.class, id);
    }

    @Override
    public List<Product> getAll() throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Product> queryEngine = new QueryEngine<Product>();
        String query = queryEngine.from(Product.class).build();

        List<Product> products = session.createQuery(query, Product.class).list();
        session.close();

        return products;

    }

    @Override
    public void insert(Product product) throws SQLException {
        databaseEngine.persist(product);

    }

    @Override
    public void update(Product product) throws SQLException {
        Product updatedProduct = findById(product.getId());
        updatedProduct
                .setName(Objects.nonNull(product.getName()) ? product.getName()
                        : updatedProduct.getName())
                .setActive(Objects.nonNull(product.isActive()) ? product.isActive()
                        : updatedProduct.isActive())
                .setUnitPrice(Objects.nonNull(product.getUnitPrice()) ? product.getUnitPrice()
                        : updatedProduct.getUnitPrice())
                .setCategoryName(Objects.nonNull(product.getCategoryName()) ? product.getCategoryName()
                        : updatedProduct.getCategoryName());
        databaseEngine.merge(updatedProduct);
    }

    @Override
    public Product findByName(String name) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Product> queryEngine = new QueryEngine<Product>();
        String query = queryEngine.from(Product.class).where().equal("name", name).build();

        Product product = session.createQuery(query, Product.class).getSingleResult();
        session.close();

        return product;
    }

    @Override
    public List<Product> findByCategory(String categoryName) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Product> queryEngine = new QueryEngine<Product>();
        String query = queryEngine.from(Product.class).where().equal("categoryName", categoryName).build();

        List<Product> products = session.createQuery(query, Product.class).list();
        session.close();

        return products;
    }

    @Override
    public List<Product> findByUnitPrice(double unitPrice) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Product> queryEngine = new QueryEngine<Product>();
        String query = queryEngine.from(Product.class).where().equal("unitPrice", unitPrice).build();

        List<Product> products = session.createQuery(query, Product.class).list();
        session.close();

        return products;
    }

    @Override
    public List<Product> findByActive(boolean isActive) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Product> queryEngine = new QueryEngine<Product>();
        String query = queryEngine.from(Product.class).where().equal("isActive", isActive).build();

        List<Product> products = session.createQuery(query, Product.class).list();
        session.close();

        return products;
    }

    @Override
    public List<Product> findAll(HashMap<String, Object> dataMap) throws SQLException {
        Session session = databaseEngine.openSession();

        QueryEngine<Product> queryEngine = new QueryEngine<Product>();
        String query = queryEngine.from(Product.class).whereEqualEntityDataMap(dataMap).build();

        List<Product> products = session.createQuery(query, Product.class).list();

        session.close();

        return products;
    }

}
