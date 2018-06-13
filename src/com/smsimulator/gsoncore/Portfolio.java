package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.smsimulator.core.StockQuantity;
import com.smsimulator.core.Transaction;

import java.util.List;

public class Portfolio {

@SerializedName("name")
@Expose
private String name;
@SerializedName("stockQuantityList")
@Expose
private List<StockQuantity> stockQuantityList = null;
@SerializedName("broughtStockList")
@Expose
private List<Transaction> broughtStockList = null;
@SerializedName("soldStockList")
@Expose
private List<Transaction> soldStockList = null;

/**
* No args constructor for use in serialization
*
*/
public Portfolio() {
}

/**
*
* @param broughtStockList
* @param name
* @param stockQuantityList
* @param soldStockList
*/
public Portfolio(String name, List<StockQuantity> stockQuantityList, List<Transaction> broughtStockList, List<Transaction> soldStockList) {
super();
this.name = name;
this.stockQuantityList = stockQuantityList;
this.broughtStockList = broughtStockList;
this.soldStockList = soldStockList;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public List<StockQuantity> getStockQuantityList() {
return stockQuantityList;
}

public void setStockQuantityList(List<StockQuantity> stockQuantityList) {
this.stockQuantityList = stockQuantityList;
}

public List<Transaction> getBroughtStockList() {
return broughtStockList;
}

public void setBroughtStockList(List<Transaction> broughtStockList) {
this.broughtStockList = broughtStockList;
}

public List<Transaction> getSoldStockList() {
return soldStockList;
}

public void setSoldStockList(List<Transaction> soldStockList) {
this.soldStockList = soldStockList;
}

}