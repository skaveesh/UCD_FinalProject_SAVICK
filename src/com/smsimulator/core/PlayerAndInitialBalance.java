package com.smsimulator.core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayerAndInitialBalance {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("startBalance")
    @Expose
    private Double startBalance;

    public PlayerAndInitialBalance(String name, Double startBalance) {
        this.name = name;
        this.startBalance = startBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getStartBalance() {
        return startBalance;
    }

    public void setStartBalance(Double startBalance) {
        this.startBalance = startBalance;
    }

}