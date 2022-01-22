package com.iims.dao;

import com.iims.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    int save(Book book) throws ClassNotFoundException, SQLException;

    Book findOne(int id) throws ClassNotFoundException, SQLException;

    List<Book> findAll() throws ClassNotFoundException, SQLException;

    int update(Book book) throws ClassNotFoundException, SQLException;

    int delete(int id) throws ClassNotFoundException, SQLException;
}
