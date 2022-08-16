package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.repository.DatabaseEngine;
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
        String query = "from " + getEntityName();

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
        databaseEngine.merge(product);
    }

    @Override
    public Product findByName(String name) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " where name = " + name;

        Product product = session.createQuery(query, Product.class).getSingleResult();
        session.close();

        return product;
    }

    @Override
    public List<Product> findByCategory(String categoryName) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " where categoryName = " + categoryName;

        List<Product> products = session.createQuery(query, Product.class).list();
        session.close();

        return products;
    }

    @Override
    public List<Product> findByUnitPrice(double unitPrice) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " where unitPrice = " + unitPrice;

        List<Product> products = session.createQuery(query, Product.class).list();
        session.close();

        return products;
    }

    @Override
    public List<Product> findByActive(boolean isActive) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " where isActive = " + isActive;

        List<Product> products = session.createQuery(query, Product.class).list();
        session.close();

        return products;
    }

}
