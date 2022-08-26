package com.mehrshad.repository.impl;

import com.mehrshad.domain.Tarefe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TarefeRepositoryImpl {
    private Connection connection;
    private Tarefe tarefe;

    public TarefeRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

public Tarefe saveTarefe() throws SQLException {
        String query = "insert into librery_management_jdbc.tarefe (date , amount) values (? , ?)";
    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setDate(1 , tarefe.getDate());
    preparedStatement.setDouble(2 , tarefe.getAmount());
    preparedStatement.executeUpdate();
    return tarefe;
}

}
