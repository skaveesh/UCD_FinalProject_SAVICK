package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StockPrice {

@SerializedName("companyName")
@Expose
private String companyName;
@SerializedName("stockName")
@Expose
private String stockName;
@SerializedName("price")
@Expose
private double price;

/**
* No args constructor for use in serialization
*
*/
public StockPrice() {
}

/**
*
* @param price
* @param stockName
* @param companyName
*/
public StockPrice(String companyName, String stockName, double price) {
super();
this.companyName = companyName;
this.stockName = stockName;
this.price = price;
}

public String getCompanyName() {
return companyName;
}

public void setCompanyName(String companyName) {
this.companyName = companyName;
}

public String getStockName() {
return stockName;
}

public void setStockName(String stockName) {
this.stockName = stockName;
}

public double getPrice() {
return price;
}

public void setPrice(double price) {
this.price = price;
}

}