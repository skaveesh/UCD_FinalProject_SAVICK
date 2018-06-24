package com.smsimulator.core;

/**
 * Created by MyCom on 6/22/2018.
 */
public class PredictionHistoryArray {
    private double[] history;
    private String stockName;


    public PredictionHistoryArray(double[] history, String stockName) {
        this.history = history;
        this.stockName = stockName;
    }

    public double[] getHistory() {
        return history;
    }

    public String getStockName() {
        return stockName;
    }
}
