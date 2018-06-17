package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SellStock {

@SerializedName("sell")
@Expose
private Sell sell;

public Sell getSell() {
return sell;
}

public void setSell(Sell sell) {
this.sell = sell;
}

}