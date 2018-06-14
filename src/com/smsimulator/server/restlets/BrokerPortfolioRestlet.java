package com.smsimulator.server.restlets;

import com.smsimulator.core.Broker;
import com.smsimulator.core.Player;
import com.smsimulator.core.Portfolio;
import com.smsimulator.gsoncore.BrokerPortfolio;
import com.smsimulator.server.root.InboundRoot;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-13.
 */
public class BrokerPortfolioRestlet extends Restlet {
    @Override
    public void handle(Request request, Response response) {
        if (request.getMethod().equals(Method.POST)) {

            int playerUid = new Player().getUidFromName((String) request.getAttributes().get("name"));

            if (playerUid != -1) {
                Portfolio portfolio = new Broker().portfolio((String) request.getAttributes().get("name"));

                //response gson object
                com.smsimulator.gsoncore.Portfolio portfolio1 = new com.smsimulator.gsoncore.Portfolio();
                portfolio1.setName(portfolio.getName());
                portfolio1.setOwnStockList(portfolio.getOwnStockList());
                portfolio1.setBroughtStockList(portfolio.getBroughtStockList());
                portfolio1.setSoldStockList(portfolio.getSoldStockList());

                BrokerPortfolio brokerPortfolio = new BrokerPortfolio();
                brokerPortfolio.setPortfolio(portfolio1);

                response.setEntity(InboundRoot.gson.toJson(brokerPortfolio), MediaType.APPLICATION_JSON);
                response.setStatus(Status.SUCCESS_OK);
            } else
                response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        } else {
            response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        }
    }
}
