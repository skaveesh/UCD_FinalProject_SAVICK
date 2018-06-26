package com.smsimulator.core;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by asusgeforce on 16/06/2018.
 */
public class AIPlayer extends AnalyserMain {

    private static final String PLAYER_NAME = "AIPlayer";
    private PlayerTransactionsOfTurn[] playerTransactionsOfTurnsArray = new PlayerTransactionsOfTurn[10];

    public AIPlayer(){aIGameLogic();
    }

    /**
     * The game strategy of the AIPlayer
     */
    public void  aIGameLogic(){
        double currentBalance = 0;
        List<StockWithQuantity> stockWithQuantities = new ArrayList<>();
        stockWithQuantities.clear();

        currentBalance = this.getAIPlayerCurrentBalance();
        stockWithQuantities = this.getAIPlayerCurrentlyOwnStocks();

        Debugger.log(" Current Balance in the bank - "+currentBalance);

        String transaction = "";
        String stockCompany = "";
        double stockPrice = 0;

        int currentTurn = 0;
        for(Prediction predictedStocks: prediction){
            transaction = predictedStocks.getBuyOrSell();
            stockCompany = predictedStocks.getStockName();
            stockPrice = getCompanyStockArrayByStockName(stockCompany)[currentTurn];
            int quantity = 0;
            double totalStockPrice = 0;

            Debugger.log(transaction+ " "+stockCompany);
            Debugger.log("Stock Price = "+getCompanyStockArrayByStockName(stockCompany)[currentTurn]);

            if(transaction.equals(BUY_TAG)){
                Debugger.log("---- Current Balance in the bank - "+currentBalance+" ------");

                quantity = (int) (currentBalance/stockPrice);

                Debugger.log("quantity = "+quantity);

                for (int i = 0; i < stockWithQuantities.size() ; i++) {
                    if(stockWithQuantities.get(i).getStockName().equals(stockCompany)) {
                        stockWithQuantities.get(i).setQuantity(quantity);
                    }else if(i==stockWithQuantities.size()-1){
                        stockWithQuantities.add(new StockWithQuantity(stockCompany,quantity));
                    }
                }
                totalStockPrice = stockPrice*quantity;
                Debugger.log("totalStockPrice = "+totalStockPrice);
                currentBalance = currentBalance - totalStockPrice;
                Debugger.log("currentBalance = "+currentBalance);

            }else if(transaction.equals(SELL_TAG)){

                int noOfStocks = 0;
                for (int i = 0; i < stockWithQuantities.size() ; i++) {
                    if(stockWithQuantities.get(i).getStockName().equals(stockCompany)) {
                        noOfStocks = stockWithQuantities.get(i).getQuantity();
                    }else if(i==stockWithQuantities.size()-1){
                        Debugger.log("Stock is not available");
                    }
                }
                quantity = noOfStocks;
                Debugger.log("quantity = "+noOfStocks);
                totalStockPrice = noOfStocks*stockPrice;
                Debugger.log("totalStockPrice = "+totalStockPrice);
                currentBalance = currentBalance +totalStockPrice;
                Debugger.log("currentBalance = "+currentBalance);
            }else{
                Debugger.log("Something went Wrong :(");
            }

            Debugger.log("Balance after turn "+(currentTurn+1)+" is "+currentBalance);
            setPlayerTransactionsForTurn(currentTurn, transaction, stockCompany, quantity, getCompanyStockArrayByStockName(stockCompany)[currentTurn] );

            currentTurn++;
        }


        Debugger.log("Final Balance = "+currentBalance);
    }


    /**
     * get AIPlayer currently own stocks
     * @return returns the currently owned stocks of the AI Player
     */
    private List<StockWithQuantity> getAIPlayerCurrentlyOwnStocks(){
        List<StockQuantity> AIPlayerCurrentlyOwnStocks = new Broker().portfolio(PLAYER_NAME).getOwnStockList();

        List<StockWithQuantity> stockWithQuantities = new ArrayList<>();

        for(StockQuantity stockQuantity:AIPlayerCurrentlyOwnStocks ){
            stockWithQuantities.add(new StockWithQuantity(stockQuantity.getStock(),stockQuantity.getQuantity()));
        }
        return stockWithQuantities;
    }

    /**
     * get AIPlayer current balance
     * @return returns bank balance of the AI player
     */
    private double getAIPlayerCurrentBalance(){
        return new Bank().balance(PLAYER_NAME);
    }

    /**
     * set the transaction according to turn of the AI player
     *
     * @param index as current turn
     * @param sellOrBuy transaction- whether sell or buy
     * @param stock company name to buy or sell
     * @param quantity no of stocks to buy or sell
     * @param currentStockPriceOfTheStock stock price of the current stock
     */
    private void setPlayerTransactionsForTurn(int index, String sellOrBuy, String stock, int quantity, double currentStockPriceOfTheStock){
        PlayerTransactionsOfTurn playerTransactionsOfTurn = new PlayerTransactionsOfTurn();
        playerTransactionsOfTurn.setName(PLAYER_NAME);
        playerTransactionsOfTurn.setSellOrBuy(sellOrBuy); //string should be "sell" or "buy"
        playerTransactionsOfTurn.setStock(stock); //string should be "HNB", "SHL" like that
        playerTransactionsOfTurn.setQuantity(quantity);
        playerTransactionsOfTurn.setStockPrice(currentStockPriceOfTheStock);
        playerTransactionsOfTurnsArray[index] = playerTransactionsOfTurn;
    }

    /**
     * get the overall transactions based on turns of AIPlayer
     * @return returns transactions based on turn
     */

    public PlayerTransactionsOfTurn[] getPlayerTransactionsOfTurnsArray(){
        return playerTransactionsOfTurnsArray;
    }

}
