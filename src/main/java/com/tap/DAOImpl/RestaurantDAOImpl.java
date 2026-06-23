package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.RestaurantDAO;
import com.tap.model.Restaurant;
import com.tap.util.DBConnection;

public class RestaurantDAOImpl implements RestaurantDAO {

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> list = new ArrayList<>();
        String query = "SELECT * FROM restaurants";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Restaurant r = new Restaurant();
                r.setRestaurantId(rs.getInt("restaurant_id"));
                r.setRestaurantName(rs.getString("restaurant_name"));
                r.setCuisineType(rs.getString("cuisine_type"));
                r.setAddress(rs.getString("address"));
                r.setPhone(rs.getString("phone"));
                r.setRating(rs.getDouble("rating"));
                r.setDeliveryTime(rs.getInt("delivery_time"));
                r.setActive(rs.getBoolean("is_active"));
                r.setImagePath(rs.getString("image_url"));
                list.add(r);
            }

        } catch (Exception e) {
            System.out.println("Error fetching restaurants: " + e.getMessage());
        }

        return list;
    }
}