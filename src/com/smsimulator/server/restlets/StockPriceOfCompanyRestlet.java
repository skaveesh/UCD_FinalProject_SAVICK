package com.smsimulator.server.restlets;

import com.smsimulator.core.Broker;
import com.smsimulator.gsoncore.StockPrice;
import com.smsimulator.gsoncore.StockPriceOfIndexOfCompany;
import com.smsimulator.server.root.InboundRoot;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-14.
 */
public class StockPriceOfCompanyRestlet extends Restlet {
    @Override
    public void handle(Request request, Response response) {
        if (request.getMethod().equals(Method.POST)) {

            String stockName = request.getAttributes().get("stockname").toString().toUpperCase();

            try {
                int stockIndex = Integer.parseInt((String) request.getAttributes().get("index"));

                if (stockIndex >= 0 && stockIndex < 20) {
                    //response gson object
                    Broker broker = new Broker();
                    double stockPriceOfIndex = broker.price(stockName, stockIndex);

                    if (stockPriceOfIndex > 0) {
                        StockPrice stockPrice = new StockPrice();
                        stockPrice.setStockName(stockName);
                        stockPrice.setPrice(stockPriceOfIndex);

                        StockPriceOfIndexOfCompany stockPriceOfIndexOfCompany = new StockPriceOfIndexOfCompany();
                        stockPriceOfIndexOfCompany.setStockPrice(stockPrice);

                        response.setEntity(InboundRoot.gson.toJson(stockPriceOfIndexOfCompany), MediaType.APPLICATION_JSON);
                        response.setStatus(Status.SUCCESS_OK);
                    } else {
                        response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
                    }
                } else {
                    response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
                }
            } catch (NumberFormatException e) {
                response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
            }
        } else {
            response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        }
    }
}
