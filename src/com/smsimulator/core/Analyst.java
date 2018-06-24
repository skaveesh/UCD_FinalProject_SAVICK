package com.smsimulator.core;

/**
 * Created by asusgeforce on 16/06/2018.
 */
public class Analyst extends AnalyserMain {

    public String recommendedStocks[] = new String[10];

    public Analyst() {
        recommendedStocks[0] = "Buy HNB";

        //recommendedStocks = {"Buy HNB", "Buy TAB", "Sell SUN", "Buy SIRA", "Sell GSK", "Sell DLT", "Buy UNI", "Buy MGC", "Buy SHL", "Sell JKH"};
    }

    public String[] getRecommendations() {
        return recommendedStocks;
    }
}
