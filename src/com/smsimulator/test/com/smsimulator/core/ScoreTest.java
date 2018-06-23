package com.smsimulator.core;

import org.junit.Test;
import static org.junit.Assert.*;

public class ScoreTest {
    private Score score = new Score("",50,50,50);

    @Test
    public void getName() throws Exception {
            assertEquals("", score.getName());
    }

    @Test
    public void getStartBalance() throws Exception {
        double bal = 50;
            assertEquals("Account balance was not correct.", bal, score.getStartBalance(), 0);
    }

    @Test
    public void getEndBalance() throws Exception {
        double bal = 50;
            assertEquals("Account balance was not correct.", bal, score.getEndBalance(), 0);
    }

    @Test
    public void getProfit() throws Exception {
        double bal = 50;
        assertEquals("Account balance was not correct.", bal, score.getProfit(), 0);
    }
}
