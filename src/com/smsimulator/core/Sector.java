package com.smsimulator.core;

/**
 * Created by Dilhara on 6/11/2018.
 */

import java.util.ArrayList;
import java.util.List;

public class Sector {
    public List<CompanyStock> stockList = new ArrayList<>();

    public void addToSector(CompanyStock stock){
        stockList.add(stock);
    }

    public  void increaseStockValuesInSector(double value, int index){
        for(CompanyStock stock:stockList){
            stock.increaseStockValue(value,index);
        }
    }

    public  void decreaseStockValuesInSector(double value, int index){
        for(CompanyStock stock:stockList){
            stock.decreaseStockValue(value,index);
        }
    }
}
