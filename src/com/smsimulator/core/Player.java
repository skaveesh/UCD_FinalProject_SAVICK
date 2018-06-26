package com.smsimulator.core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smsimulator.server.root.Main;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-12.
 */
public class Player {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    /**
     * Create player account
     * @param username username of player
     * @param password password of player
     * @return true if account creation successful
     */
    public boolean createAccount(String username, String password){
        try {
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

            preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("INSERT INTO player(username, password) VALUES(?,?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, hashedPassword);
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * login player
     * @param username username of the player
     * @param password password of the player
     * @return return true if login success
     */
    public boolean loginPlayer(String username, String password){
        try {
            String passwordFromDatabase = "";

            preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("SELECT password FROM player WHERE username=?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                passwordFromDatabase = resultSet.getString("password");
            }

            return BCrypt.checkpw(password, passwordFromDatabase);
        } catch (SQLException | StringIndexOutOfBoundsException e) {
            return false;
        }
    }

    /**
     * get uid of the player from the database
     * @param name username of the player
     * @return uid of the player
     */
    public int getUidFromName(String name) {
        try {
            preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("SELECT uid FROM player WHERE username=?");
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            int returnUid = -1;

            while (resultSet.next()) {
                returnUid = resultSet.getInt("uid");
            }

            return returnUid;
        } catch (SQLException e) {
            return -1;
        }
    }

    /**
     * get player scoreboard for the current game turn
     * @param startTurn game turn of the finally played game
     * @return scoreboard list
     */
    public List<Score> getPlayerScoreboard(int startTurn){
        List<Score> scoreList = new ArrayList<>();

        try {
            preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("SELECT p.username, sc.start_balance, sc.end_balance, sc.end_balance - sc.start_balance AS profit FROM scoreboard AS sc INNER JOIN player AS p ON sc.uid=p.uid WHERE sc.start_turn=? ORDER BY profit DESC");
            preparedStatement.setInt(1, startTurn);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Score score = new Score(resultSet.getString("username"),resultSet.getDouble("start_balance"),resultSet.getDouble("end_balance"),resultSet.getDouble("profit"));
                scoreList.add(score);
            }

            return scoreList;
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * get rankings of the all players all the time, limited to first 10 players
     * @return ranking list
     */
    public List<Ranking> getPlayerRankings(){
        List<Ranking> rankingList = new ArrayList<>();

        try {
            preparedStatement = DBUtils.getDatabaseConnection().prepareStatement("SELECT p.username, (sum(sc.end_balance) - sum(sc.start_balance)) AS profit FROM scoreboard AS sc INNER JOIN player AS p ON sc.uid=p.uid GROUP BY sc.uid HAVING profit>0 ORDER BY profit DESC limit 10;");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Ranking ranking= new Ranking(resultSet.getString("username"),resultSet.getDouble("profit"));
                rankingList.add(ranking);
            }

            return rankingList;
        } catch (SQLException e) {
            return null;
        }
    }

}
