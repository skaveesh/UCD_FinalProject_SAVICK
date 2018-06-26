package com.smsimulator.core;

/**
 * Created by MyCom on 6/25/2018.
 */
public class StockWithQuantity {
    private String stockName;
    private int quantity;

    public StockWithQuantity(String stockName, int quantity) {
        this.stockName = stockName;
        this.quantity = quantity;
    }

    public String getStockName() {
        return stockName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
