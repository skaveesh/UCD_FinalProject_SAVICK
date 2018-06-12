package com.smsimulator.server.root;

import com.smsimulator.core.CompanyStock;
import com.smsimulator.core.DBUtils;
import com.smsimulator.core.Market;
import com.smsimulator.core.Sector;
import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.service.CorsService;

import java.util.Arrays;
import java.util.HashSet;

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
        initializeStocks();
    }

    public static int getTURN() {
        return TURN;
    }

    public static int nextTURN() {
        return ++TURN;
    }

    private static void initializeStocks(){

        //==================Market==================//

        Market stockMarket = new Market();

        //==================Sectors==================//

        Sector financialSector = new Sector();
        Sector technologicalSector = new Sector();
        Sector manufacturingSector = new Sector();

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
        technologicalSector.increaseStockValuesInSector(4.5,7);
        johnKeells.increaseStockValue(5.5,3);
    }
}
