package com.smsimulator.core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-12.
 */
public class Transaction {

    @SerializedName("stock")
    @Expose
    private String stock;
    @SerializedName("quantity")
    @Expose
    private int quantity;
    @SerializedName("price")
    @Expose
    private double price;
    @SerializedName("turn")
    @Expose
    private int turn;

    public Transaction() {
    }

    public Transaction(String stock, int quantity, double price, int turn) {
        super();
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
        this.turn = turn;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
