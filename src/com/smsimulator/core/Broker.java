package com.smsimulator.core;

import com.smsimulator.server.root.Main;

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
    private static List<Sector> sectorList;

    /**
     * generating stock as static variable
     */
    public static void generateNewStock() {
        sectorList = Main.initializeStocks();
    }

    /**
     * get sectors
     * @return get all the sectors of the market for each game. each sector includes corresponding company stocks
     */
    public List<Sector> getSectorList() {
        return sectorList;
    }

    /**
     * create account for player under broker
     * @param turn time of the game
     * @param name name of the portfolio
     * @return returns true if creation successful
     */
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

    /**
     * get the information from user portfolio
     * @param name username of the player
     * @return portfolio of the user which includes username, stock player owns, brought stocks, sold stocks
     */
    public Portfolio portfolio(String name) {
        //get all stocks owned by the user
        List<String> ownedStockList = new ArrayList<>();
        List<StockQuantity> ownStockList = new ArrayList<>();
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
            for (String stockName : ownedStockList) {
                preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("SELECT sf_getUserStockQuantity (?, ?)");
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, stockName);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    if (resultSet.getInt(1) > 0)
                        ownStockList.add(new StockQuantity(stockName, resultSet.getInt(1)));
                }
            }

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
        return new Portfolio(name, ownStockList, broughtStockList, soldStockList);
    }

    /**
     * get the stock array of the company
     * @param stock stock name of the company
     * @return stock array of the company (because stock has 20 indices which displays to
     *                                     player, first 10 as stock history and from 11 to 20 it will displays to
     *                                     user as user level up in the game in each turn for the next 10 turns)
     */
    public double[] price(String stock) {
        double[] companyStockPrice = new double[20];

        SECTOR_LOOP:
        for (Sector sector : sectorList) {
            for (CompanyStock companyStock : sector.stockList) {
                if (companyStock.getStockName().equals(stock)) {
                    companyStockPrice = companyStock.getStockPriceArray();
                    break SECTOR_LOOP;
                }
            }
        }
        return companyStockPrice;
    }

    /**
     * get stock price for certain index of the stock array
     * @param stock stock name of the company
     * @param indexOfStockPriceArray stock index of the stock array
     * @return price of the stock in the index pass through the input parameters
     */
    public double price(String stock, int indexOfStockPriceArray) {
        double companyStockPrice = -1;

        SECTOR_LOOP:
        for (Sector sector : sectorList) {
            for (CompanyStock companyStock : sector.stockList) {
                if (companyStock.getStockName().equals(stock)) {
                    companyStockPrice = companyStock.getStockPrice(indexOfStockPriceArray);
                    break SECTOR_LOOP;
                }
            }
        }
        return companyStockPrice;
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
