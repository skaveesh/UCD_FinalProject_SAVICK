package com.smsimulator.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MarketComponents {

    /**
     * import sectors to apply trends
     *
     * @param sectorList initial sector values
     * @return return changed sector list after applying trends
     */
    public List<Sector> importSectors(List<Sector> sectorList) {

        List<Sector> oldSectorList = new ArrayList<>();

        for (Sector sector : sectorList) {
            Sector oldSector = new Sector(sector.sectorName);
            for (CompanyStock companyStock : sector.stockList) {
                CompanyStock oldCompanyStock = new CompanyStock(companyStock.getCompanyName(), companyStock.getStockName());
                double[] oldCompanyStockArray = new double[20];
                for (int i = 0; i < 20; i++) {
                    oldCompanyStockArray[i] = companyStock.getStockPriceArray()[i];
                }
                oldCompanyStock.setStockArray(oldCompanyStockArray);
                oldSector.addToSector(oldCompanyStock);
            }
            oldSectorList.add(oldSector);
        }

        int randomGeneralMarketTrendTurns = new Random().nextInt(5);

        for (int i = 0; i < randomGeneralMarketTrendTurns; i++) {
            //market probability trend
            sectorList = generalMarketComponent(sectorList);
        }
        int randomSectorMarketTrendTurns = new Random().nextInt(5);

        for (int i = 0; i < randomSectorMarketTrendTurns; i++) {
            //sector event trend
            int randomSectorNumberForSectorEvent = new Random().nextInt(sectorList.size()); //array out of bound
            Sector sectorForSectorEvent = sectorList.get(randomSectorNumberForSectorEvent);//array out of bound

            sectorList.set(randomSectorNumberForSectorEvent, sectorMarketComponent(sectorForSectorEvent));
        }

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

        //Whether an event is occurring or not
        Boolean randomBooleanValue = (Math.random() < 0.5);

        if (randomBooleanValue) {
            EventComponent eventComponent = new EventComponent();
            sectorList = eventComponent.eventComponentGenerator(sectorList);
        }

        // Comparing to obtain the change(negative or positive change)
        for (int i = 0; i < sectorList.size(); i++) {
            Sector oldSector = oldSectorList.get(i);
            Sector newSector = sectorList.get(i);

            for (int j = 0; j < newSector.stockList.size(); j++) {
                CompanyStock oldCompanyStock = oldSector.stockList.get(j);
                CompanyStock newCompanyStock = newSector.stockList.get(j);

                for (int k = 0; k < 20; k++) {
                    if (oldCompanyStock.getStockPriceArray()[k] > newCompanyStock.getStockPriceArray()[k]) {
                        newCompanyStock.setNewStockValue(oldCompanyStock.getStockPriceArray()[k], k);
                    }
                }
            }
        }

        return sectorList;
    }

    /**
     * apply randomMarketComponent to companyStock
     *
     * @param companyStock initial company stock values
     * @return return changed companyStock after applying randomMarketComponent
     */
    private CompanyStock randomMarketComponent(CompanyStock companyStock) {

        double[] stockPriceArray = companyStock.getStockPriceArray();

        for (int i = 0; i < 20; i++) {
            double currentStockValue = stockPriceArray[i];
            double percentageValueForRandomMarket = Math.round((stockPriceArray[i] * (new Random().nextInt(5) + (-2)) / 100) * 100.0) / 100.0;

            stockPriceArray[i] = stockPriceArray[i] + percentageValueForRandomMarket;

            double changedPercentage = (currentStockValue - stockPriceArray[i]) / 100;
            if (i > 0 && ((changedPercentage <= -0.01) || (changedPercentage >= 0.01))) {
                stockPriceArray[i] = currentStockValue;
            }
        }
        companyStock.setStockArray(stockPriceArray);
        //System.out.println(companyStock);
        return companyStock;
    }

    /**
     * apply sector market component to sectors
     *
     * @param sector sector with stocks values
     * @return return stock values with sectorMarketComponent applied
     */
    private Sector sectorMarketComponent(Sector sector) {

        return stockPriceCalculateForSectorAndGeneral(sector);
    }

    /**
     * apply general market component to sector list
     *
     * @param sectorList sector list with stocks values
     * @return return stock values with generalmarketComponent applied
     */
    private List<Sector> generalMarketComponent(List<Sector> sectorList) {

        for (int i = 0; i < sectorList.size(); i++) {
            sectorList.set(i, stockPriceCalculateForSectorAndGeneral(sectorList.get(i)));
        }

        return sectorList;
    }

    /**
     * apply sector and general market trends to sectors(common method)
     *
     * @param sector sector with stock values
     * @return return changed sector values after applying sectorMarketComponent & generalMarketComponent
     */
    private Sector stockPriceCalculateForSectorAndGeneral(Sector sector) {
        for (CompanyStock companyStock : sector.stockList) {

            double[] stockPriceArray = companyStock.getStockPriceArray();

            for (int i = 0; i < 20; i++) {
                double currentStockValue = stockPriceArray[i];
                double percentageValue = Math.round((stockPriceArray[i] * (new Random().nextInt(7) + (-3)) / 100) * 100.0) / 100.0;
                stockPriceArray[i] = stockPriceArray[i] + percentageValue;

                double changedPercentage = (currentStockValue - stockPriceArray[i]) / 100;
                if (i > 0 && ((changedPercentage >= -0.01) && (changedPercentage <= 0.01))) {
                    stockPriceArray[i] = currentStockValue;
                }
            }
            companyStock.setStockArray(stockPriceArray);
        }
        return sector;
    }
}
