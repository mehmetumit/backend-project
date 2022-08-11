package com.demo.app.repository.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.app.services.*;
import com.demo.app.repository.dao.CategoryDAO;
import com.demo.app.models.entities.Category;

import jakarta.persistence.EntityManager;
import com.demo.app.services.implementations.DatabaseServiceImpl;

public class CategoryDAOImpl implements CategoryDAO {
    // private final EntityManager entityManager;

    @Override
    public int delete(Category category) throws SQLException {
        Connection conn = DatabaseService.getConnection();
        String query = "DELETE FROM category WHERE category_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setLong(1, category.getId());

        int result = ps.executeUpdate();

        // We no longer need them
        DatabaseService.closePreparedStatement(ps);
        DatabaseService.closeConnection(conn);
        return result;
    }

    // Get category object from database with id
    @Override
    public Category findById(long id) throws SQLException {
        String query = "SELECT * FROM category where category_id = " + id;

        Connection conn = DatabaseService.findConnection();
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(query);

        Category category = null;
        if (rs.next()) {
            int sId = rs.getInt("category_id");
            String sName = rs.getString("category_name");
            category = new Category(sId, sName);
        }

        // We no longer need them
        DatabaseService.closeResultSet(rs);
        DatabaseService.closeStatement(st);

        return category;
    }

    // Get all category objects from database
    @Override
    public List<Category> getAll() throws SQLException {
        String query = "SELECT * FROM category";
        Connection conn = DatabaseService.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        // Using list is much better because in future we can use another list
        // implementation
        List<Category> allCategories = new ArrayList<>();
        while (rs.next()) {
            allCategories.add(new Category(rs.getLong(1), rs.getString(2)));
        }

        // We no longer need them
        DatabaseService.closeStatement(st);
        DatabaseService.closeResultSet(rs);
        DatabaseService.closeConnection(conn);

        return allCategories;
    }

    // Insert given Category object to database
    @Override
    public int insert(Category category) throws SQLException {
        Connection conn = DatabaseService.getConnection();
        // We will define values later in prepareStatement
        String query = "INSERT INTO category(category_id,category_name) VALUES(?,?)";

        PreparedStatement ps = conn.prepareStatement(query);

        ps.setLong(1, category.getId());
        ps.setString(2, category.getName());

        int result = ps.executeUpdate();

        // We no longer need them
        DatabaseService.closePreparedStatement(ps);
        DatabaseService.closeConnection(conn);

        return result;
    }

    @Override
    public int update(Category category) throws SQLException {
        Connection conn = DatabaseService.getConnection();

        // We will define values later in prepareStatement
        String query = "UPDATE category SET category_name = ? WHERE category_id = ?";

        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1, category.getName());
        ps.setLong(2, category.getId());

        int result = ps.executeUpdate();

        // We no longer need them
        DatabaseService.closePreparedStatement(ps);
        DatabaseService.closeConnection(conn);

        return result;
    }

    @Override
    public Category findByName(String name) throws SQLException {

        return null;
    }

}
