package com.smsimulator.core;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dilhara on 6/16/2018.
 */
public class MarketTest {

    private Market testMarket = new Market();
    private Sector testSector = new Sector("sector");
    private CompanyStock testStock = new CompanyStock("company","sector");

    @Test
    public void addToMarket() throws Exception {
        testMarket.addToMarket(testSector);
        assertTrue(testMarket.sectorList.contains(testSector));
    }

    @Test
    public void setNewStockValuesInMarket() throws Exception {
        double testValue = 78.51;
        int testIndex = 14;
        testMarket.addToMarket(testSector);
        testSector.addToSector(testStock);
        testMarket.setNewStockValuesInMarket(testValue,testIndex);
        assertEquals(testValue,testStock.getStockPrice(testIndex),0.0f);
    }

}