package com.smsimulator.server.restlets;

import com.smsimulator.core.Player;
import com.smsimulator.gsoncore.JWTAuthorization;
import com.smsimulator.gsoncore.LoginPlayer;
import com.smsimulator.server.root.InboundRoot;
import com.smsimulator.server.security.JWTSecurity;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;

/**
 * Created by skaveesh on 2018-05-23.
 */
public class LoginPlayerRestlet extends JWTSecurity {
    @Override
    public void handle(Request request, Response response) {
        if (request.getMethod().equals(Method.POST)) {

            super.handle(request,response);

            //try to log in with token if present
            if(tokenAccepted){
                String oldAuthorizationHeader = request.getHeaders().getValues("Authorization");

                JWTAuthorization jwtAuthorization = new JWTAuthorization(new JWTSecurity().createJwtWithExistingJwt(oldAuthorizationHeader));

                response.setEntity(InboundRoot.gson.toJson(jwtAuthorization), MediaType.APPLICATION_JSON);
                response.setStatus(Status.SUCCESS_OK);
            }else{
                LoginPlayer loginPlayer = InboundRoot.gson.fromJson(request.getEntityAsText(), LoginPlayer.class);

                if (new Player().loginPlayer(loginPlayer.getAuthorization().getUsername(), loginPlayer.getAuthorization().getPassword())) {
                    String auth = new JWTSecurity().createJwt(loginPlayer.getAuthorization().getUsername());
                    JWTAuthorization jwtAuthorization = new JWTAuthorization(auth);

                    response.setEntity(InboundRoot.gson.toJson(jwtAuthorization), MediaType.APPLICATION_JSON);
                    response.setStatus(Status.SUCCESS_OK);
                } else
                    response.setStatus(Status.CLIENT_ERROR_UNAUTHORIZED);
            }

        } else {
            response.setStatus(Status.CLIENT_ERROR_UNAUTHORIZED);
        }
    }
}
