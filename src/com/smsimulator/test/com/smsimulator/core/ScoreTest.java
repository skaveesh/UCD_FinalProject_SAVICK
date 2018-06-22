package com.smsimulator.core;

import org.junit.Test;
import static org.junit.Assert.*;

public class ScoreTest {
    private Score score = new Score("",50,50,50);
    boolean status = true;

    @Test
    public void getName() throws Exception {
        if(status) {
            assertEquals("", score.getName());
        }
    }

    @Test
    public void getStartBalance() throws Exception {
        double bal = 50;
        if(status){
            assertEquals("Account balance was not correct.", bal, score.getStartBalance(), 0);
        }
    }

    @Test
    public void getEndBalance() throws Exception {
        double bal = 50;
        if(status){
            assertEquals("Account balance was not correct.", bal, score.getEndBalance(), 0);
        }
    }

/*    public boolean getProfit() throws Exception {
        double bal = 50;
        if(status){
            assertEquals("Account balance was not correct.", bal, score.getProfit(), 0);
            return true;
        }
        else {
            return false;
        }
    }*/

    @Test
    public void getProfit() throws Exception {
        double bal = 50;
        assertEquals("Account balance was not correct.", bal, score.getProfit(), 0);
    }
}
