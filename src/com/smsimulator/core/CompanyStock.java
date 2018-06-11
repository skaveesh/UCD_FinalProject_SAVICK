package com.smsimulator.core;

/**
 * Created by Dilhara on 6/11/2018.
 */


public class CompanyStock {

    private double stockPrice;
    private double stockArray[] = new double[20];
    private String stock_name;

    public CompanyStock(String name)
    {
        this.stock_name = name;
    }


    private double random = (Math.random() * ((120 - 70) + 1)) + 70;
    private double stock_value = Math.round(random * 100.0) / 100.0;

    public void setStockArray() {
        for (int i = 0; i < stockArray.length; i++) {
            stockArray[i] = stock_value;
        }
    }

    public void increaseStockValue(double value, int index) {
        stockArray[index] = stockArray[index] + value ;
        stockPrice = stockArray[index];

    }

    public void decreaseStockValue(double value,int index) {
        stockArray[index] = stockArray[index] - value ;
        stockPrice = stockArray[index];

    }

    public double getStockPrice() {
        return stockPrice;
    }


    public String getStock_name()
    {
        return stock_name;
    }

}
