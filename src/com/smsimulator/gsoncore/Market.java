package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Market {

@SerializedName("sectorName")
@Expose
private String sectorName;
@SerializedName("stocks")
@Expose
private List<Stock> stocks = null;

/**
* No args constructor for use in serialization
*
*/
public Market() {
}

/**
*
* @param sectorName
* @param stocks
*/
public Market(String sectorName, List<Stock> stocks) {
super();
this.sectorName = sectorName;
this.stocks = stocks;
}

public String getSectorName() {
return sectorName;
}

public void setSectorName(String sectorName) {
this.sectorName = sectorName;
}

public List<Stock> getStocks() {
return stocks;
}

public void setStocks(List<Stock> stocks) {
this.stocks = stocks;
}

}