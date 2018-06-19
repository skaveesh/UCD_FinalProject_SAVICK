package com.smsimulator.core;

import com.smsimulator.core.CompanyStock;
import com.smsimulator.core.Sector;

import java.util.List;
import java.util.Random;

public class EventComponent {

    Random random = new Random();

    /**
     * Check whether if sector event occur or an stock event
     * @param sectorList initial sector values
     * @return return changed sector list after applying events
     */
    public List<Sector> eventComponentGenerator(List<Sector> sectorList){
         // sectorEvent
            sectorList = sectorEvent(sectorList);
            //stockEvent
            sectorList = stockEvent(sectorList);

        return sectorList;
    }

    /**
     * Generate a random number to select sectors and apply events
     * @param sectorList initial sector values
     * @return return changed sector list after applying events
     */
    private List<Sector> sectorEvent(List<Sector> sectorList) {
        int randomSectorNumberForSectorEvent = new Random().nextInt(sectorList.size());
        Sector sectorForSectorEvent = sectorList.get(randomSectorNumberForSectorEvent);

        sectorList.set(randomSectorNumberForSectorEvent, sectorEventChangePrice(sectorForSectorEvent));
        return sectorList;
    }

    /**
     * Change sector price depending on whether its a Boom or a Bust
     * @param sector initial sector value
     * @return return changed sector after applying event
     */
    private Sector sectorEventChangePrice(Sector sector){
        String sectorEventsArray[] = {"BOOM","BUST"};
        for (CompanyStock companyStock : sector.stockList) {
            double[] stockPriceArray = companyStock.getStockPriceArray();

            int sectorEventsTurns = random.nextInt(4) + (2);
            for (int i = 0; i < sectorEventsTurns; i++) {
                String selectedSectorEvent = sectorEventsArray[random.nextInt(sectorEventsArray.length)];
                if (selectedSectorEvent.equals("BOOM")){
                    // BOOM EVENT
                    System.out.println("sectorEventChangePrice " +stockPriceArray[i]);
                    double percentageValueForSectorEventBoom = Math.round((stockPriceArray[i]*(new Random().nextInt(5) + (1))/100)*100.0)/100.0;
                    stockPriceArray[i] = stockPriceArray[i] + percentageValueForSectorEventBoom;
                } else {
                    // BUST EVENT
                    double percentageValueForSectorEventBust = Math.round((stockPriceArray[i]*(new Random().nextInt(5) + (-5))/100)*100.0)/100.0;

                    stockPriceArray[i] = stockPriceArray[i] + percentageValueForSectorEventBust;
                }
                if(stockPriceArray[i]<0){
                    stockPriceArray[i] = 0;
                }
            }
            companyStock.setStockArray(stockPriceArray);
        }
        return sector;
    }

    /**
     * Select a stockEvent randomly and change the values accordingly
     * @param sectorList initial sector list values
     * @return return changed sector list after applying event
     */
    private List<Sector> stockEvent(List<Sector> sectorList){
        String stockEventsArray[] = {"PROFIT_WARNING","TAKE_OVER","SCANDAL"};
        for(Sector sector : sectorList) {
            for (CompanyStock companyStock : sector.stockList) {
                double[] stockPriceArray = companyStock.getStockPriceArray();
                int stockEventTurns = random.nextInt(7) + (1);
                for (int i = 0; i < stockEventTurns; i++) {
                    String selectedStockEvent = stockEventsArray[random.nextInt(stockEventsArray.length)];
                    if (selectedStockEvent.equals("PROFIT_WARNING")){
                        double percentageValueForStockEventProfitWarning = Math.round((stockPriceArray[i]*(new Random().nextInt(2) + (2))/100)*100.0)/100.0;

                        stockPriceArray[i] = stockPriceArray[i] + percentageValueForStockEventProfitWarning;

                    } else if (selectedStockEvent.equals("TAKE_OVER")){
                        double percentageValueForStockEventTakeOver = Math.round((stockPriceArray[i]*(new Random().nextInt(5) + (-5))/100)*100.0)/100.0;

                        stockPriceArray[i] = stockPriceArray[i] + percentageValueForStockEventTakeOver;
                    } else {
                        // SCANDAL EVENT
                        double percentageValueForStockEventScandal = Math.round((stockPriceArray[i]*(new Random().nextInt(3) + (-6))/100)*100.0)/100.0;

                        stockPriceArray[i] = stockPriceArray[i] + percentageValueForStockEventScandal;
                    }

                }
                companyStock.setStockArray(stockPriceArray);
            }
        }
        return sectorList;
    }
}