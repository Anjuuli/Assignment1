package com.iims.dao;

import com.iims.model.BookCustomer;

import java.sql.SQLException;

public interface BookCustomerDao {
    int save(BookCustomer bookCustomer) throws ClassNotFoundException, SQLException;

    int delete(int bookId, int customerId) throws ClassNotFoundException, SQLException;
}
