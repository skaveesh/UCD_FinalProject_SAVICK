package com.smsimulator.core;

import com.smsimulator.core.CompanyStock;
import com.smsimulator.core.Sector;

import java.util.List;
import java.util.Random;

public class EventComponent {

    private double eventsArray[] = new double[20];
    Random random = new Random();

    public List<Sector> eventComponentGenerator(List<Sector> sectorList){
        int randomEvent = new Random().nextInt(2);
        if(randomEvent == 1){   // sectorEvent
            sectorList = sectorEvent(sectorList);
        } else {                //stockEvent
            sectorList = stockEvent(sectorList);
        }
        return sectorList;
    }

    private List<Sector> sectorEvent(List<Sector> sectorList) {
        int randomSectorNumberForSectorEvent = new Random().nextInt(sectorList.size());
        Sector sectorForSectorEvent = sectorList.get(randomSectorNumberForSectorEvent);

        sectorList.set(randomSectorNumberForSectorEvent, sectorEventChangePrice(sectorForSectorEvent));
        return sectorList;
    }

    private Sector sectorEventChangePrice(Sector sector){
        String sectorEventsArray[] = {"BOOM","BUST"};
        for (CompanyStock companyStock : sector.stockList) {
            double[] stockPriceArray = companyStock.getStockPriceArray();

            int sectorEventsTurns = random.nextInt(4) + (2);
            for (int i = 0; i < sectorEventsTurns; i++) {
                String selectedSectorEvent = sectorEventsArray[random.nextInt(sectorEventsArray.length)];
                if (selectedSectorEvent.equals("BOOM")){
                    // BOOM EVENT
                    stockPriceArray[i] = stockPriceArray[i] + new Random().nextInt(5) + (1);
                } else {
                    // BUST EVENT
                    stockPriceArray[i] = stockPriceArray[i] + new Random().nextInt(5) + (-5);
                }
                if(stockPriceArray[i]<0){
                    stockPriceArray[i] = 0;
                }
            }
            companyStock.setStockArray(stockPriceArray);
        }
        return sector;
    }

    private List<Sector> stockEvent(List<Sector> sectorList){
        String stockEventsArray[] = {"PROFIT_WARNING","TAKE_OVER","SCANDAL"};
        for(Sector sector : sectorList) {
            for (CompanyStock companyStock : sector.stockList) {
                double[] stockPriceArray = companyStock.getStockPriceArray();
                int stockEventTurns = random.nextInt(7) + (1);
                for (int i = 0; i < stockEventTurns; i++) {
                    String selectedStockEvent = stockEventsArray[random.nextInt(stockEventsArray.length)];
                    if (selectedStockEvent.equals("PROFIT_WARNING")){
                        stockPriceArray[i] = stockPriceArray[i] + new Random().nextInt(2) + (2);
                    } else if (selectedStockEvent.equals("TAKE_OVER")){
                        stockPriceArray[i] = stockPriceArray[i] + new Random().nextInt(5) + (-5);
                    } else {
                        // SCANDAL EVENT
                        stockPriceArray[i] = stockPriceArray[i] + new Random().nextInt(3) + (-6);
                    }
                    if(stockPriceArray[i]<0){
                        stockPriceArray[i] = 0;
                    }
                }
                companyStock.setStockArray(stockPriceArray);
            }
        }
        return sectorList;
    }
}