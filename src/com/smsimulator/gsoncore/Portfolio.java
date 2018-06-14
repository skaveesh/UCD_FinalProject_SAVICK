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
@SerializedName("ownStockList")
@Expose
private List<StockQuantity> ownStockList = null;
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
* @param ownStockList
* @param soldStockList
*/
public Portfolio(String name, List<StockQuantity> ownStockList, List<Transaction> broughtStockList, List<Transaction> soldStockList) {
super();
this.name = name;
this.ownStockList = ownStockList;
this.broughtStockList = broughtStockList;
this.soldStockList = soldStockList;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public List<StockQuantity> getOwnStockList() {
return ownStockList;
}

public void setOwnStockList(List<StockQuantity> ownStockList) {
this.ownStockList = ownStockList;
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