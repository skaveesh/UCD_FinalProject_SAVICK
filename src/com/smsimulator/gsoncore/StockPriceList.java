package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StockPriceList {

@SerializedName("stockName")
@Expose
private String stockName;
@SerializedName("prices")
@Expose
private double[] prices = null;

/**
* No args constructor for use in serialization
*
*/
public StockPriceList() {
}

/**
*
* @param stockName
* @param prices
*/
public StockPriceList(String stockName, double[] prices) {
super();
this.stockName = stockName;
this.prices = prices;
}

public String getStockName() {
return stockName;
}

public void setStockName(String stockName) {
this.stockName = stockName;
}

public double[] getPrices() {
return prices;
}

public void setPrices(double[] prices) {
this.prices = prices;
}

}