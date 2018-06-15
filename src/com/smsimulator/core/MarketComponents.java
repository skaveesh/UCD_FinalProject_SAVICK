package com.smsimulator.core;


import java.util.Random;

public class MarketComponents {

    private double randomMarketComponentArray[] = new double[20];
    private double sectorMarketComponentArray[] = new double[20];
    private double generalMarketComponentArray[] = new double[20];
    private double totalTrendsArray[] = new double[randomMarketComponentArray.length];
    private double stockValuesArray[] = new double[20];
    private double stockEventsArray[] = new double[20];

    public MarketComponents() {
        this.randomMarketComponent();
        this.sectorMarketComponent();
        this.generalMarketComponent();
        this.generateTotalTrends();
        this.generateStockValues();
    }

    private void randomMarketComponent() {
        for (int i = 0; i < randomMarketComponentArray.length; i++) {
            randomMarketComponentArray[i] = new Random().nextInt(5) + (-2);
            if(i>0 && ((randomMarketComponentArray[i-1]-randomMarketComponentArray[i]>1) || (randomMarketComponentArray[i-1]-randomMarketComponentArray[i]<-1))){
                randomMarketComponentArray[i] = randomMarketComponentArray[i-1];
            }
        }
    }

    public double[] getrandomMarketComponent() {
        return randomMarketComponentArray;
    }

    private void sectorMarketComponent() {
        for (int j = 0; j < sectorMarketComponentArray.length; j++) {
            sectorMarketComponentArray[j] = new Random().nextInt(7) + (-3);
//            System.out.println(sectorMarketComponentArray[j]);
            if(j>0 && ((sectorMarketComponentArray[j-1]-sectorMarketComponentArray[j]>1) || (sectorMarketComponentArray[j-1]-sectorMarketComponentArray[j]<-1))){
                sectorMarketComponentArray[j] = sectorMarketComponentArray[j-1];
            }
        }
    }

    public double[] getsectorMarketComponent() {
        return sectorMarketComponentArray;
    }


    private void generalMarketComponent() {

        for (int k = 0; k < generalMarketComponentArray.length; k++) {
            generalMarketComponentArray[k] = new Random().nextInt(7) + (-3);
            if(k>0 && ((generalMarketComponentArray[k-1]-generalMarketComponentArray[k]>1) || (generalMarketComponentArray[k-1]-generalMarketComponentArray[k]<-1))){
                generalMarketComponentArray[k] = generalMarketComponentArray[k-1];
            }
        }
    }

    public double[] getgeneralMarketComponent() {
        return generalMarketComponentArray;
    }

    private void generateTotalTrends() {
        for (int n = 0; n < randomMarketComponentArray.length; n++) {
            totalTrendsArray[n] = randomMarketComponentArray[n] + sectorMarketComponentArray[n] + generalMarketComponentArray[n];
            if (totalTrendsArray[n] < 0) {
                totalTrendsArray[n] = 0;
            }
        }
    }

    private void generateStockValues(){
        EventComponent events = new EventComponent();
        stockEventsArray = events.getEventsArray().clone();
        for (int n = 0; n < totalTrendsArray.length; n++) {
            stockValuesArray[n] = totalTrendsArray[n] + stockEventsArray[n];
            if (stockValuesArray[n] < 0) {
                stockValuesArray[n] = 0;
            }
        }
    }

    public double[] getStockValues(){
        return stockValuesArray;
    }
}
