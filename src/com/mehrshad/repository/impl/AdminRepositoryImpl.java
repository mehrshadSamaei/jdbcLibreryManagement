package com.mehrshad.repository.impl;

import com.mehrshad.domain.Admin;
import com.mehrshad.domain.User;
import com.mehrshad.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepositoryImpl {
    private Connection connection;
    private Admin admin;

    public AdminRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public Admin insertSaveAdmin() throws SQLException {
        String query = "insert into librery_management_jdbc.admin (fullname , " +
                "username , password) values (? , ? , ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1 , admin.getFullName());
        preparedStatement.setString(2 , admin.getUsername());
        preparedStatement.setString(3 , admin.getPassword());
        preparedStatement.executeUpdate();
        return admin;

    }
    public void deleteAdminOfTable() throws SQLException {
        String query = "delete from librery_management_jdbc.admin where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1 , admin.getId());
        preparedStatement.executeUpdate();
    }
    public Admin findByUsernameAndPassword(String username , String password) throws SQLException {
        String query = "select * from librery_management_jdbc.admin where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1 , username);
        preparedStatement.setString(2 , password);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            admin = new Admin(resultSet.getInt(1) , resultSet.getString(2 )
                    , resultSet.getString(3), resultSet.getString(4));
        }
        return admin;
    }
}
