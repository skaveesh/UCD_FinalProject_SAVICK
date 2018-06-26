package com.smsimulator.server.restlets;

import com.smsimulator.core.Bank;
import com.smsimulator.gsoncore.BalanceAmount;
import com.smsimulator.gsoncore.BankBalanceAmount;
import com.smsimulator.server.root.InboundRoot;
import com.smsimulator.server.security.JWTSecurity;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;

/**
 * Created by skaveesh on 2018-05-30.
 */
public class BankBalanceRestlet extends JWTSecurity {
    @Override
    public void handle(Request request, Response response) {
        super.handle(request,response);

        if (request.getMethod().equals(Method.POST) && tokenAccepted) {

            double currentBalanceAmount = new Bank().balance( (String) request.getAttributes().get("name"));

            if (currentBalanceAmount != -1) {
                //response gson object
                BalanceAmount balanceAmount = new BalanceAmount();
                balanceAmount.setAmount(currentBalanceAmount);
                BankBalanceAmount bankBalanceAmount = new BankBalanceAmount();
                bankBalanceAmount.setBalanceAmount(balanceAmount);

                response.setEntity(InboundRoot.gson.toJson(bankBalanceAmount), MediaType.APPLICATION_JSON);
                response.setStatus(Status.SUCCESS_OK);
            } else
                response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        } else {
            response.setStatus(Status.CLIENT_ERROR_UNAUTHORIZED);
        }
    }
}