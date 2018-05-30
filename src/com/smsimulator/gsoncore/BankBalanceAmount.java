package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BankBalanceAmount {

    @SerializedName("balanceAmount")
    @Expose
    private BalanceAmount balanceAmount;

    /**
     * No args constructor for use in serialization
     */
    public BankBalanceAmount() {
    }

    /**
     * @param balanceAmount
     */
    public BankBalanceAmount(BalanceAmount balanceAmount) {
        super();
        this.balanceAmount = balanceAmount;
    }

    public BalanceAmount getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BalanceAmount balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

}