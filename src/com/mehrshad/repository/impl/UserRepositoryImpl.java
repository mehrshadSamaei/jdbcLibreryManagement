package com.mehrshad.repository.impl;

import com.mehrshad.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl {
    private Connection connection;
    private User user;
    List<User> users = new ArrayList<>();

    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public User insertIntoUserTable(User user) throws SQLException {
        String query = "insert into librery_management_jdbc.user " +
                "(fullname , username , password) values (? , ? , ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1 , user.getFullName());
        preparedStatement.setString(2 , user.getUsername());
        preparedStatement.setString(3 , user.getPassword());
        preparedStatement.executeUpdate();
        user.setId(getMaxId());
        return user;
    }
    public int getMaxId() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select Max(id) from " +
                "librery_management_jdbc.user");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }

        return 0;
    }
    public void removeUser() throws SQLException {
        String query = "delete from librery_management_jdbc.user where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1 , user.getId());
        preparedStatement.executeUpdate();
    }
    public List<User>  findAll() throws SQLException {
        String query = "select * from librery_management_jdbc.user";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            user = new User(resultSet.getInt(1), resultSet.getString(2)
            ,resultSet.getString(3), resultSet.getString(4));
            users.add(user);
        }
        return users;
    }
    public User findById() throws SQLException {
    String query = "select * from librery_management_jdbc.user where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1 , user.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            user = new User(resultSet.getInt(1) , resultSet.getString(2 )
                    , resultSet.getString(3), resultSet.getString(4));
        }
        return user;
    }
    public User findByUsernameAndPassword(String username , String password) throws SQLException {
        String query = "select * from librery_management_jdbc.user" +
                " where username = '"+(username) +"' and password = '" + (password) + "'";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1 , user.getUsername());
        preparedStatement.setString(2 , user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            user = new User(resultSet.getInt(1) , resultSet.getString(2 )
            , resultSet.getString(3), resultSet.getString(4));
        }
        return user;

    }
}
