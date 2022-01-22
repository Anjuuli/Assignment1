package com.iims.controller;

import com.iims.dao.BookDao;
import com.iims.dao.impl.BookDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "/", urlPatterns = "/")
public class Index extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        BookDao bookDao = new BookDaoImpl();
        RequestDispatcher rd = req.getRequestDispatcher("home.jsp");

        try {
            req.setAttribute("books", bookDao.findAll());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        rd.include(req, res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}
