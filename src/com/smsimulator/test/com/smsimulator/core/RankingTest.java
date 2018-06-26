package com.smsimulator.core;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by asusgeforce on 26/06/2018.
 */
public class RankingTest {

    private Ranking rankingTest = new Ranking("name", 60.25);

    @Test
    public void getName() throws Exception{
        assertEquals("name", rankingTest.getName());
    }

    @Test
    public void getProfit(){

        assertEquals("Profit is ", 60.25, rankingTest.getProfit(),0.0f);
    }
}
