package com.tap.servlet;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.tap.DAOImpl.UserDAOImpl;
import com.tap.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Step 1: Get username and password from form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Step 2: Fetch user from database
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.getUserByUsername(username);

        // Step 3: Verify password with BCrypt
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {

            // Step 4: Store user details in session
            HttpSession session = request.getSession();
            session.setAttribute("username", user.getUsername());
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("role", user.getRole());

            // Step 5: Redirect to restaurant page
            response.sendRedirect("restaurant");

        } else {
            // Step 6: Wrong credentials - show error on login page
            request.setAttribute("error", "Invalid username or password. Please try again.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}