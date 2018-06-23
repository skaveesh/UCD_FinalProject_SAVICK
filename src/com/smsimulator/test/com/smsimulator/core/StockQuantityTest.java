package com.smsimulator.core;
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
    public void getQuantity() throws Exception {
        Integer n = 1;
        assertEquals(n, stockQuantityTest.getQuantity());
    }
}
