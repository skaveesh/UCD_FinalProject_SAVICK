package com.smsimulator.server.root;

import com.smsimulator.core.DBUtils;
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
    }

    public static int getTURN() {
        return TURN;
    }

    public static int nextTURN() {
        return ++Main.TURN;
    }
}
