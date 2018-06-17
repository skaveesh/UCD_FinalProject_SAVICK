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

        router.attach("/player/createaccount", new PlayerAccountCreateRestlet());
        router.attach("/player/login", new LoginPlayerRestlet());

        router.attach("/bank/account/createaccount", new BankAccountCreateRestlet());
        router.attach("/bank/account/check/{name}", new BankAccountExistenceRestlet());
        router.attach("/bank/account/deposit", new BankDepositRestlet());
        router.attach("/bank/account/withdraw", new BankWithdrawRestlet());
        router.attach("/bank/account/balance/{name}", new BankBalanceRestlet());

        router.attach("/broker/account/createaccount", new BrokerAccountCreateRestlet());
        router.attach("/broker/account/check/{name}", new BrokerAccountExistenceRestlet());
        router.attach("/broker/account/portfolio/{name}", new BrokerPortfolioRestlet());
        router.attach("/broker/stock/getall", new StockMarketRestlet());
        router.attach("/broker/stock/{stockname}", new StockPriceListOfCompanyRestlet());
        router.attach("/broker/stock/{stockname}/{index}", new StockPriceOfCompanyRestlet());

        return router;
    }
}
