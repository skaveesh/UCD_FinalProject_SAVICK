package com.smsimulator.server.restlets;

import com.smsimulator.core.Player;
import com.smsimulator.gsoncore.LoginPlayer;
import com.smsimulator.server.root.InboundRoot;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.Method;
import org.restlet.data.Status;

/**
 * Created by skaveesh on 2018-05-23.
 */
public class LoginPlayerRestlet extends Restlet {
    @Override
    public void handle(Request request, Response response) {
        if (request.getMethod().equals(Method.POST)) {
            LoginPlayer loginPlayer = InboundRoot.gson.fromJson(request.getEntityAsText(), LoginPlayer.class);

            if (new Player().loginPlayer(loginPlayer.getAuthorization().getUsername(), loginPlayer.getAuthorization().getPassword())) {
                response.setStatus(Status.SUCCESS_OK);
            } else
                response.setStatus(Status.CLIENT_ERROR_UNAUTHORIZED);
        } else {
            response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        }
    }
}
