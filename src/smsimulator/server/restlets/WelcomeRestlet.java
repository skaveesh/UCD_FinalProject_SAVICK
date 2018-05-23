package smsimulator.server.restlets;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;

/**
 * Created by skaveesh on 2018-05-21.
 */

public class WelcomeRestlet extends Restlet{
    @Override
    public void handle(Request request, Response response) {
        if (request.getMethod().equals(Method.GET)) {
            response.setEntity("Welcome to the Stock Market Simulator", MediaType.TEXT_PLAIN);
            response.setStatus(Status.SUCCESS_OK);
        } else {
            response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        }
    }
}
