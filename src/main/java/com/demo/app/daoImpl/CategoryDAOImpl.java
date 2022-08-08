package com.demo.app.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.app.controllers.DatabaseController;
import com.demo.app.dao.CategoryDAO;
import com.demo.app.models.Category;

public class CategoryDAOImpl implements CategoryDAO {

    @Override
    public int delete(Category obj) throws SQLException {
        return 0;
    }

    // Get category object from database with id
    @Override
    public Category get(long id) throws SQLException {
        String query = "SELECT * FROM category where category_id = " + id;

        Connection conn = DatabaseController.getConnection();
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(query);

        Category category = null;
        if (rs.next()) {
            int sId = rs.getInt("category_id");
            String sName = rs.getString("category_name");
            category = new Category(sId, sName);
        }

        // We no longer need them
        DatabaseController.closeResultSet(rs);
        DatabaseController.closeStatement(st);

        return category;
    }

    // Get all category objects from database
    @Override
    public List<Category> getAll() throws SQLException {
        String query = "SELECT * FROM category";
        Connection conn = DatabaseController.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        // Using list is much better because in future we can use another list
        // implementation
        List<Category> allCategories = new ArrayList<>();
        while (rs.next()) {
            allCategories.add(new Category(rs.getLong(1), rs.getString(2)));
        }

        return allCategories;
    }

    // Insert given Category object to database
    @Override
    public int insert(Category category) throws SQLException {
        Connection conn = DatabaseController.getConnection();
        // We will define values later in prepareStatement
        String query = "INSERT INTO category(category_id,category_name) VALUES(?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setLong(1, category.getId());
        ps.setString(2, category.getName());

        int result = ps.executeUpdate();

        DatabaseController.closePreparedStatement(ps);
        DatabaseController.closeConnection(conn);

        return result;
    }

    @Override
    public int save(Category obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(Category obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
