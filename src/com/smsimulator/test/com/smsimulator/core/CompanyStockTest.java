package com.smsimulator.core;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dilhara on 6/17/2018.
 */
public class CompanyStockTest {

    private CompanyStock testCompanyStock = new CompanyStock("company","stock");

    @Test
    public void setNewStockValue() throws Exception {
        double testValue=84.56;
        int testIndex=10;
        testCompanyStock.setNewStockValue(testValue,testIndex);
        assertEquals(testValue,testCompanyStock.getStockPrice(testIndex),0.0f);
    }

    @Test
    public void setStockArray() throws Exception {
        double stockArray[] = new double[20];
        testCompanyStock.setStockArray(stockArray);
        assertEquals(stockArray,testCompanyStock.getStockPriceArray());
    }

    @Test
    public void getStockPrice() throws Exception {
        double testValue=84.56;
        int testIndex=10;
        testCompanyStock.setNewStockValue(testValue,testIndex);
        assertEquals(testValue,testCompanyStock.getStockPrice(testIndex),0.0f);
        int testIndex2=50;
        assertEquals(-1,testCompanyStock.getStockPrice(testIndex2),0.0f);
    }

    @Test
    public void getStockPriceArray() throws Exception {
        int arrayLength=20;
        assertEquals(arrayLength,testCompanyStock.getStockPriceArray().length);
    }

    @Test
    public void getStockName() throws Exception {
        assertEquals("stock",testCompanyStock.getStockName());
    }

    @Test
    public void getCompanyName() throws Exception {
        assertEquals("company",testCompanyStock.getCompanyName());
    }

}