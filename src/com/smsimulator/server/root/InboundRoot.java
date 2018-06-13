package com.smsimulator.server.root;

import com.google.gson.Gson;
import com.smsimulator.server.restlets.*;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 * Created by skaveesh on 2018-05-21.
 */

public class InboundRoot extends Application {

    public static Gson gson = new Gson();

    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/", new WelcomeRestlet());

        router.attach("/player/login", new LoginPlayerRestlet());

        router.attach("/bank/createaccount", new BankAccountCreateRestlet());
        router.attach("/bank/deposit", new BankDepositRestlet());
        router.attach("/bank/withdraw", new BankWithdrawRestlet());
        router.attach("/bank/balance/{name}", new BankBalanceRestlet());

        router.attach("/broker/createaccount", new BrokerAccountCreateRestlet());
        router.attach("/broker/portfolio/{name}", new BrokerPortfolioRestlet());

        return router;
    }
}
