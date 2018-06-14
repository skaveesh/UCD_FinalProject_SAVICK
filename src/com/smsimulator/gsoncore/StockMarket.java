
package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StockMarket {

@SerializedName("market")
@Expose
private List<Market> market = null;

/**
* No args constructor for use in serialization
*
*/
public StockMarket() {
}

/**
*
* @param market
*/
public StockMarket(List<Market> market) {
super();
this.market = market;
}

public List<Market> getMarket() {
return market;
}

public void setMarket(List<Market> market) {
this.market = market;
}

}