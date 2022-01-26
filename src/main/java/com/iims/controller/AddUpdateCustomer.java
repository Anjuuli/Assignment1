package com.iims.controller;

import com.iims.dao.CustomerDao;
import com.iims.dao.impl.CustomerDaoImpl;
import com.iims.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "add-update-customer", urlPatterns = "/add-update-customer")
public class AddUpdateCustomer extends HttpServlet {
    String id = null;
    CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("customer/add-update.jsp");
        id = req.getParameter("id");

        if (id != null) {
            try {
                req.setAttribute("customer", customerDao.findOne(Integer.parseInt(id)));
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
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        long contact = Long.parseLong(req.getParameter("contact"));

        try {
            if (id.length() > 0) {
                result = customerDao.update(new Customer(Integer.parseInt(id), name, address, contact));
            } else{
                result = customerDao.save(new Customer(name, address, contact));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        if (result > 0)
            res.sendRedirect("customer");
    }
}
