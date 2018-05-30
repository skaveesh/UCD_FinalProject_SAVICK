
package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BankWithdraw {

    @SerializedName("withdraw")
    @Expose
    private Withdraw withdraw;

    /**
     * No args constructor for use in serialization
     */
    public BankWithdraw() {
    }

    /**
     * @param withdraw
     */
    public BankWithdraw(Withdraw withdraw) {
        super();
        this.withdraw = withdraw;
    }

    public Withdraw getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(Withdraw withdraw) {
        this.withdraw = withdraw;
    }

}