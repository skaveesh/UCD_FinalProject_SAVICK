package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StockAndUserDetails {

@SerializedName("name")
@Expose
private String name;
@SerializedName("stock")
@Expose
private String stock;
@SerializedName("quantity")
@Expose
private Integer quantity;
@SerializedName("price")
@Expose
private Double price;

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
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

}