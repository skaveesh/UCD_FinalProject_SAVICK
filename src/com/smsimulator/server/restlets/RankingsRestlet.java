package com.smsimulator.server.restlets;

import com.smsimulator.core.Player;
import com.smsimulator.core.Ranking;
import com.smsimulator.gsoncore.GameRanking;
import com.smsimulator.gsoncore.Rank;
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
 * Created by skaveesh on 2018-06-24.
 */
public class RankingsRestlet extends Restlet {
    @Override
    public void handle(Request request, Response response) {
        if (request.getMethod().equals(Method.POST)) {

            List<Ranking> rankingList = new Player().getPlayerRankings();

            List<Rank> rankList = new ArrayList<>();
            for(Ranking r: rankingList){
                rankList.add(new Rank(r.getName(), r.getProfit()));
            }

            GameRanking gameRanking = new GameRanking();
            gameRanking.setRank(rankList);

            response.setEntity(InboundRoot.gson.toJson(gameRanking), MediaType.APPLICATION_JSON);
            response.setStatus(Status.SUCCESS_OK);

        } else {
            response.setStatus(Status.CLIENT_ERROR_UNAUTHORIZED);
        }
    }
}
