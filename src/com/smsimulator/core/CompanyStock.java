package com.smsimulator.core;

/**
 * Created by Dilhara on 6/11/2018.
 */
public class CompanyStock {

    private double stockArray[] = new double[20];
    private String companyName;
    private String stockName;

    public CompanyStock(String companyName, String stockName) {
        this.companyName = companyName;
        this.stockName = stockName;

        double random = (Math.random() * ((120 - 70) + 1)) + 70;
        double stockValue = Math.round(random * 100.0) / 100.0;
        //initializing stock
        for (int i = 0; i < stockArray.length; i++) {
            stockArray[i] = stockValue;
        }
    }

    public void setNewStockValue(double value, int index) {
        stockArray[index] = value ;
    }

    public void setStockArray(double[] stockArray){ this.stockArray = stockArray; }

    public double getStockPrice(int index) {
        return ((0 <= index && index <20) ? stockArray[index] : -1);
    }

    public double[] getStockPriceArray() {
        return stockArray;
    }

    public String getStockName()
    {
        return stockName;
    }

    public String getCompanyName() {
        return companyName;
    }
}
