package com.smsimulator.core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by skaveesh on 2018-05-30.
 */

public class Bank {

    private static final double initialAmount = 1000;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    /**
     * create bank account for player
     * @param turn time in the game
     * @param name username of the player
     * @return true if creation successful
     */
    public boolean createAccount(int turn, String name) {
        int uid = new Player().getUidFromName(name);

        if (uid != -1) {
            try {
                preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("INSERT INTO bank_account(uid, turn, balance) VALUES(?,?,?)");
                preparedStatement.setInt(1, uid);
                preparedStatement.setInt(2, turn);
                preparedStatement.setDouble(3, initialAmount);
                preparedStatement.executeUpdate();

                return true;
            } catch (SQLException e) {
                return false;
            }
        } else
            return false;
    }

    /**
     * check if bank account of player exists
     * @param name username of player
     * @return return true if account exists
     */
    public boolean checkExistenceOfAccount(String name){
        int uid = new Player().getUidFromName(name);
        boolean returnValue = false;

        try {
            if (uid != -1) {
                preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("SELECT * FROM bank_account WHERE uid=? LIMIT 1");
                preparedStatement.setInt(1, uid);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    returnValue = true;
                }
                return returnValue;
            } else
                return false;
        }catch (SQLException e){
            return false;
        }
    }

    /**
     * deposit money to player bank account by broker if player sell stocks
     * @param turn time in the game
     * @param name username of the player
     * @param sender sender of the fund
     * @param amount fund amount
     * @return return true if deposit complete
     */
    public boolean deposit(int turn, String name, String sender, double amount) {
        int uid = new Player().getUidFromName(name);

        if (uid != -1) {
            try {
                preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("{CALL sp_bankDeposit(?,?,?,?)}");
                preparedStatement.setInt(1, uid);
                preparedStatement.setString(2, sender);
                preparedStatement.setDouble(3, amount);
                preparedStatement.setInt(4, turn);
                preparedStatement.executeUpdate();

                return true;
            } catch (SQLException e) {
                return false;
            }

        } else
            return false;
    }

    /**
     * withdraw from user bank account by broker if player buy stocks
     * @param turn time in the game
     * @param name username of the player
     * @param receiver receiver of the funds
     * @param amount amount received
     * @return return true if withdraw complete
     */
    public boolean withdraw(int turn, String name, String receiver, double amount) {
        int uid = new Player().getUidFromName(name);

        if (uid != -1) {
            try {
                preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("{CALL sp_bankWithdraw(?,?,?,?)}");
                preparedStatement.setInt(1, uid);
                preparedStatement.setString(2, receiver);
                preparedStatement.setDouble(3, amount);
                preparedStatement.setInt(4, turn);
                preparedStatement.executeUpdate();

                return true;
            } catch (SQLException e) {
                return false;
            }
        } else
            return false;
    }

    /**
     * get balance of the player bank account
     * @param name username of the player
     * @return balance of the account
     */
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

}
