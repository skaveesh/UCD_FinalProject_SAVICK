package com.smsimulator.server.restlets;

import com.smsimulator.core.Game;
import com.smsimulator.gsoncore.AnalyserRecommendation;
import com.smsimulator.server.root.InboundRoot;
import com.smsimulator.server.security.JWTSecurity;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-21.
 */
public class AnalyserRecommendationRestlet extends JWTSecurity {
    @Override
    public void handle(Request request, Response response) {
        super.handle(request, response);

        if (request.getMethod().equals(Method.POST) && Game.getIsGameStarted() && tokenAccepted) {

            AnalyserRecommendation analyserRecommendation = new AnalyserRecommendation();

            for (int i = 0; i < 10; i++) {
                analyserRecommendation.addToRecommendations(Game.getAnalyserRecommendations()[i]);
            }

            response.setEntity(InboundRoot.gson.toJson(analyserRecommendation), MediaType.APPLICATION_JSON);
            response.setStatus(Status.SUCCESS_OK);

        } else {
            response.setStatus(Status.CLIENT_ERROR_UNAUTHORIZED);
        }
    }
}
