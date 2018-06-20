package com.smsimulator.core;

import com.smsimulator.server.root.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-19.
 */
public class Game {

    static private boolean isGameReadyToStart = true;
    static private boolean isGameStarted = false;

    static private List<String> playerList = new ArrayList<>();

    static private List<PlayerTransactionsOfTurn> turn1 = new ArrayList<>();
    static private List<PlayerTransactionsOfTurn> turn2 = new ArrayList<>();
    static private List<PlayerTransactionsOfTurn> turn3 = new ArrayList<>();
    static private List<PlayerTransactionsOfTurn> turn4 = new ArrayList<>();
    static private List<PlayerTransactionsOfTurn> turn5 = new ArrayList<>();
    static private List<PlayerTransactionsOfTurn> turn6 = new ArrayList<>();
    static private List<PlayerTransactionsOfTurn> turn7 = new ArrayList<>();
    static private List<PlayerTransactionsOfTurn> turn8 = new ArrayList<>();
    static private List<PlayerTransactionsOfTurn> turn9 = new ArrayList<>();
    static private List<PlayerTransactionsOfTurn> turn10 = new ArrayList<>();

    static private GameSimulator gameSimulator;

    private static int timeToStartTheGameInSec = 40; //initially every player has 60 seconds to join the game
    private static int timeToStartTheNextRoundInSec = 20; //every round has 30 seconds to player to do a transaction

    private static int turnCounter = 0;

    private static Timer timeToStartTheGameTimer = new Timer("Time to join the game in seconds");//create a new Timer;
    private static Timer timeToStartNextRoundTimer = new Timer("Time to start a new round");//create a new Timer;

    private static TimerTask timeToStartTheGameCounterTimerTask = new TimerTask() {
        @Override
        public void run() {
            System.out.println("time to join the game is: " + timeToStartTheGameInSec);
            timeToStartTheGameInSec--; //decrements the counter
            gameSimulator.setTimeToStartTheGameInSec(timeToStartTheGameInSec);

            if (timeToStartTheGameInSec == 0) {
                isGameReadyToStart = false;
                isGameStarted = true;
                gameSimulator.setIsGameReadyToStart(isGameReadyToStart);
                gameSimulator.setIsGameStarted(isGameStarted);

                timeToStartTheGameTimer.cancel();
                timeToStartNextRoundTimer.scheduleAtFixedRate(timeToStartTheNextRoundCounterTimerTask, 10, timeToStartTheNextRoundInSec * 1000);
            }
        }
    };

    private static TimerTask timeToStartTheNextRoundCounterTimerTask = new TimerTask() {

        @Override
        public void run() {

            if (turnCounter == 10) {
                System.out.println("game end");
                timeToStartNextRoundTimer.cancel();
                isGameReadyToStart = true;
                isGameStarted = false;
                gameSimulator.setIsGameReadyToStart(isGameReadyToStart);
                gameSimulator.setIsGameStarted(isGameStarted);

            } else {
                turnCounter++;
                System.out.println("now begins the turn : " + turnCounter);
            }
        }
    };

    public void play() {


    }

    public static void initializeGame() {

        playerList.clear();

        turn1.clear();
        turn2.clear();
        turn3.clear();
        turn4.clear();
        turn5.clear();
        turn6.clear();
        turn7.clear();
        turn8.clear();
        turn9.clear();
        turn10.clear();

        gameSimulator = new GameSimulator(isGameReadyToStart, isGameStarted, Main.nextTURN(), 60);

        timeToStartTheGameTimer.scheduleAtFixedRate(timeToStartTheGameCounterTimerTask, 10, 1000);

    }


    public void getCurrentGame() {

    }

    public static void addToPlayerList(String playerName) {
        playerList.add(playerName);
    }

    public static boolean getIsGameReadyToStart() {
        return isGameReadyToStart;
    }

    public static boolean getIsGameStarted() {
        return isGameStarted;
    }

    public static List<String> getPlayerList() {
        return playerList;
    }

    public static void addPlayerTransactionToTurn(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        Game.addToTurn(playerTransactionsOfTurn, turnCounter);
    }

    private static void addToTurn(PlayerTransactionsOfTurn playerTransactionsOfTurn, int turn) {
        switch (turn) {
            case 1:
                addToTurn1(playerTransactionsOfTurn);
                break;
            case 2:
                addToTurn2(playerTransactionsOfTurn);
                break;
            case 3:
                addToTurn3(playerTransactionsOfTurn);
                break;
            case 4:
                addToTurn4(playerTransactionsOfTurn);
                break;
            case 5:
                addToTurn5(playerTransactionsOfTurn);
                break;
            case 6:
                addToTurn6(playerTransactionsOfTurn);
                break;
            case 7:
                addToTurn7(playerTransactionsOfTurn);
                break;
            case 8:
                addToTurn8(playerTransactionsOfTurn);
                break;
            case 9:
                addToTurn9(playerTransactionsOfTurn);
                break;
            case 10:
                addToTurn10(playerTransactionsOfTurn);
                break;
            default:
                break;
        }
    }

    private static void addToTurn1(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        turn1.add(playerTransactionsOfTurn);
    }

    private static void addToTurn2(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        turn2.add(playerTransactionsOfTurn);
    }

    private static void addToTurn3(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        turn3.add(playerTransactionsOfTurn);
    }

    private static void addToTurn4(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        turn4.add(playerTransactionsOfTurn);
    }

    private static void addToTurn5(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        turn5.add(playerTransactionsOfTurn);
    }

    private static void addToTurn6(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        turn6.add(playerTransactionsOfTurn);
    }

    private static void addToTurn7(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        turn7.add(playerTransactionsOfTurn);
    }

    private static void addToTurn8(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        turn8.add(playerTransactionsOfTurn);
    }

    private static void addToTurn9(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        turn9.add(playerTransactionsOfTurn);
    }

    private static void addToTurn10(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        turn10.add(playerTransactionsOfTurn);
    }
}
