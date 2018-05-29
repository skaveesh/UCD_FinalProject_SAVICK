package com.smsimulator.server.root;

import com.smsimulator.core.CompanyShares;
import com.smsimulator.core.DBUtils;
import org.restlet.Component;
import org.restlet.data.Protocol;

/**
 * Created by skaveesh on 2018-05-21.
 */

public class Main {

    public static void main(String[] args) throws Exception{
        // Test below methods
        DBUtils.getRemoteConnection();
        DBUtils.testConnection();
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 5000);
        component.getDefaultHost().attach("", new InboundRoot());
        component.start();

        CompanyShares shr = new CompanyShares(); //call to random shares generate class
        shr.randomStocks();

    }
}
