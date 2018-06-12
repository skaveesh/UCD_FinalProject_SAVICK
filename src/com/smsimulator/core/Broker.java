package com.smsimulator.core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by skaveesh on 2018-06-11.
 */

public class Broker {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    Bank bank = new Bank();
    Player player = new Player();

    public boolean createAccount(int turn, String name) {
        int uid = new Player().getUidFromName(name);

        if (uid != -1) {
            try {
                preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("INSERT INTO broker_account(uid, turn, balance) VALUES(?,?,?)");
                preparedStatement.setInt(1, uid);
                preparedStatement.setInt(2, turn);

                return (preparedStatement.executeUpdate() > 0);
            } catch (SQLException e) {
                return false;
            }
        } else
            return false;
    }

    public void portfolio(String name) {

    }

    public void price(String stock) {

    }

    /**
     * @param turn     is time in game like in bank class
     * @param name     is username
     * @param stock    is stock name as GOOGL, AAPL
     * @param quantity is stock quantity
     * @param price    is single stock current price
     */
    public boolean buy(int turn, String name, String stock, int quantity, double price) {
        int uid = player.getUidFromName(name);
        double balance = bank.balance(name); // (Check balance and throw error if insufficient funds) This is to my knowledge handled in the stored procedure which works with the withdraw function
        double amount = (double)quantity * price;
        // Check if balace is more than quantity * price
        if(balance < amount){
            return false;
        }
        bank.withdraw(turn, name, stock, amount);

        if(uid != -1){
            try{
                preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("UPDATE buy_stock SET stock=?,quantity=?,price=?,turn=? WHERE uid=?");
                preparedStatement.setString(1, stock);
                preparedStatement.setInt(2, quantity);
                preparedStatement.setDouble(3, price);
                preparedStatement.setInt(4, turn);
                preparedStatement.setInt(5, uid);

            }catch (SQLException e){
                return false;
            }
        } else{
            return false;
        }
        return true;
    }

    /**
     * @param turn     is time in game like in bank class
     * @param name     is username
     * @param stock    is stock name as GOOGL, AAPL
     * @param quantity is stock quantity
     * @param price    is single stock current price
     */
    public boolean sell(int turn, String name, String stock, int quantity, double price) {
        int uid = player.getUidFromName(name);
        double amount = (double)quantity * price;
        // Have to check "The transaction fails if the player does not have the specified quantity of stock"

        bank.deposit(turn, name, stock, amount);

        if(uid != -1){
            try{
                preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("UPDATE sell_stock SET stock=?,quantity=?,price=?,turn=? WHERE uid=?");
                preparedStatement.setString(1, stock);
                preparedStatement.setInt(2, quantity);
                preparedStatement.setDouble(3, price);
                preparedStatement.setInt(4, turn);
                preparedStatement.setInt(5, uid);

            }catch (SQLException e){
                return false;
            }
        } else{
            return false;
        }
        return true;
    }

}
