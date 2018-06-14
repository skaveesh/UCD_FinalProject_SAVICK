package com.smsimulator.gsoncore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stock {

@SerializedName("companyName")
@Expose
private String companyName;
@SerializedName("stock")
@Expose
private String stock;
@SerializedName("price")
@Expose
private double[] price;

/**
* No args constructor for use in serialization
*
*/
public Stock() {
}

/**
*
* @param price
* @param stock
* @param companyName
*/
public Stock(String companyName, String stock, double[] price) {
super();
this.companyName = companyName;
this.stock = stock;
this.price = price;
}

public String getCompanyName() {
return companyName;
}

public void setCompanyName(String companyName) {
this.companyName = companyName;
}

public String getStock() {
return stock;
}

public void setStock(String stock) {
this.stock = stock;
}

public double[] getPriceArray() {
return price;
}

public void setPriceArray(double[] price) {
this.price = price;
}

}