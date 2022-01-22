package com.iims.dao;

import com.iims.model.BookCustomer;

import java.sql.SQLException;
import java.util.List;

public interface BookCustomerDao {
    int save(BookCustomer bookCustomer) throws ClassNotFoundException, SQLException;

    BookCustomer findOne(int id) throws ClassNotFoundException, SQLException;

    List<BookCustomer> findAll() throws ClassNotFoundException, SQLException;

    int update(BookCustomer bookCustomer) throws ClassNotFoundException, SQLException;

    int delete(int id) throws ClassNotFoundException, SQLException;
}
