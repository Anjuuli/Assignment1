package com.iims.dao;

import com.iims.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
    int save(Customer customer) throws ClassNotFoundException, SQLException;

    Customer findOne(int id) throws ClassNotFoundException, SQLException;

    List<Customer> findAll() throws ClassNotFoundException, SQLException;

    int update(Customer customer) throws ClassNotFoundException, SQLException;

    int delete(int id) throws ClassNotFoundException, SQLException;
}
