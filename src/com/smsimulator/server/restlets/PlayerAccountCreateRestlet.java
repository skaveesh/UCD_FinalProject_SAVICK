package com.smsimulator.server.restlets;

import com.smsimulator.core.Player;
import com.smsimulator.gsoncore.CreatePlayerAccount;
import com.smsimulator.server.root.InboundRoot;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.Method;
import org.restlet.data.Status;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-15.
 */
public class PlayerAccountCreateRestlet extends Restlet {
    @Override
    public void handle(Request request, Response response) {
        if (request.getMethod().equals(Method.POST)) {
            CreatePlayerAccount createPlayerAccount = InboundRoot.gson.fromJson(request.getEntityAsText(), CreatePlayerAccount.class);

            if (new Player().createAccount(createPlayerAccount.getCreatePlayerAccountForName().getUsername(),createPlayerAccount.getCreatePlayerAccountForName().getPassword())) {
                response.setStatus(Status.SUCCESS_OK);
            } else
                response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        } else {
            response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        }
    }
}
