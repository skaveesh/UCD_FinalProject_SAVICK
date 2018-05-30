package com.smsimulator.server.restlets;

import com.smsimulator.core.Bank;
import com.smsimulator.gsoncore.BalanceAmount;
import com.smsimulator.gsoncore.BankBalance;
import com.smsimulator.gsoncore.BankBalanceAmount;
import com.smsimulator.server.root.InboundRoot;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;

/**
 * Created by skaveesh on 2018-05-30.
 */
public class BankBalanceRestlet extends Restlet {
    @Override
    public void handle(Request request, Response response) {
        if (request.getMethod().equals(Method.POST)) {
            BankBalance bankBalance = InboundRoot.gson.fromJson(request.getEntityAsText(), BankBalance.class);
            double currentBalanceAmount = Bank.balance(bankBalance.getGetBalance().getName());

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
            response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        }
    }
}