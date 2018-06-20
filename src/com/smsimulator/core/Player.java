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
}
