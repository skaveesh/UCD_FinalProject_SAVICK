package com.smsimulator.core;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by asusgeforce on 26/06/2018.
 */
public class PredictionTest {

    private Prediction prediction = new Prediction("Buy", "HNB");

    @Test
    public void getBuyOrSell() throws Exception{
        assertEquals("Buy", prediction.getBuyOrSell());
    }

    @Test
    public void getStockName() throws Exception{
        assertEquals("HNB", prediction.getStockName());
    }
}
