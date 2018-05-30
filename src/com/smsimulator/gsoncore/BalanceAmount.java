package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BalanceAmount {

    @SerializedName("amount")
    @Expose
    private Double amount;

    /**
     * No args constructor for use in serialization
     */
    public BalanceAmount() {
    }

    /**
     * @param amount
     */
    public BalanceAmount(Double amount) {
        super();
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}