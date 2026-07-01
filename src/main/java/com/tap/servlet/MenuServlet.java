package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.tap.DAOImpl.MenuDAOImpl;
import com.tap.model.Menu;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get restaurant ID from URL parameter
        int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));

        // Fetch all menu items for that restaurant
        MenuDAOImpl menuDAO = new MenuDAOImpl();
        List<Menu> allMenus = menuDAO.getAllMenuByRestaurant(restaurantId);

        // Pass to JSP
        request.setAttribute("allMenus", allMenus);
        request.setAttribute("restaurantId", restaurantId);

        RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
        rd.forward(request, response);
    }
}