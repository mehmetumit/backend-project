package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import com.demo.app.repository.DatabaseEngine;
import com.demo.app.repository.QueryEngine;
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
        QueryEngine<Seller> queryEngine = new QueryEngine<Seller>();
        String query = queryEngine.from(Seller.class).build();

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
        Seller updatedSeller = findById(seller.getId());
        updatedSeller
                .setFax(Objects.nonNull(seller.getFax()) ? seller.getFax()
                        : updatedSeller.getFax())
                .setName(Objects.nonNull(seller.getName()) ? seller.getName()
                        : updatedSeller.getName())
                .setEmail(Objects.nonNull(seller.getEmail()) ? seller.getEmail()
                        : updatedSeller.getEmail())
                .setAddress(Objects.nonNull(seller.getAddress()) ? seller.getAddress()
                        : updatedSeller.getAddress())
                .setActive(Objects.nonNull(seller.isActive()) ? seller.isActive()
                        : updatedSeller.isActive())
                .setPhoneNum(Objects.nonNull(seller.getPhoneNum()) ? seller.getPhoneNum()
                        : updatedSeller.getPhoneNum())
                .setInvoices(Objects.nonNull(seller.getInvoices()) ? seller.getInvoices()
                        : updatedSeller.getInvoices());
        databaseEngine.merge(updatedSeller);
    }

    @Override
    public Seller findByName(String name) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Seller> queryEngine = new QueryEngine<Seller>();
        String query = queryEngine.from(Seller.class).where().equal("name", name).build();

        Seller seller = session.createQuery(query, Seller.class).getSingleResult();
        session.close();

        return seller;
    }

    @Override
    public Seller findByAddress(String address) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Seller> queryEngine = new QueryEngine<Seller>();
        String query = queryEngine.from(Seller.class).where().equal("address", address).build();

        Seller seller = session.createQuery(query, Seller.class).getSingleResult();
        session.close();

        return seller;
    }

    @Override
    public Seller findByPhoneNum(String phoneNum) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Seller> queryEngine = new QueryEngine<Seller>();
        String query = queryEngine.from(Seller.class).where().equal("phoneNum", phoneNum).build();

        Seller seller = session.createQuery(query, Seller.class).getSingleResult();
        session.close();

        return seller;
    }

    @Override
    public Seller findByEmail(String email) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Seller> queryEngine = new QueryEngine<Seller>();
        String query = queryEngine.from(Seller.class).equal("email", email).build();

        Seller seller = session.createQuery(query, Seller.class).getSingleResult();
        session.close();

        return seller;
    }

    @Override
    public Seller findByFax(String fax) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Seller> queryEngine = new QueryEngine<Seller>();
        String query = queryEngine.from(Seller.class).where().equal("fax", fax).build();

        Seller seller = session.createQuery(query, Seller.class).getSingleResult();
        session.close();

        return seller;
    }

    @Override
    public List<Seller> findByActive(boolean isActive) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Seller> queryEngine = new QueryEngine<Seller>();
        String query = queryEngine.from(Seller.class).where().equal("isActive", isActive).build();

        List<Seller> sellers = session.createQuery(query, Seller.class).list();
        session.close();

        return sellers;
    }

    @Override
    public List<Seller> findAll(HashMap<String, Object> dataMap) throws SQLException {
        Session session = databaseEngine.openSession();
        QueryEngine<Seller> queryEngine = new QueryEngine<Seller>();

        String query;
        queryEngine.from(Seller.class);
        if (dataMap.get("invoiceId") != null) {
            dataMap.put("inv.id", dataMap.get("invoiceId"));
            dataMap.remove("invoiceId");
            queryEngine.joinAs("invoices", "inv");
        }
        query = queryEngine.whereEqualEntityDataMap(dataMap).build();
        System.out.println(query);
        List<Seller> sellers = session.createQuery(query, Seller.class).list();

        session.close();

        return sellers;
    }

}
