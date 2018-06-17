package com.smsimulator.server.restlets;

import com.smsimulator.core.Broker;
import com.smsimulator.gsoncore.SellStock;
import com.smsimulator.server.root.InboundRoot;
import com.smsimulator.server.root.Main;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.Method;
import org.restlet.data.Status;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-17.
 */
public class StockSellRestlet extends Restlet {
    @Override
    public void handle(Request request, Response response) {
        if (request.getMethod().equals(Method.POST)) {
            SellStock sellStock = InboundRoot.gson.fromJson(request.getEntityAsText(), SellStock.class);

            if (new Broker().sell(Main.nextTURN(), sellStock.getSell().getStockAndUserDetails().getName(),sellStock.getSell().getStockAndUserDetails().getStock(),sellStock.getSell().getStockAndUserDetails().getQuantity(),sellStock.getSell().getStockAndUserDetails().getPrice())) {
                response.setStatus(Status.SUCCESS_OK);
            } else
                response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        } else {
            response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        }
    }
}
