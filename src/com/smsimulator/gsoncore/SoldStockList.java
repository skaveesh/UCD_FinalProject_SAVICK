package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SoldStockList {

@SerializedName("stock")
@Expose
private String stock;
@SerializedName("quantity")
@Expose
private Integer quantity;
@SerializedName("price")
@Expose
private Double price;
@SerializedName("turn")
@Expose
private Integer turn;

/**
* No args constructor for use in serialization
*
*/
public SoldStockList() {
}

/**
*
* @param turn
* @param price
* @param stock
* @param quantity
*/
public SoldStockList(String stock, Integer quantity, Double price, Integer turn) {
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

public Integer getQuantity() {
return quantity;
}

public void setQuantity(Integer quantity) {
this.quantity = quantity;
}

public Double getPrice() {
return price;
}

public void setPrice(Double price) {
this.price = price;
}

public Integer getTurn() {
return turn;
}

public void setTurn(Integer turn) {
this.turn = turn;
}

}