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

    public boolean createAccount(int turn, String name) {
        int uid = new Player().getUidFromName(name);

        if (uid != -1) {
            try {
                preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("INSERT INTO boker_account(uid, turn, balance) VALUES(?,?,?)");
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
    public void buy(int turn, String name, String stock, int quantity, double price) {

    }

    /**
     * @param turn     is time in game like in bank class
     * @param name     is username
     * @param stock    is stock name as GOOGL, AAPL
     * @param quantity is stock quantity
     * @param price    is single stock current price
     */
    public void sell(int turn, String name, String stock, int quantity, double price) {

    }

}
