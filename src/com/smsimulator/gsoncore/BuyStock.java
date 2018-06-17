package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BuyStock {

@SerializedName("buy")
@Expose
private Buy buy;

public Buy getBuy() {
return buy;
}

public void setBuy(Buy buy) {
this.buy = buy;
}

}