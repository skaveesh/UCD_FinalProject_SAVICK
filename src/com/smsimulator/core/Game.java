package com.smsimulator.core;

import com.smsimulator.server.root.Main;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-19.
 */
public class Game {

    private static final int TIME_TO_READY_IN_SEC = 60;
    private static final int TIME_FOR_EACH_TURN_IN_SEC = 30;
    private static final int MINIMUM_PLAYERS_LIMIT = 3;

    static private int gameStartedTurn = -1;

    static private boolean isGameReadyToStart = true;
    static private boolean isGameStarted = false;

    static private List<PlayerAndInitialBalance> playerList = new ArrayList<>();

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


    private static int timeToStartTheGameInSec = TIME_TO_READY_IN_SEC; //initially every player has 60 seconds to join the game

    private static int turnCounter = 0;

    private static Timer timeToStartTheGameTimer;
    private static Timer timeToStartNextRoundTimer;

    private static PlayerTransactionsOfTurn[] aiPlayerTransactions;

    static private GameSimulator gameSimulator = new GameSimulator(true, false, gameStartedTurn, turnCounter);

    static AIPlayer aiPlayer = new AIPlayer();

    private static void startReadyCounter() throws NullPointerException {
        timeToStartTheGameTimer = new Timer("Time to join the game in seconds");//create a new Timer

        TimerTask timeToStartTheGameCounterTimerTask = new TimerTask() {

            @Override
            public void run() {
                Debugger.log("time to join the game is: " + timeToStartTheGameInSec);
                timeToStartTheGameInSec--; //decrements the counter
                gameSimulator.setTimeToStartTheGameInSec(timeToStartTheGameInSec);
                isGameReadyToStart = false;

                if (timeToStartTheGameInSec == 0 && playerList.size() >= MINIMUM_PLAYERS_LIMIT) {
                    isGameStarted = true;
                    gameSimulator.setIsGameReadyToStart(isGameReadyToStart);
                    gameSimulator.setIsGameStarted(isGameStarted);

                    timeToStartTheGameTimer.cancel();
                    startTurnCounter();

                    //aiPlayerTransactions = getAIPlayerActions();
                } else if (timeToStartTheGameInSec == 0) {
                    timeToStartTheGameTimer.cancel();

                    Debugger.log("not starting game because not enough players");
                    timeToStartTheGameInSec = TIME_TO_READY_IN_SEC;

                    isGameReadyToStart = true;
                    isGameStarted = false;
                    gameSimulator.setIsGameReadyToStart(isGameReadyToStart);
                    gameSimulator.setIsGameStarted(isGameStarted);

                    //clear player list and turn information
                    clearPlayerListAndTurnInformation();
                }
            }
        };

        timeToStartTheGameTimer.scheduleAtFixedRate(timeToStartTheGameCounterTimerTask, 10, 1000);
    }

    private static void startTurnCounter() throws NullPointerException {

        timeToStartNextRoundTimer = new Timer("Time to start a new round");//create a new Timer;

        TimerTask timeToStartTheNextRoundCounterTimerTask = new TimerTask() {

            @Override
            public void run() {

                if (turnCounter == 10) {
                    Debugger.log("game end");

                    //stop timer and set turn counter to 0
                    timeToStartNextRoundTimer.cancel();
                    turnCounter = 0;
                    timeToStartTheGameInSec = TIME_TO_READY_IN_SEC;

                    isGameReadyToStart = true;
                    isGameStarted = false;
                    gameSimulator.setIsGameReadyToStart(isGameReadyToStart);
                    gameSimulator.setIsGameStarted(isGameStarted);

                    //save each user to scoreboard table of the database
                    int gameEndTurn = Main.getTURN();

                    for (PlayerAndInitialBalance playerAndInitialBalance : playerList) {
                        int playerUid = new Player().getUidFromName(playerAndInitialBalance.getName());
                        double currentPlayerBalance = new Bank().balance(playerAndInitialBalance.getName());

                        savePlayersToScoreBoard(playerUid, gameStartedTurn, gameEndTurn, playerAndInitialBalance.getStartBalance(), currentPlayerBalance);
                    }

                    //clear player list and turn information
                    clearPlayerListAndTurnInformation();

                    //reset the stock market
                    Broker.generateNewStock();

                } else {
                    turnCounter++;

                    gameSimulator.setGameLocalCurrentTurn(turnCounter);

                    aiPlayerTransactions = getAIPlayerActions();

                    if (aiPlayerTransactions[turnCounter - 1] != null) {
                        PlayerTransactionsOfTurn aiPlayerTransaction = aiPlayerTransactions[turnCounter - 1];
                        if (aiPlayerTransaction.getSellOrBuy().equals("sell")) {
                            new Broker().sell(Main.nextTURN(), aiPlayerTransaction.getName(), aiPlayerTransaction.getStock(), aiPlayerTransaction.getQuantity(), aiPlayerTransaction.getStockPrice());
                        } else if (aiPlayerTransaction.getSellOrBuy().equals("buy")) {
                            new Broker().buy(Main.nextTURN(), aiPlayerTransaction.getName(), aiPlayerTransaction.getStock(), aiPlayerTransaction.getQuantity(), aiPlayerTransaction.getStockPrice());
                        }
                    }

                    Debugger.log("now begins the turn : " + turnCounter);

                }
            }
        };

        timeToStartNextRoundTimer.scheduleAtFixedRate(timeToStartTheNextRoundCounterTimerTask, 10, TIME_FOR_EACH_TURN_IN_SEC * 1000);

    }

