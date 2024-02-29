package servlets;

import db.DbManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Item;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/singin")
public class SingInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("singin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (email == null || password == null) {
            req.setAttribute("error", new Object());
            req.getRequestDispatcher("singin.jsp").forward(req, resp);
            return;
        }

        Long id;
        try {
            id = DbManager.chekUser(email, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("/profile?id=" + id);
    }
}
