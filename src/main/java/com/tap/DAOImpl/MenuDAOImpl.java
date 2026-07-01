package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.MenuDAO;
import com.tap.model.Menu;
import com.tap.util.DBConnection;

public class MenuDAOImpl implements MenuDAO {

    @Override
    public List<Menu> getAllMenuByRestaurant(int restaurantId) {
        List<Menu> menuList = new ArrayList<>();
        String query = "SELECT * FROM menu WHERE restaurant_id = ?";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, restaurantId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Menu menu = new Menu();
                menu.setMenuId(rs.getInt("menu_id"));
                menu.setRestaurantId(rs.getInt("restaurant_id"));
                menu.setCategoryId(rs.getInt("category_id"));
                menu.setItemName(rs.getString("item_name"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setImageUrl(rs.getString("image_url"));
                menu.setAvailable(rs.getBoolean("is_available"));
                menuList.add(menu);
            }

        } catch (Exception e) {
            System.out.println("Error fetching menu: " + e.getMessage());
            e.printStackTrace();
        }

        return menuList;
    }
}