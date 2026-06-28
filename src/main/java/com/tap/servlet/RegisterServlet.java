package com.tap.servlet;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.tap.DAOImpl.UserDAOImpl;
import com.tap.model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Step 1: Get all form values
        String username = request.getParameter("username");
        String email    = request.getParameter("email");
        String password = request.getParameter("password");
        String phone    = request.getParameter("phone");
        String role     = request.getParameter("role");

        // Step 2: Encrypt password using BCrypt
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));

        // Step 3: Create User object
        User user = new User(username, email, hashedPassword, phone, role);

        // Step 4: Save to database
        UserDAOImpl userDAO = new UserDAOImpl();
        int result = userDAO.addUser(user);

        // Step 5: Redirect based on result
        if (result == 1) {
            // Registration success - go to login
            response.sendRedirect("login.jsp");
        } else {
            // Registration failed - go back to register
            response.sendRedirect("register.html");
        }
    }
}