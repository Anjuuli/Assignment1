package com.iims.controller;

import com.iims.dao.BookDao;
import com.iims.dao.impl.BookDaoImpl;
import com.iims.model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "add-update", urlPatterns = "/add-update")
public class AddUpdateBook extends HttpServlet {
    String id = null;
    BookDao bookDao = new BookDaoImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("add-update.jsp");
        id = req.getParameter("id");

        if (id != null) {
            try {
                req.setAttribute("book", bookDao.findOne(Integer.parseInt(id)));
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("action", "Update");
        } else {
            req.setAttribute("action", "Save");
        }

        rd.include(req, res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int result = 0;
        id = req.getParameter("id");
        String bookName = req.getParameter("bookName");
        String author = req.getParameter("author");
        int stock = Integer.parseInt(req.getParameter("stock"));

        try {
            if (id.length() > 0) {
                result = bookDao.update(new Book(Integer.parseInt(id), bookName, author, stock));
            } else{
                result = bookDao.save(new Book(bookName, author, stock));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        if (result > 0)
            res.sendRedirect("./");
    }
}
