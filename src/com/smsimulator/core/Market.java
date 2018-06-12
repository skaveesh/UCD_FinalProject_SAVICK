package com.smsimulator.core;

/**
 * Created by Dilhara on 6/11/2018.
 */

import java.util.ArrayList;
import java.util.List;

public class Market {
    public List<Sector> sectorList = new ArrayList<>();

    public void addToMarket(Sector sector){
        sectorList.add(sector);
    }

    public void setNewStockValuesInMarket(double value,int index){
        for(Sector sector:sectorList){
            for(CompanyStock stock:sector.stockList){
                stock.setNewStockValue(value,index);
            }
        }
    }
}
