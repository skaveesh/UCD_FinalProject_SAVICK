package com.smsimulator.server.restlets;

import com.smsimulator.core.Broker;
import com.smsimulator.gsoncore.StockPriceList;
import com.smsimulator.gsoncore.StockPriceListOfCompany;
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
public class StockPriceListOfCompanyRestlet extends Restlet {
    @Override
    public void handle(Request request, Response response) {
        if (request.getMethod().equals(Method.POST)) {

            String stockName = request.getAttributes().get("stockname").toString().toUpperCase();

            //response gson object
            Broker broker = new Broker();
            double[] stockArray = broker.price(stockName);

            if (stockArray[0] > 0) {
                StockPriceList stockPriceList = new StockPriceList();
                stockPriceList.setStockName(stockName);
                stockPriceList.setPrices(stockArray);

                StockPriceListOfCompany stockPriceListOfCompany = new StockPriceListOfCompany();
                stockPriceListOfCompany.setStockPriceList(stockPriceList);

                response.setEntity(InboundRoot.gson.toJson(stockPriceListOfCompany), MediaType.APPLICATION_JSON);
                response.setStatus(Status.SUCCESS_OK);
            } else {
                response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
            }

        } else {
            response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        }
    }
}
