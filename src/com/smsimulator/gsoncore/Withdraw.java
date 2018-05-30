
package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Withdraw {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("receiver")
    @Expose
    private String receiver;
    @SerializedName("amount")
    @Expose
    private Double amount;

    /**
     * No args constructor for use in serialization
     */
    public Withdraw() {
    }

    /**
     * @param amount
     * @param receiver
     * @param name
     */
    public Withdraw(String name, String receiver, Double amount) {
        super();
        this.name = name;
        this.receiver = receiver;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}