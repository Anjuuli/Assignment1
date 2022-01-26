package com.iims.dao.impl;

import com.iims.connectionfactory.ConnectionFactory;
import com.iims.dao.BookCustomerDao;
import com.iims.model.Book;
import com.iims.model.BookCustomer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookCustomerDaoImpl implements BookCustomerDao {
    private static Connection connection;

    private static PreparedStatement preparedStatement;

    @Override
    public int save(BookCustomer bookCustomer) throws ClassNotFoundException, SQLException{
        final String QUERY = "INSERT INTO book_customer (bookId, customerId) VALUES (?,?)";

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setInt(1, bookCustomer.getBookId());
        preparedStatement.setInt(2, bookCustomer.getCustomerId());

        return preparedStatement.executeUpdate();
    }

    public int delete(int bookId, int customerId) throws ClassNotFoundException, SQLException{
        final String QUERY = "DELETE FROM book_customer where bookId = ? AND customerID = ?";

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setInt(1, bookId);
        preparedStatement.setInt(2, customerId);


        return preparedStatement.executeUpdate();
    }

}
