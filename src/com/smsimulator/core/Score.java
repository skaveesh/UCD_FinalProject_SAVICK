package com.smsimulator.core;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-21.
 */
public class Score {
    private String name;
    private double startBalance;
    private double endBalance;
    private double profit;

    public Score(String name, double startBalance, double endBalance, double profit) {
        this.name = name;
        this.startBalance = startBalance;
        this.endBalance = endBalance;
        this.profit = profit;
    }

    public String getName() {
        return name;
    }

    public double getStartBalance() {
        return startBalance;
    }

    public double getEndBalance() {
        return endBalance;
    }

    public double getProfit() {
        return profit;
    }
}
