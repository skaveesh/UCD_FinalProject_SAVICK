package com.smsimulator.server.restlets;

import com.smsimulator.core.Bank;
import com.smsimulator.gsoncore.CreateBankAccount;
import com.smsimulator.server.root.InboundRoot;
import com.smsimulator.server.root.Main;
import com.smsimulator.server.security.JWTSecurity;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Method;
import org.restlet.data.Status;

/**
 * Created by skaveesh on 2018-05-30.
 */
public class BankAccountCreateRestlet extends JWTSecurity {
    @Override
    public void handle(Request request, Response response) {
        super.handle(request, response);

        if (request.getMethod().equals(Method.POST) && tokenAccepted) {
            CreateBankAccount createBankAccount = InboundRoot.gson.fromJson(request.getEntityAsText(), CreateBankAccount.class);

            if (new Bank().createAccount(Main.nextTURN(), createBankAccount.getCreateBankAccountFromName().getName())) {
                response.setStatus(Status.SUCCESS_OK);
            } else
                response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        } else {
            response.setStatus(Status.CLIENT_ERROR_UNAUTHORIZED);
        }
    }
}
