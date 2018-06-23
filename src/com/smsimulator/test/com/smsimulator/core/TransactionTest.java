package com.smsimulator.core;
import org.junit.Test;
import static org.junit.Assert.*;

public class TransactionTest {
    private Transaction transactiontest = new Transaction("",1,0.f,1);

    @Test
    public void getStock() throws Exception {
        assertEquals("", transactiontest.getStock());
    }

    @Test
    public void getQuantity() throws Exception {
        assertEquals(1,transactiontest.getQuantity());
    }

    @Test
    public void getPrice() throws Exception {
        assertEquals("",0.f,transactiontest.getPrice(), 0);
    }

    @Test
    public void getTurn() throws Exception {
        assertEquals(1, transactiontest.getTurn());
    }

    @Test
    public void setStock() throws Exception {
    }
}
