package com.demo.app.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        String query = "SELECT * FROM category";
        Connection conn = DatabaseController.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        // PreparedStatement ps = conn.prepareStatement(query);
        // ps.setLong(1, id);
        Category category = null;
        if (rs.next()) {
            int sId = rs.getInt("category_id");
            String sName = rs.getString("category_name");
            category = new Category(sId, sName);
        }
        // ps.close();
        return category;
    }

    // Get all category objects from database
    @Override
    public List<Category> getAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    // Insert given Category object to database
    @Override
    public int insert(Category obj) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
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
