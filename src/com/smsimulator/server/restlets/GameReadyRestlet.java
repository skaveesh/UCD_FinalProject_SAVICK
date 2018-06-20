package com.smsimulator.server.restlets;

import com.smsimulator.core.Game;
import com.smsimulator.core.Player;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.Method;
import org.restlet.data.Status;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-20.
 */
public class GameReadyRestlet extends Restlet {
    @Override
    public void handle(Request request, Response response) {
        if (request.getMethod().equals(Method.POST)) {

            String playerName = (String) request.getAttributes().get("name");
            int playerUid = new Player().getUidFromName(playerName);

            if(playerUid != -1) {

                if(!Game.getIsGameStarted()) {

                    if (!Game.getIsGameReadyToStart()) {

                        boolean isPlayerAlreadyInThePlayersList = false;
                        //check if player has already name in the game player list
                        for(String playerNameInTheList : Game.getPlayerList()){
                            if(playerNameInTheList.equals(playerName)) {
                                isPlayerAlreadyInThePlayersList = true;
                                break;
                            }
                        }

                        if(isPlayerAlreadyInThePlayersList){
                            response.setStatus(Status.SUCCESS_OK);
                        }else
                            Game.addToPlayerList(playerName);

                    } else {
                        Game.initializeGame();
                        Game.addToPlayerList(playerName);
                        response.setStatus(Status.SUCCESS_OK);
                    }

                }else
                    response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);

            }else
                response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);

        } else
            response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);

    }
}
