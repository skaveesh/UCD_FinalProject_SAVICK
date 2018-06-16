package com.smsimulator.server.restlets;

import com.smsimulator.core.Bank;
import com.smsimulator.gsoncore.BooleanValue;
import com.smsimulator.server.root.InboundRoot;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-16.
 */
public class BankAccountExistenceRestlet extends Restlet {
    @Override
    public void handle(Request request, Response response) {

        String playerUsername = (String) request.getAttributes().get("name");

        if (request.getMethod().equals(Method.POST)) {

            BooleanValue booleanValue = new BooleanValue();
            booleanValue.setValue(new Bank().checkExistenceOfAccount(playerUsername));

            response.setEntity(InboundRoot.gson.toJson(booleanValue), MediaType.APPLICATION_JSON);
            response.setStatus(Status.SUCCESS_OK);
        } else {
            response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        }
    }
}
