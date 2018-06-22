package com.smsimulator.core;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dilhara on 6/20/2018.
 */
public class PlayerTest {
    private Player testPlayer  = new Player();
    @Test
    public void createAccount() throws Exception {
        //start DB service
        DBUtils dbtest = new DBUtils();
        //assert that the createAccount method executes successfully when given a valid username and a password
        assertTrue(testPlayer.createAccount("David","1530"));
    }

    @Test
    public void loginPlayer() throws Exception {
        DBUtils dbtest = new DBUtils();
        //assert that the login method returns true when given a valid username and the respective password
        assertTrue(testPlayer.loginPlayer("David","1530"));
    }

    @Test
    public void getUidFromName() throws Exception {
        DBUtils dbtest = new DBUtils();
        //assert that the method returns the Uid of the player
        assertNotEquals(-1,testPlayer.getUidFromName("dilhara"));
    }

    /*public boolean getUidFromName() throws Exception {
        boolean status = true;
        if(status){
            assertNotEquals(-1,testPlayer.getUidFromName("dilhara"));
            return true;
        }
        else{
            return false;
        }
    }*/

}