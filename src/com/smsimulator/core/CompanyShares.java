package com.smsimulator.core;

import java.util.Random;

public class CompanyShares {

    private Double[] generatedCompanyStockArray = new Double[20];

    public CompanyShares() {
        this.generateRandomStocks();
    }

    public Double[] getGeneratedCompanyStockArray() {
        return generatedCompanyStockArray;
    }

    private void generateRandomStocks() {
        for (int i = 0; i < 20; i++) {
            generatedCompanyStockArray[i] = Math.round((new Random().nextDouble() * (120.2f - 90.2f) + 90.2f) * 100f) / 100d;
        }
    }

}
