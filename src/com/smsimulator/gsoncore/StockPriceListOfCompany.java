package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StockPriceListOfCompany {

@SerializedName("stockPriceList")
@Expose
private StockPriceList stockPriceList;

/**
* No args constructor for use in serialization
*
*/
public StockPriceListOfCompany() {
}

/**
*
* @param stockPriceList
*/
public StockPriceListOfCompany(StockPriceList stockPriceList) {
super();
this.stockPriceList = stockPriceList;
}

public StockPriceList getStockPriceList() {
return stockPriceList;
}

public void setStockPriceList(StockPriceList stockPriceList) {
this.stockPriceList = stockPriceList;
}

}