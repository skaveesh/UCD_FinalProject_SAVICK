package com.smsimulator.core;


import java.util.Random;

public class MarketComponents {

        private double randomMarketComponentArray[] = new double[20];
        private double sectorMarketComponentArray[] = new double[20];
        private double generalMarketComponentArray[] = new double[20];
        private double totalTrendsArray[] = new double[randomMarketComponentArray.length];

        public MarketComponents() {
            this.randomMarketComponent();
            this.sectorMarketComponent();
            this.generalMarketComponent();
        }

        private void randomMarketComponent() {
            for (int i = 0; i < randomMarketComponentArray.length; i++) {
                randomMarketComponentArray[i] = new Random().nextInt(5) + (-2);
            }

        }

        public double[] getrandomMarketComponent() {
            return randomMarketComponentArray;
        }

        private void sectorMarketComponent() {
            for (int j = 0; j < sectorMarketComponentArray.length; j++) {
                sectorMarketComponentArray[j] = new Random().nextInt(7) + (-3);
            }

        }

        public double[] getsectorMarketComponent() {
            return sectorMarketComponentArray;
        }


        private void generalMarketComponent() {

            for (int k = 0; k < generalMarketComponentArray.length; k++) {
                generalMarketComponentArray[k] = new Random().nextInt(7) + (-3);
            }

        }

        public double[] getgeneralMarketComponent() {
            return generalMarketComponentArray;
        }

        public double[] getTotalTrends() {
            for (int n = 0; n < randomMarketComponentArray.length; n++) {
                totalTrendsArray[n] = randomMarketComponentArray[n] + sectorMarketComponentArray[n] + generalMarketComponentArray[n];
                if (totalTrendsArray[n] < 0) {
                    totalTrendsArray[n] = 0;
                }
            }
            return totalTrendsArray;
        }
    
}
