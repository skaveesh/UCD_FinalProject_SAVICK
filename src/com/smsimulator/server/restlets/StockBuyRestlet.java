package com.smsimulator.server.restlets;

import com.smsimulator.core.Broker;
import com.smsimulator.gsoncore.BuyStock;
import com.smsimulator.server.root.InboundRoot;
import com.smsimulator.server.root.Main;
import com.smsimulator.server.security.JWTSecurity;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Method;
import org.restlet.data.Status;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-17.
 */
public class StockBuyRestlet extends JWTSecurity {
    @Override
    public void handle(Request request, Response response) {
        super.handle(request, response);

        if (request.getMethod().equals(Method.POST) && tokenAccepted) {
            BuyStock buyStock = InboundRoot.gson.fromJson(request.getEntityAsText(), BuyStock.class);

            if (new Broker().buy(Main.nextTURN(), buyStock.getBuy().getStockAndUserDetails().getName(),buyStock.getBuy().getStockAndUserDetails().getStock(),buyStock.getBuy().getStockAndUserDetails().getQuantity(),buyStock.getBuy().getStockAndUserDetails().getPrice())) {
                response.setStatus(Status.SUCCESS_OK);
            } else
                response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        } else {
            response.setStatus(Status.CLIENT_ERROR_UNAUTHORIZED);
        }
    }
}
