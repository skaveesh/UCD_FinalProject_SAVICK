package com.smsimulator.core;

import java.util.List;
import java.util.Random;

public class MarketComponents {

    public List<Sector> importSectors(List<Sector> sectorList) {

        int marketComponent = new Random().nextInt(3) + 1;
        switch (marketComponent){
            case 1:
                int randomGeneralMarketTrendTurns = new Random().nextInt(5);

                for (int i = 0; i < randomGeneralMarketTrendTurns; i++) {
                    //market probability trend
                    sectorList = generalMarketComponent(sectorList);
                }
                break;
            case 2:
                int randomSectorMarketTrendTurns = new Random().nextInt(5);

                for (int i = 0; i < randomSectorMarketTrendTurns; i++) {
                    //sector event trend
                    int randomSectorNumberForSectorEvent = new Random().nextInt(sectorList.size()); //array out of bound
                    Sector sectorForSectorEvent = sectorList.get(randomSectorNumberForSectorEvent);//array out of bound

                    sectorList.set(randomSectorNumberForSectorEvent, sectorMarketComponent(sectorForSectorEvent));
                }
                break;
            case 3:
                int randomMarketTrendTurns = new Random().nextInt(5);

                for (int i = 0; i < randomMarketTrendTurns; i++) {
                    //stock event (random market event)
                    int randomSectorNumberForRandomEvent = new Random().nextInt(sectorList.size());
                    Sector sectorForRandomEvent = sectorList.get(randomSectorNumberForRandomEvent);
                    int randomStockNumberForRandomEvent = new Random().nextInt(sectorForRandomEvent.stockList.size());
                    CompanyStock companyStockForRandomEvent = sectorForRandomEvent.stockList.get(randomStockNumberForRandomEvent);

                    sectorForRandomEvent.stockList.set(randomStockNumberForRandomEvent, randomMarketComponent(companyStockForRandomEvent));
                    sectorList.set(randomSectorNumberForRandomEvent, sectorForRandomEvent);
                }
                break;
        }
        //event componect object

        EventComponent eventComponent = new EventComponent();
        sectorList = eventComponent.eventComponentGenerator(sectorList);

        return sectorList;
    }

    private CompanyStock randomMarketComponent(CompanyStock companyStock) {

        double[] stockPriceArray = companyStock.getStockPriceArray();

        for (int i = 0; i < 20; i++) {
            stockPriceArray[i] = stockPriceArray[i] + new Random().nextInt(5) + (-2);
//            stockPriceArray[i] =  new Random().nextInt(5) + (-2);
            if (i > 0 && ((stockPriceArray[i - 1] - stockPriceArray[i] > 1) || (stockPriceArray[i - 1] - stockPriceArray[i] < -1))) {
                stockPriceArray[i] = stockPriceArray[i - 1];
            }
        }
        companyStock.setStockArray(stockPriceArray);
        return companyStock;
    }

    private Sector sectorMarketComponent(Sector sector) {

        for (CompanyStock companyStock : sector.stockList) {
            double[] stockPriceArray = companyStock.getStockPriceArray();
            double[] newStockPriceArray = new double[20];

            for (int i = 0; i < 20; i++) {
                stockPriceArray[i] = stockPriceArray[i] + new Random().nextInt(7) + (-3);
//                stockPriceArray[i] = new Random().nextInt(7) + (-3);
                if (i > 0 && ((stockPriceArray[i - 1] - stockPriceArray[i] > 1) || (stockPriceArray[i - 1] - stockPriceArray[i] < -1))) {
                    stockPriceArray[i] = stockPriceArray[i - 1];
                }
                newStockPriceArray[i] = stockPriceArray[i];
            }
            companyStock.setStockArray(newStockPriceArray);
        }
        return sector;
    }

    private List<Sector> generalMarketComponent(List<Sector> sectorList) {

        for (Sector sector : sectorList) {
            for (CompanyStock companyStock : sector.stockList) {
                double[] stockPriceArray = companyStock.getStockPriceArray();
                double[] newStockPriceArray = new double[20];

                for (int i = 0; i < 20; i++) {
                    stockPriceArray[i] = stockPriceArray[i] + new Random().nextInt(7) + (-3);
//                    stockPriceArray[i] = new Random().nextInt(7) + (-3);
                    if (i > 0 && ((stockPriceArray[i - 1] - stockPriceArray[i] > 1) || (stockPriceArray[i - 1] - stockPriceArray[i] < -1))) {
                        stockPriceArray[i] = stockPriceArray[i - 1];
                    }
                }
                companyStock.setStockArray(stockPriceArray);
            }
        }
        return sectorList;
    }
}
