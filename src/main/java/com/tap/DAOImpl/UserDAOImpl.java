package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tap.DAO.UserDAO;
import com.tap.model.User;
import com.tap.util.DBConnection;

public class UserDAOImpl implements UserDAO {

    @Override
    public int addUser(User user) {
        String query = "INSERT INTO users (username, email, password, phone, role) " +
                       "VALUES (?, ?, ?, ?, ?)";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getRole());

            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error adding user: " + e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public User getUserByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setRole(rs.getString("role"));
                return user;
            }

        } catch (Exception e) {
            System.out.println("Error fetching user: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}