package com.smsimulator.server.restlets;

import com.smsimulator.core.Bank;
import com.smsimulator.gsoncore.BankWithdraw;
import com.smsimulator.server.root.InboundRoot;
import com.smsimulator.server.root.Main;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.Method;
import org.restlet.data.Status;

/**
 * Created by skaveesh on 2018-05-30.
 */
public class BankWithdrawRestlet extends Restlet {
    @Override
    public void handle(Request request, Response response) {
        if (request.getMethod().equals(Method.POST)) {
            BankWithdraw bankWithdraw = InboundRoot.gson.fromJson(request.getEntityAsText(), BankWithdraw.class);

            if (new Bank().withdraw(Main.nextTURN(), bankWithdraw.getWithdraw().getName(), bankWithdraw.getWithdraw().getReceiver(), bankWithdraw.getWithdraw().getAmount())) {
                response.setStatus(Status.SUCCESS_OK);
            } else
                response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        } else {
            response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        }
    }

}
