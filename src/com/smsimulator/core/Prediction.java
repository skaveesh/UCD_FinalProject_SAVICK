package com.smsimulator.core;

/**
 * Created by MyCom on 6/22/2018.
 */
public class Prediction {
    private String buyOrSell;
    private String stockName;

    public Prediction(String buyOrSell, String stockName) {
        this.buyOrSell = buyOrSell;
        this.stockName = stockName;
    }

    public String getBuyOrSell() {
        return buyOrSell;
    }

    public String getStockName() {
        return stockName;
    }
}
