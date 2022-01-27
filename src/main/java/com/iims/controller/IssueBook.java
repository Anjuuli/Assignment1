package com.iims.controller;

import com.iims.dao.BookCustomerDao;
import com.iims.dao.BookDao;
import com.iims.dao.CustomerDao;
import com.iims.dao.impl.BookCustomerDaoImpl;
import com.iims.dao.impl.BookDaoImpl;
import com.iims.dao.impl.CustomerDaoImpl;
import com.iims.model.Book;
import com.iims.model.BookCustomer;
import com.iims.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "issue-book", urlPatterns = "/issue-book")
public class IssueBook extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("book/issue.jsp");
        if(req.getParameter("id") != null){
            req.setAttribute("bookId", req.getParameter("id"));
        }
        rd.include(req, res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        BookCustomerDao bookCustomerDao = new BookCustomerDaoImpl();
        BookDao bookDao = new BookDaoImpl();
        CustomerDao customerDao = new CustomerDaoImpl();
        String bookId = req.getParameter("bookId");
        String customerId = req.getParameter("customerId");
        int result = 0;
        if (bookId != null && customerId != null) {

            BookCustomer bookCustomer = new BookCustomer(Integer.parseInt(bookId), Integer.parseInt(customerId));

            try {
                Book book = bookDao.findOne(Integer.parseInt(bookId));
                Customer customer = customerDao.findOne(Integer.parseInt(customerId));

                if(book.getName() != null && customer.getName() != null){

                    if (book.getStock()-1 <= -1) {
                        throw new Exception("Stock out!");
                    }

                    book.setStock(book.getStock() - 1);
                    result = bookDao.update(book);

                    if (result > 0) {
                        bookCustomerDao.save(bookCustomer);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        res.sendRedirect("./");
    }
}
