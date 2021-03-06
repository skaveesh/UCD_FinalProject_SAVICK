package com.smsimulator.server.restlets;

import com.smsimulator.core.Broker;
import com.smsimulator.gsoncore.CreateBrokerAccount;
import com.smsimulator.server.root.InboundRoot;
import com.smsimulator.server.root.Main;
import com.smsimulator.server.security.JWTSecurity;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Method;
import org.restlet.data.Status;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-13.
 */
public class BrokerAccountCreateRestlet extends JWTSecurity {
    @Override
    public void handle(Request request, Response response) {
        super.handle(request, response);

        if (request.getMethod().equals(Method.POST) && tokenAccepted) {
            CreateBrokerAccount createBrokerAccount = InboundRoot.gson.fromJson(request.getEntityAsText(), CreateBrokerAccount.class);

            if (new Broker().createAccount(Main.nextTURN(), createBrokerAccount.getCreateBrokerAccountFromName().getName())) {
                response.setStatus(Status.SUCCESS_OK);
            } else
                response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        } else {
            response.setStatus(Status.CLIENT_ERROR_UNAUTHORIZED);
        }
    }
}
