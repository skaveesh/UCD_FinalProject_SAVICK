package com.smsimulator.core;


public class Analyst extends AnalyserMain {

    public String recommendedStocksForPlayer[] = new String[10];

    public Analyst() {

        int recommendedStocksTurn = 0;
        for(Prediction recommendedStocks : prediction){
            String transactionTypeToDisplay = recommendedStocks.getBuyOrSell();
            String transactionCompanyToDisplay = recommendedStocks.getStockName();
            if (transactionTypeToDisplay.equals(BUY_TAG)){
                recommendedStocksForPlayer[recommendedStocksTurn] = "Buying the Stocks from "+transactionCompanyToDisplay+" might be an Asset in the Future!!";
            }else if(transactionTypeToDisplay.equals(SELL_TAG)){
                recommendedStocksForPlayer[recommendedStocksTurn] = "Selling Your Stocks from "+transactionCompanyToDisplay+" Gives a Profit to You!!";
            } else {
                Debugger.log("No Recommendations");
            }
            recommendedStocksTurn++;
        }
    }

    /**
     * get recommendations according to the strategy
     * @return returns recommendations to the player as hints
     */
    public String[] getRecommendations() {
        return recommendedStocksForPlayer;
    }
}
