package com.smsimulator.core;

import com.smsimulator.server.root.Main;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EventComponentTest {
    private EventComponent testEventComponent = new EventComponent();
    private List<Sector> testSectorList = Main.initializeStocks();

    @Test
    public void eventComponentGenerator() throws Exception {
        //assert that the eventComponentGenerator method does not return the same input sector list.
        assertNotEquals(testSectorList.listIterator(), testEventComponent.eventComponentGenerator(testSectorList).listIterator());
    }

}
