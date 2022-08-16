package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.util.List;

import com.demo.app.repository.DatabaseEngine;
import com.demo.app.repository.dao.SellerDAO;

import org.hibernate.Session;

import com.demo.app.models.entities.Seller;

public class SellerDAOImpl implements SellerDAO {
    DatabaseEngine databaseEngine = DatabaseEngine.getEngine();

    @Override
    public String getEntityName() {
        return Seller.class.getSimpleName();
    }

    @Override
    public void delete(int id) throws SQLException {
        databaseEngine.delete(findById(id));
    }

    @Override
    public Seller findById(int id) throws SQLException {
        return databaseEngine.findById(Seller.class, id);
    }

    @Override
    public List<Seller> getAll() throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName();

        List<Seller> sellers = session.createQuery(query, Seller.class).list();
        session.close();

        return sellers;
    }

    @Override
    public void insert(Seller seller) throws SQLException {
        databaseEngine.persist(seller);
    }

    @Override
    public void update(Seller seller) throws SQLException {
        databaseEngine.merge(seller);
    }

    @Override
    public Seller findByName(String name) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " where seller.name = " + name;

        Seller seller = session.createQuery(query, Seller.class).getSingleResult();
        session.close();

        return seller;
    }

    @Override
    public Seller findByAddress(String address) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " where seller.address = " + address;

        Seller seller = session.createQuery(query, Seller.class).getSingleResult();
        session.close();

        return seller;
    }

    @Override
    public Seller findByPhoneNum(String phoneNum) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " where seller.phoneNum = " + phoneNum;

        Seller seller = session.createQuery(query, Seller.class).getSingleResult();
        session.close();

        return seller;
    }

    @Override
    public Seller findByEmail(String email) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " where seller.email = " + email;

        Seller seller = session.createQuery(query, Seller.class).getSingleResult();
        session.close();

        return seller;
    }

    @Override
    public Seller findByFax(String fax) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " where seller.fax = " + fax;

        Seller seller = session.createQuery(query, Seller.class).getSingleResult();
        session.close();

        return seller;
    }

    @Override
    public List<Seller> findByActive(boolean isActive) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " where seller.isActive = " + isActive;

        List<Seller> sellers = session.createQuery(query, Seller.class).list();
        session.close();

        return sellers;
    }

}
