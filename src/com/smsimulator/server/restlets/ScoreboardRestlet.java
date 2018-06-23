package com.smsimulator.server.restlets;

import com.smsimulator.core.Player;
import com.smsimulator.core.Score;
import com.smsimulator.gsoncore.PlayerScoreboard;
import com.smsimulator.server.root.InboundRoot;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-21.
 */
public class ScoreboardRestlet extends Restlet {
    @Override
    public void handle(Request request, Response response) {
        if (request.getMethod().equals(Method.POST)) {

            try {
                int startTurn =  Integer.parseInt((String) request.getAttributes().get("startturn"));

                List<Score> scoreList = new Player().getPlayerScoreboard(startTurn);

                //creating gson response object
                List<com.smsimulator.gsoncore.Score> scoreList1 = new ArrayList<>();

                for (Score score : scoreList) {
                    com.smsimulator.gsoncore.Score score1 = new com.smsimulator.gsoncore.Score();
                    score1.setName(score.getName());
                    score1.setStartBalance(score.getStartBalance());
                    score1.setEndBalance(score.getEndBalance());
                    score1.setProfit(score.getProfit());
                    scoreList1.add(score1);
                }

                PlayerScoreboard playerScoreboard = new PlayerScoreboard();
                playerScoreboard.setScore(scoreList1);

                response.setEntity(InboundRoot.gson.toJson(playerScoreboard), MediaType.APPLICATION_JSON);
                response.setStatus(Status.SUCCESS_OK);

            }catch (NumberFormatException e){
                response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
            }
        } else {
            response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
        }
    }
}
