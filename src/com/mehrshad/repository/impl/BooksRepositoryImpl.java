package com.mehrshad.repository.impl;

import com.mehrshad.domain.Books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksRepositoryImpl {
    private Connection connection;
    private Books books;
    public List<Books> booksList = new ArrayList<>();

    public BooksRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public Books insertIntoBooks(Books book) throws SQLException {
        String query = "insert into librery_management_jdbc.books (name , status) values (? , ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1 , books.getName());
        preparedStatement.setBoolean(2 , books.getStatus());
        preparedStatement.executeUpdate();
        return books;
    }
    public void deleteBooks(Integer id) throws SQLException {
        String query = "delete from librery_management_jdbc.books where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1 , books.getId());
        preparedStatement.executeUpdate();
    }
    public Books findById() throws SQLException {
        String query = "select * from librery_management_jdbc.books where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1 , books.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            books = new Books(resultSet.getInt(1) , resultSet.getString(2 )
            ,resultSet.getBoolean(3));
        }
        return books;
    }
    public List<Books> findAll() throws SQLException {
        String query = "select * from librery_management_jdbc.Books";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            books = new Books(resultSet.getInt(1) , resultSet.getString(2 )
                    ,resultSet.getBoolean(3));
            booksList.add(books);
        }
        return booksList;
    }
}
