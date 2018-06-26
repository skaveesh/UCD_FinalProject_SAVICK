package com.smsimulator.core;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTransactionsTurnTest {
    PlayerTransactionsOfTurn playerTransactionsTurnTest = new PlayerTransactionsOfTurn();

    @Test
    public void getName() throws Exception {
        assertNotEquals("", playerTransactionsTurnTest.getName());
    }

    @Test
    public void setName() throws Exception {
        String stockName = "";
        playerTransactionsTurnTest.setName(stockName);
        assertEquals(stockName, playerTransactionsTurnTest.getName());
    }

    @Test
    public void setSellOrBuy() throws Exception {
        String testSellOrBuy = "buy";
        playerTransactionsTurnTest.setSellOrBuy(testSellOrBuy);
        assertEquals(testSellOrBuy, playerTransactionsTurnTest.getSellOrBuy());
    }

    @Test
    public void getStock() throws Exception {
        assertNotEquals("", playerTransactionsTurnTest.getStock());
    }

    @Test
    public void setStock() throws Exception {
        String testStock = "";
        playerTransactionsTurnTest.setStock(testStock);
        assertEquals(testStock, playerTransactionsTurnTest.getStock());
    }

    @Test
    public void getQuantity() throws Exception {
        Integer testQuantity = 1;
        assertNotEquals(testQuantity, playerTransactionsTurnTest.getQuantity());
    }

    @Test
    public void setQuantity() throws Exception {
        Integer testQuantity = 1;
        playerTransactionsTurnTest.setQuantity(testQuantity);
        assertEquals(testQuantity, playerTransactionsTurnTest.getQuantity());
    }

    @Test
    public void getStockPrice() throws Exception {
        Integer i = 1;
        assertNotEquals(i, playerTransactionsTurnTest.getQuantity());
    }

    @Test
    public void setStockPrice() throws Exception {
        double testStockPrice = 50.25;
        playerTransactionsTurnTest.setStockPrice(testStockPrice);
        assertEquals(testStockPrice, playerTransactionsTurnTest.getStockPrice(), 0.0f);
    }

}
