package com.app.servlet.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by apavliuchenkova on 24/11/2016.
 */
public class ConnectionFactory /*implements AutoCloseable*/{
    private static String url = "jdbc:mysql://localhost/db";
    private static String user = "root";
    private static String password = "root";
    Connection conn = null;

    public Connection getConn(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    /*@Override
    public void close() throws Exception {

    }*/
}
