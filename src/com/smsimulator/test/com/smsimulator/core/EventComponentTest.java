package com.smsimulator.core;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dilhara on 6/23/2018.
 */
public class EventComponentTest {

    private EventComponent testEventComponent = new EventComponent();
    private double testArray1[] = new double[20];
    private double testArray2[] = new double[20];

    @Test
    public void eventComponentGenerator() throws Exception {

        //create a new test Market and 2 test sectors and 2 test company stocks
        Market testMarket = new Market();
        List<Sector> testSectorList = testMarket.sectorList;
        Sector sector1 = new Sector("sector1");
        Sector sector2 = new Sector("sector2");
        CompanyStock stock1 = new CompanyStock("name", "stock1");
        CompanyStock stock2 = new CompanyStock("name", "stock2");
        testMarket.addToMarket(sector1);
        testMarket.addToMarket(sector2);
        sector1.addToSector(stock1);
        sector2.addToSector(stock2);

        for(Sector sector: testMarket.sectorList){
            for(CompanyStock companyStock:sector.stockList){
                for (int i = 0; i <20; i++) {
                    testArray1[i]=companyStock.getStockPrice(i);
                    System.out.println(companyStock.getStockName() + " " + companyStock.getStockPrice(i));
                }
                System.out.println("--------");
            }
        }

        //System.out.println("&&&&&&&&&&&&");

        for(Sector sector: testEventComponent.eventComponentGenerator(testSectorList)){
            for(CompanyStock companyStock:sector.stockList) {
                for (int i = 0; i <20; i++) {
                    testArray2[i] = companyStock.getStockPrice(i);
                    System.out.println(companyStock.getStockName() + " " + companyStock.getStockPrice(i));
                }
                System.out.println("________");
            }
        }

        //assert that the eventComponentGenerator method does not return the same inputted sector list.
        assertNotEquals(testArray1,testArray2);
    }
}