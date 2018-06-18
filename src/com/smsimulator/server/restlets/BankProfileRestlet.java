package com.smsimulator.server.restlets;

import com.smsimulator.core.Bank;
import com.smsimulator.core.Player;
import com.smsimulator.core.Profile;
import com.smsimulator.gsoncore.BankProfile;
import com.smsimulator.server.root.InboundRoot;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-18.
 */
public class BankProfileRestlet extends Restlet {
    @Override
    public void handle(Request request, Response response) {
        if (request.getMethod().equals(Method.POST)) {

            int playerUid = new Player().getUidFromName((String) request.getAttributes().get("name"));

            if (playerUid != -1) {
                Profile profile = new Bank().profile((String) request.getAttributes().get("name"));

                if(profile != null) {
                    //response gson object
                    com.smsimulator.gsoncore.Profile profile1 = new com.smsimulator.gsoncore.Profile();
                    profile1.setName(profile.getName());
                    profile1.setBankBalance(profile.getBankBalance());
                    profile1.setDepositTransaction(profile.getDepositTransactionList());
                    profile1.setWithdrawTransaction(profile.getWithdrawTransactionList());

                    BankProfile bankProfile = new BankProfile();
                    bankProfile.setProfile(profile1);

                    response.setEntity(InboundRoot.gson.toJson(bankProfile), MediaType.APPLICATION_JSON);
                    response.setStatus(Status.SUCCESS_OK);
                }else {
                    response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
                }
            } else
                response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        } else {
            response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        }
    }
}
