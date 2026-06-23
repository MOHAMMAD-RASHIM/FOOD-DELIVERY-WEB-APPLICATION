package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.tap.DAOImpl.RestaurantDAOImpl;
import com.tap.model.Restaurant;

@WebServlet("/restaurant")
public class RestaurantServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Step 1: Create DAOImpl object
        RestaurantDAOImpl restaurantDAO = new RestaurantDAOImpl();

        // Step 2: Fetch all restaurants from DB
        List<Restaurant> allRestaurants = restaurantDAO.getAllRestaurants();

        // Step 3: Store in request object
        request.setAttribute("allRestaurants", allRestaurants);

        // Step 4: Forward to JSP
        RequestDispatcher rd = request.getRequestDispatcher("restaurant.jsp");
        rd.forward(request, response);
    }
}