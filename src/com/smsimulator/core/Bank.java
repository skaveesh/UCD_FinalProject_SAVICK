package com.smsimulator.core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by skaveesh on 2018-05-30.
 */

public class Bank {

    private static final double initialAmount = 1000;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public static boolean createAccount(int turn, String name) {
        int uid = getUidFromName(name);

        if (uid != -1) {
            try {
                preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("INSERT INTO bank_account(uid, turn, balance) VALUES(?,?,?)");
                preparedStatement.setInt(1, uid);
                preparedStatement.setInt(2, turn);
                preparedStatement.setDouble(3, initialAmount);
                return (preparedStatement.executeUpdate() > 0);
            } catch (SQLException e) {
                return false;
            }
        } else
            return false;
    }

    public boolean deposit(int turn, String name, String sender, double amount) {
        int uid = getUidFromName(name);

        if (uid != -1) {
            try {
                preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("{CALL sp_bankDeposit(?,?,?,?)}");
                preparedStatement.setInt(1, uid);
                preparedStatement.setString(2, sender);
                preparedStatement.setDouble(3, amount);
                preparedStatement.setInt(4, turn);

                return (preparedStatement.executeUpdate() > 0);
            } catch (SQLException e) {
                return false;
            }

        } else
            return false;
    }

    public  boolean withdraw(int turn, String name, String receiver, double amount) {
        int uid = getUidFromName(name);

        if (uid != -1) {
            try {
                preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("{CALL sp_bankWithdraw(?,?,?,?)}");
                preparedStatement.setInt(1, uid);
                preparedStatement.setString(2, receiver);
                preparedStatement.setDouble(3, amount);
                preparedStatement.setInt(4, turn);
                return (preparedStatement.executeUpdate() > 0);
            } catch (SQLException e) {
                return false;
            }
        } else
            return false;
    }

    public double balance(String name) {
        double balance = -1;

        try {
            preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("SELECT ba.balance FROM bank_account AS ba INNER JOIN player AS p ON ba.uid=p.uid WHERE p.username=?");
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                balance = resultSet.getDouble("balance");
            }
            return balance;
        } catch (SQLException e) {
            return -1;
        }
    }

    private static int getUidFromName(String name) {

        try {
            preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("SELECT uid FROM player WHERE username=?");
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            int returnUid = -1;

            while (resultSet.next()) {
                returnUid = resultSet.getInt("uid");
            }

            return returnUid;
        } catch (SQLException e) {
            return -1;
        }
    }

}
