package com.mehrshad.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private Connection connection;
    private String databaseUrl;
    private String databaseUserName;
    private String databasePassword;

    public DatabaseUtil() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.databaseUrl = "jdbc:mysql://localhost:3306/librery_management_jdbc";
        this.databaseUserName = "root";
        this.databasePassword = "Mehrshad@1374";
        this.connection = DriverManager.getConnection(
                databaseUrl, databaseUserName, databasePassword
        );
    }


    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
