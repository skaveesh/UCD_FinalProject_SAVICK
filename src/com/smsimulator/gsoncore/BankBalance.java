package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BankBalance {

    @SerializedName("getBalance")
    @Expose
    private GetBalance getBalance;

    /**
     * No args constructor for use in serialization
     */
    public BankBalance() {
    }

    /**
     * @param getBalance
     */
    public BankBalance(GetBalance getBalance) {
        super();
        this.getBalance = getBalance;
    }

    public GetBalance getGetBalance() {
        return getBalance;
    }

    public void setGetBalance(GetBalance getBalance) {
        this.getBalance = getBalance;
    }

}