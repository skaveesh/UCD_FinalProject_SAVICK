package com.smsimulator.core;

import java.util.List;

/**
 * Created by asusgeforce on 16/06/2018.
 */
public class AIPlayer extends AnalyserMain {

    private double[] value;
    Broker broker = new Broker();

    public double[] startToBuy(){
        value = broker.price("TAB");
        return value;
    }

}
