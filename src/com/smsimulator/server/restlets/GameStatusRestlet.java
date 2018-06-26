package com.smsimulator.server.restlets;

import com.smsimulator.core.Game;
import com.smsimulator.core.GameSimulator;
import com.smsimulator.server.root.InboundRoot;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-20.
 */
public class GameStatusRestlet extends Restlet {
    @Override
    public void handle(Request request, Response response) {
        if (request.getMethod().equals(Method.POST)) {

            GameSimulator gameSimulator = new Game().getCurrentGame();
            response.setEntity(InboundRoot.gson.toJson(gameSimulator), MediaType.APPLICATION_JSON);
            response.setStatus(Status.SUCCESS_OK);

        } else {
            response.setStatus(Status.CLIENT_ERROR_UNAUTHORIZED);
        }
    }
}
