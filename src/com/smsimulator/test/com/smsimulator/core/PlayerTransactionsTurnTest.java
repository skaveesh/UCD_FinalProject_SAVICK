package com.smsimulator.core;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTransactionsTurnTest {
    PlayerTransactionsOfTurn playerTransactionsTurnTest = new PlayerTransactionsOfTurn();

    @Test
    public void getName() throws Exception {
        assertEquals("", playerTransactionsTurnTest.getName());
    }

    @Test
    public void setName() throws Exception {
        String stockName = "";
        playerTransactionsTurnTest.setName(stockName);
        assertEquals(stockName, playerTransactionsTurnTest.getName());
    }

    @Test
    public void setSellOrBuy() throws Exception {
        String testSellOrBuy = "";
        playerTransactionsTurnTest.setSellOrBuy(testSellOrBuy);
        assertEquals(testSellOrBuy, playerTransactionsTurnTest.getSellOrBuy());
    }

    @Test
    public void getStock() throws Exception {
        assertEquals("", playerTransactionsTurnTest.getStock());
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
        assertEquals(testQuantity, playerTransactionsTurnTest.getQuantity());
    }

    @Test
    public void setQuantity() throws Exception {
        Integer testQuantity = 1;
        playerTransactionsTurnTest.setQuantity(testQuantity);
        assertEquals(testQuantity, playerTransactionsTurnTest.getQuantity());
    }

    @Test
    public void getStockPrice() throws Exception {
        assertEquals(0.f, playerTransactionsTurnTest.getStockPrice(), 0.f);
    }

    @Test
    public void setStockPrice() throws Exception {
        double testStockPrice = 0.f;
        playerTransactionsTurnTest.setStockPrice(testStockPrice);
        assertEquals(testStockPrice, playerTransactionsTurnTest.getStockPrice(), 0.f);
    }

}
