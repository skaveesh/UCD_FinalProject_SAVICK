package com.smsimulator.core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-18.
 */
public class BankTransaction {
    @SerializedName("senderOrReceiver")
    @Expose
    private String senderOrReceiver;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("turn")
    @Expose
    private Integer turn;

    public BankTransaction(String senderOrReceiver, Double amount, Integer turn) {
        this.senderOrReceiver = senderOrReceiver;
        this.amount = amount;
        this.turn = turn;
    }

    public String getSenderOrReceiver() {
        return senderOrReceiver;
    }

    public void setSenderOrReceiver(String senderOrReceiver) {
        this.senderOrReceiver = senderOrReceiver;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }
}
