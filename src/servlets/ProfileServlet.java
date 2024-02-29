package servlets;

import db.DbManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Item;
import models.User;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            User curentUser = DbManager.getUser(Long.parseLong(id));
            req.setAttribute("user", curentUser);
        } catch (SQLException e) {
            req.setAttribute("user", null);
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("profile.jsp").forward(req, resp);
    }
}