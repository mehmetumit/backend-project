package com.demo.app.repository.daoImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import com.demo.app.repository.DatabaseEngine;
import com.demo.app.repository.QueryEngine;
import com.demo.app.repository.dao.SupplierDAO;

import org.hibernate.Session;

import com.demo.app.models.entities.Supplier;

public class SupplierDAOImpl implements SupplierDAO {

    DatabaseEngine databaseEngine = DatabaseEngine.getEngine();

    @Override
    public String getEntityName() {
        return Supplier.class.getSimpleName();
    }

    @Override
    public void delete(int id) throws SQLException {
        databaseEngine.delete(findById(id));
    }

    @Override
    public Supplier findById(int id) throws SQLException {
        return databaseEngine.findById(Supplier.class, id);
    }

    @Override
    public List<Supplier> getAll() throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName();

        List<Supplier> suppliers = session.createQuery(query, Supplier.class).list();
        session.close();

        return suppliers;
    }

    @Override
    public void insert(Supplier supplier) throws SQLException {
        databaseEngine.persist(supplier);

    }

    @Override
    public void update(Supplier supplier) throws SQLException {
        Supplier updatedSupplier = findById(supplier.getId());
        updatedSupplier
                .setName(Objects.nonNull(supplier.getName()) ? supplier.getName()
                        : updatedSupplier.getName())
                .setAddress(Objects.nonNull(supplier.getAddress()) ? supplier.getAddress()
                        : updatedSupplier.getAddress())
                .setActive(Objects.nonNull(supplier.isActive()) ? supplier.isActive()
                        : updatedSupplier.isActive())
                .setPhoneNum(Objects.nonNull(supplier.getPhoneNum()) ? supplier.getPhoneNum()
                        : updatedSupplier.getPhoneNum())
                .setStockDetails(Objects.nonNull(supplier.getStockDetails()) ? supplier.getStockDetails()
                        : updatedSupplier.getStockDetails());
        databaseEngine.merge(updatedSupplier);
    }

    @Override
    public Supplier findByName(String name) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " where name = " + name;

        Supplier supplier = session.createQuery(query, Supplier.class).getSingleResult();
        session.close();

        return supplier;
    }

    @Override
    public Supplier findByAddress(String address) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " where address = " + address;

        Supplier supplier = session.createQuery(query, Supplier.class).getSingleResult();
        session.close();

        return supplier;
    }

    @Override
    public Supplier findByPhoneNum(String phoneNum) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " where phoneNum = " + phoneNum;

        Supplier supplier = session.createQuery(query, Supplier.class).getSingleResult();
        session.close();

        return supplier;
    }

    @Override
    public List<Supplier> findByActive(boolean isActive) throws SQLException {
        Session session = databaseEngine.openSession();
        String query = "from " + getEntityName() + " where isActive = " + isActive;

        List<Supplier> supplier = session.createQuery(query, Supplier.class).list();
        session.close();

        return supplier;
    }

    @Override
    public List<Supplier> findAll(HashMap<String, Object> dataMap) throws SQLException {
        Session session = databaseEngine.openSession();

        QueryEngine<Supplier> queryEngine = new QueryEngine<Supplier>();
        String query = queryEngine.entityDataMapToQuery(dataMap, Supplier.class);
        List<Supplier> suppliers = session.createQuery(query, Supplier.class).list();

        session.close();

        return suppliers;
    }

}
