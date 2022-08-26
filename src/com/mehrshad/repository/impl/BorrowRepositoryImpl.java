package com.mehrshad.repository.impl;

import com.mehrshad.domain.Borrow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowRepositoryImpl {
    private Connection connection;
    private Borrow borrow;

    public BorrowRepositoryImpl(Connection connection) {

    }

    public Borrow insertIntoBorrowTable() throws SQLException {
        String query = "insert into librery_management_jdbc.borrow (date, status , user_id , book_id) " +
                "values (? , ? , ? , ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setDate(1, borrow.getDate());
        preparedStatement.setInt(2, borrow.getStatus());
        preparedStatement.setInt(3 , borrow.getUserid());
        preparedStatement.setInt(4 , borrow.getBookId());
        preparedStatement.executeUpdate();
        return borrow;
    }

    public Borrow findById() throws SQLException {
        String query = "select * from librery_management_jdbc.borrow where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, borrow.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            borrow = new Borrow(resultSet.getInt(1) ,
                    resultSet.getDate(2) ,
                    resultSet.getInt(3) ,
                    resultSet.getInt(4),
                    resultSet.getInt(5));
        }
        return borrow;
    }
}
