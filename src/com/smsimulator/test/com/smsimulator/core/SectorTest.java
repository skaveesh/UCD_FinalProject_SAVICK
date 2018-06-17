package com.smsimulator.core;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dilhara on 6/17/2018.
 */
public class SectorTest {

    private Sector testSector = new Sector("sector");
    private CompanyStock testStock = new CompanyStock("company","sector");

    @Test
    public void addToSector() throws Exception {
        testSector.addToSector(testStock);
        assertTrue(testSector.stockList.contains(testStock));
    }

    @Test
    public void setNewStockValuesInSector() throws Exception {
        double testValue = 79.12;
        int testIndex = 2;
        testSector.addToSector(testStock);
        assertEquals(testValue,testStock.getStockPrice(testIndex),0.0f);
    }

}