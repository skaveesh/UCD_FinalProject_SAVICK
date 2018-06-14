package com.smsimulator.server.root;

import com.smsimulator.core.*;
import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.service.CorsService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by skaveesh on 2018-05-21.
 */

public class Main extends InboundRoot {

    private static int TURN = 0;

    public static void main(String[] args) throws Exception {

        //Start DB service
        new DBUtils();

        //Cross-origin resource sharing (CORS) support
        CorsService corsService = new CorsService();
        corsService.setAllowingAllRequestedHeaders(true);
        corsService.setAllowedOrigins(new HashSet(Arrays.asList("*")));
        corsService.setAllowedCredentials(true);
        corsService.setSkippingResourceForCorsOptions(true);

        Main inboundRoot = new Main();
        inboundRoot.getServices().add(corsService);

        Component component = new Component();
        component.getDefaultHost().attachDefault(inboundRoot);
        component.getServers().add(Protocol.HTTP, 5000);
        component.getDefaultHost().attach("", inboundRoot);
        component.start();

        //initialize stocks
        Broker.generateNewStock();

        for(Sector sector:new Broker().getSectorList()){
            if(sector.sectorName.equalsIgnoreCase("financial sector")){
                for (CompanyStock companyStock:sector.stockList){
                    System.out.println(companyStock.getStockName() + " " + companyStock.getStockPrice(0));
                }
                break;
            }
        }

       // System.out.println("HNB stock "+ new Broker().price("HNB", 10));
    }

    public static int getTURN() {
        return TURN;
    }

    public static int nextTURN() {
        return ++TURN;
    }

    public static List<Sector> initializeStocks() {

        //==================Market==================//

        Market stockMarket = new Market();

        //==================Sectors==================//

        Sector financialSector = new Sector("Financial Sector");
        Sector technologicalSector = new Sector("Technological Sector");
        Sector manufacturingSector = new Sector("Manufacturing Sector");

        //==================Stocks==================//

        //Stocks of Financial Sector
        CompanyStock hattonNationalBank = new CompanyStock("Hatton National Bank", "HNB");
        CompanyStock lolc = new CompanyStock("Sri Lanka Leasing Company", "LOLC");

        //Stocks of Technological Sector
        CompanyStock johnKeells = new CompanyStock("John Keels", "JKH");
        CompanyStock softlogic = new CompanyStock("Softlogic", "SHL");

        //Stocks of Manufacturing Sector
        CompanyStock dutchLanka = new CompanyStock("Dutch Lanka", "DLT");
        CompanyStock sierra = new CompanyStock("Sierra", "SIRA");

        //add stock to corresponding sector
        financialSector.addToSector(hattonNationalBank);
        financialSector.addToSector(lolc);

        technologicalSector.addToSector(johnKeells);
        technologicalSector.addToSector(softlogic);

        manufacturingSector.addToSector(dutchLanka);
        manufacturingSector.addToSector(sierra);

        //add sectors to the market
        stockMarket.addToMarket(financialSector);
        stockMarket.addToMarket(technologicalSector);
        stockMarket.addToMarket(manufacturingSector);

        //change values (temporary)
        technologicalSector.setNewStockValuesInSector(4.5, 7);
        johnKeells.setNewStockValue(5.5, 3);


        //get certain value of stock within stock array by accessing through sector list in the market(Implement this code inside marketcomponent or eventcomponent)
        //System.out.println(stockMarket.sectorList.get(stockMarket.sectorList.indexOf(technologicalSector)).stockList.get(technologicalSector.stockList.indexOf(johnKeells)).getStockPrice(15));

        //iterating through all the stocks in the market sectors (Implement this code inside marketcomponent or eventcomponent)
        for (Sector sector : stockMarket.sectorList) {
            for (CompanyStock companyStock : sector.stockList) {
                for (int i = 0; i < 20; i++) {
                    //this can be use to change values

                    //printing all the stock values in the market
                    //System.out.println(companyStock.getStockPrice(i));
                }
            }
        }

        //use stockMarket.sectorList to get access to any sector or stock inside marketcomponent or eventcomponent


        //get stock prices of certain companies BEFORE increasing value by 5
//        System.out.println(hattonNationalBank.getStockPrice(4));
        System.out.println(hattonNationalBank.getStockPrice(16));
        System.out.println(lolc.getStockPrice(16));
//        System.out.println(softlogic.getStockPrice(3));

        //increase financial sector values by 5
        for (CompanyStock stock : stockMarket.sectorList.get(stockMarket.sectorList.indexOf(financialSector)).stockList) {
            for (int i = 0; i < 20; i++) {
                stock.setNewStockValue(stock.getStockPrice(i) + 5, i);
            }
        }

        //get stock prices of certain companies AFTER increasing value by 5
//        System.out.println(hattonNationalBank.getStockPrice(4));
//        System.out.println(lolc.getStockPrice(16));
//        System.out.println(softlogic.getStockPrice(3));

        return stockMarket.sectorList;
    }
}
