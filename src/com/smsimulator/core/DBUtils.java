package com.smsimulator.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static Connection databaseConnection = null;
    private static final String host = "jdbc:mysql://skaveesh-rds.ck3ipm1d8ett.us-east-1.rds.amazonaws.com:3306/";
    private static final String database = "stock_simulator_db";
    private static final String user = "skaveesh";
    private static final String password = "savick1234";
    private static boolean connectionInitiated = false;

    public static boolean isConnectionInitiated() throws Exception {
        return connectionInitiated && !createMySqlConnection().isClosed();
    }

    public DBUtils() throws Exception {
        //uncomment below line to connect to hosted database
        //databaseConnection = createMySqlConnection();

        // uncomment below line to connect to local database
        databaseConnection = createMySqlLocalConnection();
    }

    public static Connection getDatabaseConnection() {
        return databaseConnection;
    }

    private static Connection createMySqlConnection() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            databaseConnection = DriverManager.getConnection(host + database, user, password);
            connectionInitiated = true;
        } catch (ClassNotFoundException | SQLException | NullPointerException ex) {
            connectionInitiated = false;
        }

        return databaseConnection;
    }

    private static Connection createMySqlLocalConnection() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/simulator_local", "root", "");
            connectionInitiated = true;
        } catch (ClassNotFoundException | SQLException | NullPointerException ex) {
            connectionInitiated = false;
        }

        return databaseConnection;
    }
}
