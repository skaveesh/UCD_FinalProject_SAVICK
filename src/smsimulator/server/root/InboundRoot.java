package smsimulator.server.root;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;
import smsimulator.server.restlets.WelcomeRestlet;

/**
 * Created by skaveesh on 2018-05-21.
 */

public class InboundRoot extends Application {

    public Restlet createInboundRoot(){
        Router router = new Router(getContext());
        router.attach("/", new WelcomeRestlet());

        return router;
    }

}
