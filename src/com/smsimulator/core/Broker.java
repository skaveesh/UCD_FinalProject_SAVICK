package com.smsimulator.core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public Portfolio portfolio(String name) {
        //get all stocks owned by the user
        List<String> ownedStockList = new ArrayList<>();
        List<StockQuantity> stockQuantityList = new ArrayList<>();
        List<Transaction> broughtStockList = new ArrayList<>();
        List<Transaction> soldStockList = new ArrayList<>();

        try {
            //get names of all the stocks that user have dealt with
            preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("SELECT bs.stock FROM buy_stock AS bs INNER JOIN player AS p ON bs.uid=p.uid WHERE p.username=? GROUP BY bs.stock");
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ownedStockList.add(resultSet.getString("stock"));
            }


            //call for a mysql function to get the user currently own stocks with their quantity
            /*
            TODO:code here
             */
            //temporary code
            stockQuantityList.add(new StockQuantity("GOOGL", 3));
            stockQuantityList.add(new StockQuantity("AAPL", 5));
            stockQuantityList.add(new StockQuantity("HNB", 8));

            //get user brought stocks as a list of transactions
            preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("SELECT bs.stock, bs.quantity, bs.price, bs.turn FROM buy_stock AS bs INNER JOIN player AS p ON bs.uid=p.uid WHERE p.username=?");
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                broughtStockList.add(new Transaction(resultSet.getString("stock"), resultSet.getInt("quantity"), resultSet.getDouble("price"), resultSet.getInt("turn")));
            }

            //get all sold stocks as a list of transactions
            preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("SELECT ss.stock, ss.quantity, ss.price, ss.turn FROM sell_stock AS ss INNER JOIN player AS p ON ss.uid=p.uid WHERE p.username=?");
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                soldStockList.add(new Transaction(resultSet.getString("stock"), resultSet.getInt("quantity"), resultSet.getDouble("price"), resultSet.getInt("turn")));
            }

        } catch (SQLException e) {

        }

        //initialize portfolio object and return it
        return new Portfolio(name, stockQuantityList, broughtStockList, soldStockList);
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
