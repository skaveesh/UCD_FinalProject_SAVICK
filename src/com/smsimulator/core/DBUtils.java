package com.smsimulator.core;

import java.io.Console;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

public class DBUtils {
    private static Connection connect = null;
    private static final String host = "jdbc:mysql://skaveesh-rds.ck3ipm1d8ett.us-east-1.rds.amazonaws.com:3306/bank_account";
    private static final String user = "skavessh";
    private static final String pass = "savick1234";
    //private static final String url = host+","+user+","+pass;

    public static Connection GetNewMySqlConnection() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://skaveesh-rds.ck3ipm1d8ett.us-east-1.rds.amazonaws.com:3306/stock_simulator_db", "skavessh", "savick1234");
            //connect = DriverManager.getConnection(host+","+user+","+pass);
            System.out.print("Connected!");
        }catch (ClassNotFoundException ex){
            throw  ex;
        }catch (SQLException ex){
            throw ex;
        }
        finally {
            connect.close();
        }
        return connect;
    }

    // Method Overriding
    public static Connection GetMySqlConnection(String url) throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection(url);
        }catch (ClassNotFoundException ex){
            throw ex;
        }catch (SQLException ex){
            throw ex;
        }
        finally {
            connect.close();
        }
        return connect;
    }

    public static Connection getRemoteConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbName = "stock_simulator_db";
            String userName = "skavessh";
            String password = "savick1234";
            String hostname = "skaveesh-rds.ck3ipm1d8ett.us-east-1.rds.amazonaws.com";
            String port = "3306";
            String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password + "&useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false&maxReconnects=10";
            System.out.println("Getting remote connection with connection string from environment variables.");
            con = DriverManager.getConnection(jdbcUrl);
            System.out.println("Remote connection successful.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static Connection testConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://stock_simulator_db.skaveesh-rds.ck3ipm1d8ett.us-east-1.rds.amazonaws.com:3306/";
            String userName = "skavessh";
            String password = "savick1234";
            String dbName = "stock_simulator_db";
            String driver = "com.mysql.jdbc.Driver";
            Connection connection = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Connected!");
            return connection;
        }
        catch (ClassNotFoundException e){e.printStackTrace();}
        catch (SQLException e){e.printStackTrace();}

        return null;
    }
}
