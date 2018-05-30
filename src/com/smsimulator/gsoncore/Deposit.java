package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Deposit {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sender")
    @Expose
    private String sender;
    @SerializedName("amount")
    @Expose
    private Double amount;

    /**
     * No args constructor for use in serialization
     */
    public Deposit() {
    }

    /**
     * @param amount
     * @param sender
     * @param name
     */
    public Deposit(String name, String sender, Double amount) {
        super();
        this.name = name;
        this.sender = sender;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}