package com.smsimulator.server.root;

import com.google.gson.Gson;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.smsimulator.server.restlets.LoginPlayerRestlet;
import com.smsimulator.server.restlets.WelcomeRestlet;

/**
 * Created by skaveesh on 2018-05-21.
 */

public class InboundRoot extends Application {

    public static Gson gson = new Gson();

    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/", new WelcomeRestlet());
        router.attach("/player/login", new LoginPlayerRestlet());

        return router;
    }
}
