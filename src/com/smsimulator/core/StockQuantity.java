package com.smsimulator.core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-13.
 */
public class StockQuantity {

    @SerializedName("stock")
    @Expose
    private String stock;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;

    public StockQuantity() {
    }

    public StockQuantity(String stock, Integer quantity) {
        super();
        this.stock = stock;
        this.quantity = quantity;
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

}
