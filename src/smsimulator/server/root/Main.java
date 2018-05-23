package smsimulator.server.root;

import org.restlet.Component;
import org.restlet.data.Protocol;

/**
 * Created by skaveesh on 2018-05-21.
 */

public class Main {

    public static void main(String[] args) throws Exception{
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 5000);
        component.getDefaultHost().attach("", new InboundRoot());
        component.start();
    }
}
