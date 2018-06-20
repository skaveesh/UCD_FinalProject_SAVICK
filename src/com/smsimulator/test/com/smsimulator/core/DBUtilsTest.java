package com.smsimulator.core;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dilhara on 6/19/2018.
 */
public class DBUtilsTest {

    @Test
    public void isConnectionInitiated() throws Exception {
        //start db connection
        DBUtils dbtest = new DBUtils();
        assertTrue(dbtest.isConnectionInitiated());
    }

    @Test
    public void getDatabaseConnection() throws Exception {
        DBUtils dbtest = new DBUtils();
        String dbTestString = "com.mysql.jdbc";
        assertEquals(dbTestString,dbtest.getDatabaseConnection().toString().substring(0,14));
    }

}