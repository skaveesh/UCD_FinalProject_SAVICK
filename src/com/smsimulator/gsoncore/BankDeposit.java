package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BankDeposit {

    @SerializedName("deposit")
    @Expose
    private Deposit deposit;

    /**
     * No args constructor for use in serialization
     */
    public BankDeposit() {
    }

    /**
     * @param deposit
     */
    public BankDeposit(Deposit deposit) {
        super();
        this.deposit = deposit;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

}