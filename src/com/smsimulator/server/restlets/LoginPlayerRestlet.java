package com.smsimulator.server.restlets;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.Method;
import org.restlet.data.Status;

import com.smsimulator.gsoncore.LoginPlayer;
import com.smsimulator.server.root.InboundRoot;

/**
 * Created by skaveesh on 2018-05-23.
 */
public class LoginPlayerRestlet extends Restlet {
    @Override
    public void handle(Request request, Response response) {
        if (request.getMethod().equals(Method.POST)) {
            LoginPlayer loginPlayer = InboundRoot.gson.fromJson(request.getEntityAsText(), LoginPlayer.class);

            if (loginPlayer.getAuthorization().getUsername().equals("hello") && loginPlayer.getAuthorization().getPassword().equals("123456")) {
                response.setStatus(Status.SUCCESS_OK);
            } else
                response.setStatus(Status.CLIENT_ERROR_UNAUTHORIZED);

        } else {
            response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        }
    }
}
