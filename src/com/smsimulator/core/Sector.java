package com.smsimulator.core;

/**
 * Created by Dilhara on 6/11/2018.
 */

import java.util.ArrayList;
import java.util.List;

public class Sector {
    public List<CompanyStock> stockList = new ArrayList<>();
    public String sectorName;

    public Sector(String sectorName){
        this.sectorName = sectorName;
    }

    public void addToSector(CompanyStock stock){
        stockList.add(stock);
    }

}
