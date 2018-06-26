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

        //initialize game turn from the turn where the application terminated finally
       // TURN = DBUtils.getFinalGameTurn();

        //initialize stocks
        Broker.generateNewStock();
//        Analyst analyst = new Analyst();
//        AIPlayer aIPlayer = new AIPlayer();

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
        Sector pharmaceuticalSector = new Sector("Pharmaceutical Sector");

        //==================Stocks==================//

        //Stocks of Financial Sector
        CompanyStock hattonNationalBank = new CompanyStock("Hatton National Bank", "HNB");
        CompanyStock lolc = new CompanyStock("Sri Lanka Leasing Company", "LOLC");
        CompanyStock lbFinance = new CompanyStock("LB Finance PLC", "LBF");

        //Stocks of Technological Sector
        CompanyStock johnKeells = new CompanyStock("John Keells", "JKH");
        CompanyStock softlogic = new CompanyStock("Softlogic", "SHL");
        CompanyStock metropolitan = new CompanyStock("Metropolitan Group of Companies", "MGC");

        //Stocks of Manufacturing Sector
        CompanyStock dutchLanka = new CompanyStock("Dutch Lanka", "DLT");
        CompanyStock sierra = new CompanyStock("Sierra", "SIRA");
        CompanyStock unilever = new CompanyStock("Unilever Sri Lanka", "UNI");

        //Stocks of Pharmacutical Sector
        CompanyStock gsk = new CompanyStock("GSK Sri Lanka", "GSK");
        CompanyStock sunPharma = new CompanyStock("Sun Pharmaceuticals", "SUN");
        CompanyStock tab = new CompanyStock("Tabrane Pharmacueticals", "TAB");

        //add stock to corresponding sector
        financialSector.addToSector(hattonNationalBank);
        financialSector.addToSector(lolc);
        financialSector.addToSector(lbFinance);

        technologicalSector.addToSector(johnKeells);
        technologicalSector.addToSector(softlogic);
        technologicalSector.addToSector(metropolitan);

        manufacturingSector.addToSector(dutchLanka);
        manufacturingSector.addToSector(sierra);
        manufacturingSector.addToSector(unilever);

        pharmaceuticalSector.addToSector(gsk);
        pharmaceuticalSector.addToSector(sunPharma);
        pharmaceuticalSector.addToSector(tab);

        //add sectors to the market
        stockMarket.addToMarket(financialSector);
        stockMarket.addToMarket(technologicalSector);
        stockMarket.addToMarket(manufacturingSector);
        stockMarket.addToMarket(pharmaceuticalSector);

        MarketComponent marketComponent = new MarketComponent();
        List<Sector> eventsAppliedSectorList = marketComponent.importSectors(stockMarket.sectorList);

        return eventsAppliedSectorList;
    }
}
