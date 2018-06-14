package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StockPriceOfIndexOfCompany {

@SerializedName("stockPrice")
@Expose
private StockPrice stockPrice;

/**
* No args constructor for use in serialization
*
*/
public StockPriceOfIndexOfCompany() {
}

/**
*
* @param stockPrice
*/
public StockPriceOfIndexOfCompany(StockPrice stockPrice) {
super();
this.stockPrice = stockPrice;
}

public StockPrice getStockPrice() {
return stockPrice;
}

public void setStockPrice(StockPrice stockPrice) {
this.stockPrice = stockPrice;
}

}