package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sell {

@SerializedName("stockAndUserDetails")
@Expose
private StockAndUserDetails stockAndUserDetails;

public StockAndUserDetails getStockAndUserDetails() {
return stockAndUserDetails;
}

public void setStockAndUserDetails(StockAndUserDetails stockAndUserDetails) {
this.stockAndUserDetails = stockAndUserDetails;
}

}