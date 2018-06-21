package com.smsimulator.core;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dilhara on 6/20/2018.
 */
public class BrokerTest {

    private Broker testBroker = new Broker();

    @Test
    public void generateNewStock() throws Exception {
        testBroker.generateNewStock();
        assertNotEquals(null,testBroker.getSectorList());
    }

    @Test
    public void getSectorList() throws Exception {
        testBroker.generateNewStock();
        assertNotEquals(null,testBroker.getSectorList());
    }

    @Test
    public void createAccount() throws Exception {
        //start DB service
        DBUtils dbtest = new DBUtils();
        assertTrue(testBroker.createAccount(1,"testPlayer"));
    }

    @Test
    public void checkExistenceOfAccount() throws Exception {
        DBUtils dbtest = new DBUtils();
        //assert that the method returns true when given a valid username to check existence of a player in the broker account
        assertTrue(testBroker.checkExistenceOfAccount("dilhara"));
    }

    @Test
    public void portfolio() throws Exception {
        DBUtils dbtest = new DBUtils();
        assertNotEquals(null,testBroker.portfolio("dilhara"));
    }

    @Test
    public void price() throws Exception {
        testBroker.generateNewStock();
        assertNotEquals(null,testBroker.price("HNB"));
    }


    @Test
    public void price1() throws Exception {
        testBroker.generateNewStock();
        //System.out.println(testBroker.price("HNB",10));
        assertNotEquals(null,testBroker.price("HNB",10));
    }

    @Test
    public void buy() throws Exception {
        DBUtils dbtest = new DBUtils();
        //assert that the buy method executes successfully for given valid information and a valid price
        assertTrue(testBroker.buy(1,"dilhara","HNB",2,112.20));
        //assert that the method returns false for an invalid price (player does not have enough money to buy)
        assertFalse(testBroker.buy(2,"dilhara","HNB",2,555.00));
    }

    @Test
    public void sell() throws Exception {
        DBUtils dbtest = new DBUtils();
        //assert that the sell method returns true when given a valid turn , username , quantity and a price
        assertTrue(testBroker.sell(3,"dilhara","HNB",2,115.20));
        //assert that the sell method returns false for an invalid quantity
        assertFalse(testBroker.sell(4,"dilhara","HNB",5,115.20));
    }

}