    public static void play() {

        aiPlayer = new AIPlayer();

        clearPlayerListAndTurnInformation();

        gameStartedTurn = Main.nextTURN();

        gameSimulator = new GameSimulator(isGameReadyToStart, isGameStarted, gameStartedTurn, turnCounter);

        startReadyCounter();

        //add AI Player to players list
        addToPlayerList("AIPlayer");
    }

    public GameSimulator getCurrentGame() {

        gameSimulator.setPlayers(playerList);

        gameSimulator.setTurn1(turn1);
        gameSimulator.setTurn2(turn2);
        gameSimulator.setTurn3(turn3);
        gameSimulator.setTurn4(turn4);
        gameSimulator.setTurn5(turn5);
        gameSimulator.setTurn6(turn6);
        gameSimulator.setTurn7(turn7);
        gameSimulator.setTurn8(turn8);
        gameSimulator.setTurn9(turn9);
        gameSimulator.setTurn10(turn10);

        return gameSimulator;
    }


//    aiPlayer = null;
//
//    aiPlayer = new AIPlayer();
    private static PlayerTransactionsOfTurn[] getAIPlayerActions() {


        System.out.println("++++++++++++++++++++++++++++++++++++++");
        for (PlayerTransactionsOfTurn p : aiPlayer.getPlayerTransactionsOfTurnsArray()) {
            Debugger.log(p.getStock() + " " + p.getQuantity() + " " + p.getSellOrBuy());
        }

        PlayerTransactionsOfTurn[] playerTransactionsOfTurns = new PlayerTransactionsOfTurn[10];

        for (int i = 0; i < aiPlayer.getPlayerTransactionsOfTurnsArray().length; i++) {
            playerTransactionsOfTurns[i] = aiPlayer.getPlayerTransactionsOfTurnsArray()[i];
        }

        return playerTransactionsOfTurns;
    }

    private Analyst analyst = new Analyst();

    public String[] getAnalyserRecommendations() {

        return analyst.getRecommendations();
    }

    public static void addToPlayerList(String playerName) {
        playerList.add(new PlayerAndInitialBalance(playerName, new Bank().balance(playerName)));
    }

    public static boolean getIsGameReadyToStart() {
        return isGameReadyToStart;
    }

    public static boolean getIsGameStarted() {
        return isGameStarted;
    }

    public static List<PlayerAndInitialBalance> getPlayerList() {
        return playerList;
    }


    public static boolean addPlayerTransactionToTurn(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        return Game.addToTurn(playerTransactionsOfTurn, turnCounter);
    }

