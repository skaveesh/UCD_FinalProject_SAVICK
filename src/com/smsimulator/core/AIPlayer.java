package com.smsimulator.core;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by asusgeforce on 16/06/2018.
 */
public class AIPlayer extends AnalyserMain {

    private static final String PLAYER_NAME = "AIPlayer";
    private PlayerTransactionsOfTurn[] playerTransactionsOfTurnsArray = new PlayerTransactionsOfTurn[10];
    //playerTransactionsOfTurnsArray[0] is equal to turn 1
    //playerTransactionsOfTurnsArray[1] is equal to turn 2
    //playerTransactionsOfTurnsArray[2] is equal to turn 3
    //playerTransactionsOfTurnsArray[3] is equal to turn 4
    //playerTransactionsOfTurnsArray[4] is equal to turn 5
    //playerTransactionsOfTurnsArray[5] is equal to turn 6
    //playerTransactionsOfTurnsArray[6] is equal to turn 7
    //playerTransactionsOfTurnsArray[7] is equal to turn 8
    //playerTransactionsOfTurnsArray[8] is equal to turn 9
    //playerTransactionsOfTurnsArray[9] is equal to turn 10

    AIPlayer(){
        //write setting code inside constructor



        setPlayerTransactionsForTurn(0, "buy", "HNB", 3, getCompanyStockArrayByStockName("HNB")[0] );
        setPlayerTransactionsForTurn(1, "buy", "LOLC", 3, getCompanyStockArrayByStockName("LOLC")[1] );
        setPlayerTransactionsForTurn(2, "buy", "HNB", 3, getCompanyStockArrayByStockName("HNB")[2] );
        setPlayerTransactionsForTurn(3, "buy", "HNB", 3, getCompanyStockArrayByStockName("HNB")[3] );
        setPlayerTransactionsForTurn(4, "buy", "HNB", 3, getCompanyStockArrayByStockName("HNB")[4] );
        setPlayerTransactionsForTurn(5, "buy", "HNB", 3, getCompanyStockArrayByStockName("HNB")[5] );
        setPlayerTransactionsForTurn(6, "buy", "HNB", 3, getCompanyStockArrayByStockName("HNB")[6] );
        setPlayerTransactionsForTurn(7, "sell", "HNB", 2259, getCompanyStockArrayByStockName("HNB")[7] );
        setPlayerTransactionsForTurn(8, "buy", "HNB", 3, getCompanyStockArrayByStockName("HNB")[8] );
        setPlayerTransactionsForTurn(9, "buy", "HNB", 3, getCompanyStockArrayByStockName("HNB")[9] );
    }




    private double[] value;
    Broker broker = new Broker();

    public double[] startToBuy(){
        value = broker.price("TAB");
        return value;
    }


    ///////////////IMPORTANT
    //////how to get AIPlayer currently own stocks
    private void getAIPlayerCurrentlyOwnStocks(){
        List<StockQuantity> AIPlayerCurrentlyOwnStocks = new Broker().portfolio(PLAYER_NAME).getOwnStockList();

        for(StockQuantity stockQuantity:AIPlayerCurrentlyOwnStocks ){
            System.out.println("AI Player has > Stock : " + stockQuantity.getStock() + " quantity : " + stockQuantity.getQuantity());
        }
    }

    private void setPlayerTransactionsForTurn(int index, String sellOrBuy, String stock, int quantity, double currentStockPriceOfTheStock){
        PlayerTransactionsOfTurn playerTransactionsOfTurn = new PlayerTransactionsOfTurn();
        playerTransactionsOfTurn.setName(PLAYER_NAME);
        playerTransactionsOfTurn.setSellOrBuy(sellOrBuy); //string should be "sell" or "buy"
        playerTransactionsOfTurn.setStock(stock); //string should be "HNB", "SHL" like that
        playerTransactionsOfTurn.setQuantity(quantity);
        playerTransactionsOfTurn.setStockPrice(currentStockPriceOfTheStock);
        playerTransactionsOfTurnsArray[index] = playerTransactionsOfTurn;
    }

    public PlayerTransactionsOfTurn[] getPlayerTransactionsOfTurnsArray(){
        return playerTransactionsOfTurnsArray;
    }

}
