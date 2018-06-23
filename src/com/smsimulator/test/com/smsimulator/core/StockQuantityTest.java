package com.smsimulator.core;
import com.smsimulator.gsoncore.Stock;
import org.junit.Test;
import static org.junit.Assert.*;

public class StockQuantityTest {
    private StockQuantity stockQuantityTest = new StockQuantity("",1);

    @Test
    public void getStock() throws Exception {
        assertEquals("", stockQuantityTest.getStock());
        //assertTrue("", stockQuantityTest.getStock().contains("John Keells"));
    }

    @Test
    public void setStock() throws Exception {
        String testStock = "";
        //Stock testStock = new Stock();
        //stockQuantityTest.setStock(testStock.getStock());
        stockQuantityTest.setStock(testStock);
        assertEquals(testStock, stockQuantityTest.getStock());
    }

    @Test
    public void getQuantity() throws Exception {
        Integer n = 1;
        assertEquals(n, stockQuantityTest.getQuantity());
    }

    @Test
    public void setQuantity() throws Exception {
        Integer testQuantity = 1;
        assertEquals(testQuantity, stockQuantityTest.getQuantity());
    }
}
