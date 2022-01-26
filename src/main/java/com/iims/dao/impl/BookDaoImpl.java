package com.iims.dao.impl;

import com.iims.connectionfactory.ConnectionFactory;
import com.iims.dao.BookDao;
import com.iims.model.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private static Connection connection;

    private static PreparedStatement preparedStatement;

    private static ResultSet resultSet;

    @Override
    public int save(Book book) throws ClassNotFoundException, SQLException {
        final String QUERY = "INSERT INTO book (name, author, stock) VALUES (?,?,?)";

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setString(1, book.getName());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setInt(3, book.getStock());

        return preparedStatement.executeUpdate();
    }

    @Override
    public List<Book> findAll() throws ClassNotFoundException, SQLException {
        final List<Book> books = new ArrayList<>();
        final String QUERY = "SELECT * FROM book";

        connection = ConnectionFactory.getConnection();
        resultSet = connection.prepareStatement(QUERY).executeQuery();

        while (resultSet.next()) {
            Book book = new Book();

            book.setId(resultSet.getInt("id"));
            book.setName(resultSet.getString("name"));
            book.setAuthor(resultSet.getString("author"));
            book.setStock(Integer.parseInt(resultSet.getString("stock")));

            books.add(book);
        }

        return books;
    }

    @Override
    public Book findOne(int id) throws ClassNotFoundException, SQLException {
        final String QUERY = "SELECT * FROM book WHERE id = ?";

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setInt(1, id);

        resultSet = preparedStatement.executeQuery();

        Book book = new Book();

        while (resultSet.next()) {
            book.setId(resultSet.getInt("id"));
            book.setName(resultSet.getString("name"));
            book.setAuthor(resultSet.getString("author"));
            book.setStock(Integer.parseInt(resultSet.getString("stock")));
        }

        return book;
    }

    @Override
    public int update(Book book) throws ClassNotFoundException, SQLException {
        final String QUERY = "UPDATE book SET name = ?, author = ?, stock = ? WHERE id = ?";

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setString(1, book.getName());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setInt(3, book.getStock());
        preparedStatement.setInt(4, book.getId());

        return preparedStatement.executeUpdate();

    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        Book book = findOne(id);

        if(book.getStock() == 0){
            final String QUERY = "DELETE FROM book where id = ?";

            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate();
        }

        return 0;
    }
}
