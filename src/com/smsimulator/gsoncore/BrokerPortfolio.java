
package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BrokerPortfolio {

@SerializedName("portfolio")
@Expose
private Portfolio portfolio;

/**
* No args constructor for use in serialization
*
*/
public BrokerPortfolio() {
}

/**
*
* @param portfolio
*/
public BrokerPortfolio(Portfolio portfolio) {
super();
this.portfolio = portfolio;
}

public Portfolio getPortfolio() {
return portfolio;
}

public void setPortfolio(Portfolio portfolio) {
this.portfolio = portfolio;
}

}