package com.iims.dao.impl;

import com.iims.connectionfactory.ConnectionFactory;
import com.iims.dao.CustomerDao;
import com.iims.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    private static Connection connection;

    private static PreparedStatement preparedStatement;

    private static ResultSet resultSet;

    @Override
    public int save(Customer customer) throws ClassNotFoundException, SQLException {
        final String QUERY = "INSERT INTO customer (name, address, contact) VALUES (?,?,?)";

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setString(1, customer.getName());
        preparedStatement.setString(2, customer.getAddress());
        preparedStatement.setLong(3, customer.getContact());

        return preparedStatement.executeUpdate();
    }

    @Override
    public List<Customer> findAll() throws ClassNotFoundException, SQLException {
        final List<Customer> customers = new ArrayList<>();
        final String QUERY = "SELECT * FROM customer";

        connection = ConnectionFactory.getConnection();
        resultSet = connection.prepareStatement(QUERY).executeQuery();

        while (resultSet.next()) {
            Customer customer = new Customer();

            customer.setId(resultSet.getInt("id"));
            customer.setName(resultSet.getString("name"));
            customer.setAddress(resultSet.getString("address"));
            customer.setContact(Long.parseLong(resultSet.getString("contact")));

            customers.add(customer);
        }

        return customers;
    }

    @Override
    public Customer findOne(int id) throws ClassNotFoundException, SQLException {
        final String QUERY = "SELECT * FROM customer WHERE id = ?";

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setInt(1, id);

        resultSet = preparedStatement.executeQuery();

        Customer customer = new Customer();

        while (resultSet.next()) {
            customer.setId(resultSet.getInt("id"));
            customer.setName(resultSet.getString("name"));
            customer.setAddress(resultSet.getString("address"));
            customer.setContact(Long.parseLong(resultSet.getString("contact")));
        }

        return customer;
    }

    @Override
    public int update(Customer customer) throws ClassNotFoundException, SQLException {
        final String QUERY = "UPDATE customer SET name = ?, address = ?, contact = ? WHERE id = ?";

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setString(1, customer.getName());
        preparedStatement.setString(2, customer.getAddress());
        preparedStatement.setLong(3, customer.getContact());
        preparedStatement.setInt(4, customer.getId());

        return preparedStatement.executeUpdate();

    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        final String QUERY = "DELETE FROM customer where id = ?";

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setInt(1, id);

        return preparedStatement.executeUpdate();
    }
}
