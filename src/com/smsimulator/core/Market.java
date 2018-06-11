package com.smsimulator.core;

/**
 * Created by Dilhara on 6/11/2018.
 */

import java.util.ArrayList;
import java.util.List;

public class Market {
    private List<Sector> sectorList = new ArrayList<>();

    public void addToMarket(Sector sector){
        sectorList.add(sector);
    }

    public void increaseStockValuesInMarket(double value,int index){
        for(Sector sector:sectorList){
            for(CompanyStock stock:sector.stockList){
                stock.increaseStockValue(value,index);
            }
        }
    }

    public void decreaseStockValuesInMarket(double value,int index){
        for(Sector sector:sectorList){
            for(CompanyStock stock:sector.stockList){
                stock.decreaseStockValue(value,index);
            }
        }
    }
}
