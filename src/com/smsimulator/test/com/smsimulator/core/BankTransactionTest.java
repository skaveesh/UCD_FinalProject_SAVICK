package com.smsimulator.core;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dilhara on 6/23/2018.
 */
public class BankTransactionTest {

    private BankTransaction testBankTransaction = new BankTransaction("sender",150.50,1);

    @Test
    public void getSenderOrReceiver() throws Exception {
        assertEquals("sender",testBankTransaction.getSenderOrReceiver());
    }

    @Test
    public void setSenderOrReceiver() throws Exception {
        String senderOrReceiver = "receiver";
        testBankTransaction.setSenderOrReceiver(senderOrReceiver);
        assertEquals(senderOrReceiver,testBankTransaction.getSenderOrReceiver());
    }

    @Test
    public void getAmount() throws Exception {
        double testAmount = 150.50;
        assertEquals(testAmount,testBankTransaction.getAmount(),0.0f);
    }

    @Test
    public void setAmount() throws Exception {
        double testAmount = 155.45;
        testBankTransaction.setAmount(testAmount);
        assertEquals(testAmount,testBankTransaction.getAmount(),0.0f);
    }

    @Test
    public void getTurn() throws Exception {
        int testTurn = 1;
        assertEquals(testTurn,testBankTransaction.getTurn(),0);
    }

    @Test
    public void setTurn() throws Exception {
        int testTurn = 1;
        testBankTransaction.setTurn(testTurn);
        assertEquals(testTurn,testBankTransaction.getTurn(),0);
    }

}