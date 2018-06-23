package com.smsimulator.core;

import com.smsimulator.server.root.Main;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dilhara on 6/23/2018.
 */
public class MarketComponentsTest {

    private MarketComponents testMarketComponent = new MarketComponents();
    private List<Sector> testSectorList = Main.initializeStocks();
    private CompanyStock testStock = new CompanyStock("company","sector");

    @Test
    public void importSectors() throws Exception {
        //assert that the importSectors method does not return the same input sector list.
        assertNotEquals(testSectorList.listIterator(),testMarketComponent.importSectors(testSectorList).listIterator());
        //System.out.println(testMarketComponent.importSectors(testSectorList).listIterator());
        //System.out.println(testSectorList.listIterator());
    }

}