package com.smsimulator.core;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PortfolioTest {

    private List<StockQuantity> ownStockList = new ArrayList<>();
    private List<Transaction> broughtStockList = new ArrayList<>();
    private List<Transaction> soldStockList = new ArrayList<>();

    Portfolio portfolioTest = new Portfolio("", ownStockList, broughtStockList, soldStockList);

    @Test
    public void getName() throws Exception {
        assertEquals("", portfolioTest.getName());
    }

    @Test
    public void getBroughtStockList() throws Exception {
        assertEquals(broughtStockList, portfolioTest.getOwnStockList());
    }
    @Test
    public void getSoldStockList() throws Exception {
        assertEquals(soldStockList, portfolioTest.getOwnStockList());
    }

}
