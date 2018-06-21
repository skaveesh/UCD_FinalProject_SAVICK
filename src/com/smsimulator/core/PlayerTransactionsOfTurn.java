package com.smsimulator.core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayerTransactionsOfTurn {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sellOrBuy")
    @Expose
    private String sellOrBuy;
    @SerializedName("stock")
    @Expose
    private String stock;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("stockPrice")
    @Expose
    private Double stockPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSellOrBuy() {
        return sellOrBuy;
    }

    public void setSellOrBuy(String sellOrBuy) {
        this.sellOrBuy = sellOrBuy;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(Double stockPrice) {
        this.stockPrice = stockPrice;
    }

}