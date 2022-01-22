package com.iims.controller;

import com.iims.dao.BookDao;
import com.iims.dao.impl.BookDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "delete-book", urlPatterns = "/delete-book")
public class DeleteBook extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        BookDao bookDao = new BookDaoImpl();

        String id = req.getParameter("id");

        if(id != null){
            try {
                bookDao.delete(Integer.parseInt(id));
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

        res.sendRedirect("./");
    }
}
