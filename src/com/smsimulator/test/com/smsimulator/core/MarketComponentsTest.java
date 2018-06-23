package com.smsimulator.core;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dilhara on 6/23/2018.
 */
public class MarketComponentsTest {


    private MarketComponents testMarketComponent = new MarketComponents();
    private double expectedArray[] = new double[6];
    private double actualArray[] = new double[6];

    @Test
    public void importSectors() throws Exception {

        //create a new test Market and a test sector and a test company stock
        Market testMarket = new Market();
        List<Sector> testSectorList = testMarket.sectorList;
        Sector financialSector = new Sector("Financial Sector");
        CompanyStock hattonNationalBank = new CompanyStock("Hatton National Bank", "HNB");
        testMarket.addToMarket(financialSector);
        financialSector.addToSector(hattonNationalBank);



        for(Sector sector: testMarket.sectorList){
            for(CompanyStock companyStock:sector.stockList){
                for (int i = 0; i < 6; i++) {
                    expectedArray[i]=companyStock.getStockPrice(i);
                    //System.out.println(companyStock.getStockName() + " " + companyStock.getStockPrice(i));

                }
            }
        }

        //System.out.println("&&&&&&&&&&&&");


        for(Sector sector: testMarketComponent.importSectors(testSectorList)){
            for(CompanyStock companyStock:sector.stockList) {
                for (int i = 0; i < 6; i++) {
                    actualArray[i] = companyStock.getStockPrice(i);
                    //System.out.println(companyStock.getStockName() + " " + companyStock.getStockPrice(i));
                }
            }
        }

        //assert that the importSectors method does not return the same inputted sector list.
        assertNotEquals(expectedArray,actualArray);



    }


}