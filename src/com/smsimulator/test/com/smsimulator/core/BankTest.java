package com.smsimulator.core;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dilhara on 6/19/2018.
 */
public class BankTest {

    private Bank testBank = new Bank();

    @Test
    public void createAccount() throws Exception {
        //start DB service
        DBUtils dbtest = new DBUtils();
        //assert that the createAccount method executes successfully when given a valid username and a turn
        assertTrue(testBank.createAccount(1,"David"));
    }

    @Test
    public void checkExistenceOfAccount() throws Exception {
        DBUtils dbtest = new DBUtils();
        //assert that the checkExistenceOfAccount method returns true when given a valid username.
        assertTrue(testBank.checkExistenceOfAccount("dilhara"));
    }

    @Test
    public void deposit() throws Exception {
        DBUtils dbtest = new DBUtils();
        //assert that the deposit method executes successfully when given a valid turn,username,receiver and amount
        assertTrue(testBank.deposit(2,"dilhara","HNB",156.50));
    }

    @Test
    public void withdraw() throws Exception {
        DBUtils dbtest = new DBUtils();
        //assert that the withdraw method executes successfully
        assertTrue(testBank.withdraw(3,"dilhara","HNB",96.50));
    }

    @Test
    public void balance() throws Exception {
        DBUtils dbtest = new DBUtils();
        //assert that the balance method does not return -1 , it returns the balance
        assertNotEquals(-1,testBank.balance("dilhara"));
    }


}