package com.smsimulator.core;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by asusgeforce on 26/06/2018.
 */
public class PredictionHistoryArrayTest {

    private double[] testvalues;

    private PredictionHistoryArray predictionHistoryArray = new PredictionHistoryArray(testvalues, "");

    @Test
    public void getHistory()throws Exception{
        assertEquals(testvalues, predictionHistoryArray.getHistory());
    }

    @Test
    public void getStockName() throws Exception{
        assertEquals("", predictionHistoryArray.getStockName());
    }
}
