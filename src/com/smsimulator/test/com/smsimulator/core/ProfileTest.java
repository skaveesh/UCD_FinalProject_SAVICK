package com.smsimulator.core;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProfileTest {
    private List<BankTransaction> depositTransactionList = new ArrayList<>();
    private List<BankTransaction> withdrawTransactionList = new ArrayList<>();

    private Profile profileTest = new Profile("", 0.f, depositTransactionList, withdrawTransactionList);

    @Test
    public void getName() throws Exception {
        assertEquals("",profileTest.getName());
    }

    @Test
    public void getBankBalance() throws Exception {
        assertEquals(0.f, profileTest.getBankBalance(), 0.f);
    }

    @Test
    public void getDepositTransactionList () throws Exception {
        assertEquals(depositTransactionList, profileTest.getDepositTransactionList()); // need to test with actual lists
    }

    @Test
    public void getWithdrawTransactionList () throws Exception {
        assertEquals(withdrawTransactionList, profileTest.getWithdrawTransactionList()); // need to test with actual lists
    }
}
