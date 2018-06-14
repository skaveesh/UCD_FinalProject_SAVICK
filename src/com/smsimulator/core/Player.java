package com.smsimulator.core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-12.
 */
public class Player {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

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
