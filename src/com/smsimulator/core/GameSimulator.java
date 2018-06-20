package com.smsimulator.core;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.smsimulator.gsoncore.BooleanValue;

public class GameSimulator {

    @SerializedName("isGameReadyToStart")
    @Expose
    private Boolean isGameReadyToStart;
    @SerializedName("isGameStarted")
    @Expose
    private Boolean isGameStarted;
    @SerializedName("gameStartTurn")
    @Expose
    private Integer gameStartTurn;
    @SerializedName("timeToStartTheGameInSec")
    @Expose
    private Integer timeToStartTheGameInSec;
    @SerializedName("players")
    @Expose
    private List<PlayerAndInitialBalance> players = null;
    @SerializedName("turn1")
    @Expose
    private List<PlayerTransactionsOfTurn> turn1 = null;
    @SerializedName("turn2")
    @Expose
    private List<PlayerTransactionsOfTurn> turn2 = null;
    @SerializedName("turn3")
    @Expose
    private List<PlayerTransactionsOfTurn> turn3 = null;
    @SerializedName("turn4")
    @Expose
    private List<PlayerTransactionsOfTurn> turn4 = null;
    @SerializedName("turn5")
    @Expose
    private List<PlayerTransactionsOfTurn> turn5 = null;
    @SerializedName("turn6")
    @Expose
    private List<PlayerTransactionsOfTurn> turn6 = null;
    @SerializedName("turn7")
    @Expose
    private List<PlayerTransactionsOfTurn> turn7 = null;
    @SerializedName("turn8")
    @Expose
    private List<PlayerTransactionsOfTurn> turn8 = null;
    @SerializedName("turn9")
    @Expose
    private List<PlayerTransactionsOfTurn> turn9 = null;
    @SerializedName("turn10")
    @Expose
    private List<PlayerTransactionsOfTurn> turn10 = null;

    public GameSimulator() {
    }

    public GameSimulator(Boolean isGameReadyToStart, Boolean isGameStarted, Integer gameStartTurn) {
        this.isGameReadyToStart = isGameReadyToStart;
        this.isGameStarted = isGameStarted;
        this.gameStartTurn = gameStartTurn;
    }

    public Boolean getIsGameReadyToStart() {
        return isGameReadyToStart;
    }

    public void setIsGameReadyToStart(Boolean isGameReadyToStart) {
        this.isGameReadyToStart = isGameReadyToStart;
    }

    public Boolean getIsGameStarted() {
        return isGameStarted;
    }

    public void setIsGameStarted(Boolean gameStarted) {
        isGameStarted = gameStarted;
    }

    public Integer getGameStartTurn() {
        return gameStartTurn;
    }

    public void setGameStartTurn(Integer gameStartTurn) {
        this.gameStartTurn = gameStartTurn;
    }

    public Integer getTimeToStartTheGameInSec() {
        return timeToStartTheGameInSec;
    }

    public void setTimeToStartTheGameInSec(Integer timeToStartTheGameInSec) {
        this.timeToStartTheGameInSec = timeToStartTheGameInSec;
    }

    public List<PlayerAndInitialBalance> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerAndInitialBalance> players) {
        this.players = players;
    }

    public List<PlayerTransactionsOfTurn> getTurn1() {
        return turn1;
    }

    public void setTurn1(List<PlayerTransactionsOfTurn> turn) {
        this.turn1 = turn;
    }

    public List<PlayerTransactionsOfTurn> getTurn2() {
        return turn2;
    }

    public void setTurn2(List<PlayerTransactionsOfTurn> turn2) {
        this.turn2 = turn2;
    }

    public List<PlayerTransactionsOfTurn> getTurn3() {
        return turn3;
    }

    public void setTurn3(List<PlayerTransactionsOfTurn> turn3) {
        this.turn3 = turn3;
    }

    public List<PlayerTransactionsOfTurn> getTurn4() {
        return turn4;
    }

    public void setTurn4(List<PlayerTransactionsOfTurn> turn4) {
        this.turn4 = turn4;
    }

    public List<PlayerTransactionsOfTurn> getTurn5() {
        return turn5;
    }

    public void setTurn5(List<PlayerTransactionsOfTurn> turn5) {
        this.turn5 = turn5;
    }

    public List<PlayerTransactionsOfTurn> getTurn6() {
        return turn6;
    }

    public void setTurn6(List<PlayerTransactionsOfTurn> turn6) {
        this.turn6 = turn6;
    }

    public List<PlayerTransactionsOfTurn> getTurn7() {
        return turn7;
    }

    public void setTurn7(List<PlayerTransactionsOfTurn> turn7) {
        this.turn7 = turn7;
    }

    public List<PlayerTransactionsOfTurn> getTurn8() {
        return turn8;
    }

    public void setTurn8(List<PlayerTransactionsOfTurn> turn8) {
        this.turn8 = turn8;
    }

    public List<PlayerTransactionsOfTurn> getTurn9() {
        return turn9;
    }

    public void setTurn9(List<PlayerTransactionsOfTurn> turn9) {
        this.turn9 = turn9;
    }

    public List<PlayerTransactionsOfTurn> getTurn10() {
        return turn10;
    }

    public void setTurn10(List<PlayerTransactionsOfTurn> turn10) {
        this.turn10 = turn10;
    }
}