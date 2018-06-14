package com.smsimulator.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-12.
 */
public class Portfolio {

    private String name;
    private List<StockQuantity> ownStockList = new ArrayList<>();
    private List<Transaction> broughtStockList = new ArrayList<>();
    private List<Transaction> soldStockList = new ArrayList<>();

    public Portfolio(String name, List<StockQuantity> ownStockList, List<Transaction> broughtStockList, List<Transaction> soldStockList) {
        this.name = name;
        this.ownStockList = ownStockList;
        this.broughtStockList = broughtStockList;
        this.soldStockList = soldStockList;
    }

    public String getName() {
        return name;
    }

    public List<StockQuantity> getOwnStockList() {
        return ownStockList;
    }

    public List<Transaction> getBroughtStockList() {
        return broughtStockList;
    }

    public List<Transaction> getSoldStockList() {
        return soldStockList;
    }
}