    private static boolean addToTurn(PlayerTransactionsOfTurn playerTransactionsOfTurn, int turn) {

        boolean addingToTurnSuccessful = false;
        switch (turn) {
            case 1:
                addingToTurnSuccessful = addToTurn1(playerTransactionsOfTurn);
                break;
            case 2:
                addingToTurnSuccessful = addToTurn2(playerTransactionsOfTurn);
                break;
            case 3:
                addingToTurnSuccessful = addToTurn3(playerTransactionsOfTurn);
                break;
            case 4:
                addingToTurnSuccessful = addToTurn4(playerTransactionsOfTurn);
                break;
            case 5:
                addingToTurnSuccessful = addToTurn5(playerTransactionsOfTurn);
                break;
            case 6:
                addingToTurnSuccessful = addToTurn6(playerTransactionsOfTurn);
                break;
            case 7:
                addingToTurnSuccessful = addToTurn7(playerTransactionsOfTurn);
                break;
            case 8:
                addingToTurnSuccessful = addToTurn8(playerTransactionsOfTurn);
                break;
            case 9:
                addingToTurnSuccessful = addToTurn9(playerTransactionsOfTurn);
                break;
            case 10:
                addingToTurnSuccessful = addToTurn10(playerTransactionsOfTurn);
                break;
            default:
                break;
        }

        return addingToTurnSuccessful;
    }

    private static void clearPlayerListAndTurnInformation() {
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
    }

    private static void savePlayersToScoreBoard(int playerUid, int startTurn, int endTurn, double startBalance, double endBalance) {
        try {

            PreparedStatement preparedStatement;
            preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("INSERT INTO scoreboard(uid, start_turn, end_turn, start_balance, end_balance) VALUES(?,?,?,?,?)");
            preparedStatement.setInt(1, playerUid);
            preparedStatement.setInt(2, startTurn);
            preparedStatement.setInt(3, endTurn);
            preparedStatement.setDouble(4, startBalance);
            preparedStatement.setDouble(5, endBalance);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean addToTurn1(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        if (!checkIfPlayerHasTransactionInTheCurrentTurn(playerTransactionsOfTurn, turn1)) {
            turn1.add(playerTransactionsOfTurn);
            return true;
        } else
            return false;
    }

    private static boolean addToTurn2(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        if (!checkIfPlayerHasTransactionInTheCurrentTurn(playerTransactionsOfTurn, turn2)) {
            turn2.add(playerTransactionsOfTurn);
            return true;
        } else
            return false;
    }

    private static boolean addToTurn3(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        if (!checkIfPlayerHasTransactionInTheCurrentTurn(playerTransactionsOfTurn, turn3)) {
            turn3.add(playerTransactionsOfTurn);
            return true;
        } else
            return false;
    }

    private static boolean addToTurn4(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        if (!checkIfPlayerHasTransactionInTheCurrentTurn(playerTransactionsOfTurn, turn4)) {
            turn4.add(playerTransactionsOfTurn);
            return true;
        } else
            return false;
    }

    private static boolean addToTurn5(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        if (!checkIfPlayerHasTransactionInTheCurrentTurn(playerTransactionsOfTurn, turn5)) {
            turn5.add(playerTransactionsOfTurn);
            return true;
        } else
            return false;
    }

    private static boolean addToTurn6(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        if (!checkIfPlayerHasTransactionInTheCurrentTurn(playerTransactionsOfTurn, turn6)) {
            turn6.add(playerTransactionsOfTurn);
            return true;
        } else
            return false;
    }

    private static boolean addToTurn7(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        if (!checkIfPlayerHasTransactionInTheCurrentTurn(playerTransactionsOfTurn, turn7)) {
            turn7.add(playerTransactionsOfTurn);
            return true;
        } else
            return false;
    }

    private static boolean addToTurn8(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        if (!checkIfPlayerHasTransactionInTheCurrentTurn(playerTransactionsOfTurn, turn8)) {
            turn8.add(playerTransactionsOfTurn);
            return true;
        } else
            return false;
    }

    private static boolean addToTurn9(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        if (!checkIfPlayerHasTransactionInTheCurrentTurn(playerTransactionsOfTurn, turn9)) {
            turn9.add(playerTransactionsOfTurn);
            return true;
        } else
            return false;
    }

    private static boolean addToTurn10(PlayerTransactionsOfTurn playerTransactionsOfTurn) {
        if (!checkIfPlayerHasTransactionInTheCurrentTurn(playerTransactionsOfTurn, turn10)) {
            turn10.add(playerTransactionsOfTurn);
            return true;
        } else
            return false;
    }

    private static boolean checkIfPlayerHasTransactionInTheCurrentTurn(PlayerTransactionsOfTurn playerTransactionsOfTurn, List<PlayerTransactionsOfTurn> currentTurn) {
        for (PlayerTransactionsOfTurn transactionsOfTurn : currentTurn) {
            if (transactionsOfTurn.getName().equals(playerTransactionsOfTurn.getName())) {
                return true;
            }
        }
        return false;
    }
}
