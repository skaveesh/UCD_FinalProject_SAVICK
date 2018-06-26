package com.smsimulator.core;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-24.
 */
public class Ranking {
    private String name;
    private double profit;

    public Ranking(String name, double profit) {
        this.name = name;
        this.profit = profit;
    }

    public String getName() {
        return name;
    }

    public double getProfit() {
        return profit;
    }
}
