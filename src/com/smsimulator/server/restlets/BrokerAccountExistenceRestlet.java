package com.smsimulator.server.restlets;

import com.smsimulator.core.Broker;
import com.smsimulator.gsoncore.BooleanValue;
import com.smsimulator.server.root.InboundRoot;
import com.smsimulator.server.security.JWTSecurity;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-16.
 */
public class BrokerAccountExistenceRestlet extends JWTSecurity {
    @Override
    public void handle(Request request, Response response) {
        super.handle(request, response);

        String playerUsername = (String) request.getAttributes().get("name");

        if (request.getMethod().equals(Method.POST) && tokenAccepted) {

            BooleanValue booleanValue = new BooleanValue();
            booleanValue.setValue(new Broker().checkExistenceOfAccount(playerUsername));

            response.setEntity(InboundRoot.gson.toJson(booleanValue), MediaType.APPLICATION_JSON);
            response.setStatus(Status.SUCCESS_OK);
        } else {
            response.setStatus(Status.CLIENT_ERROR_UNAUTHORIZED);
        }
    }
}
