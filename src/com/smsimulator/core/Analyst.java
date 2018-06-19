package com.smsimulator.core;

import java.util.Random;

/**
 * Created by asusgeforce on 16/06/2018.
 */
public class Analyst extends AnalyserMain {

    AnalyserMain listAnalyt = new AnalyserMain();
    public String[] setArray;
    public String suggestion = "";

    public void setRecommendations(){
        setArray = listAnalyt.listStocks;

        /*for (int i=0; i<setArray.length; i++){
            suggestion = setArray[i];
            System.out.println(suggestion);
        }*/

        int playerTurn = new Random().nextInt(10);

        switch(playerTurn){
            case 1:
                suggestion = setArray[0];
                System.out.println(suggestion);
                //return suggestion;
                break;
            case 2:
                suggestion = setArray[1];
                System.out.println(suggestion);
                //return suggestion;
                break;
            case 3:
                suggestion = setArray[2];
                System.out.println(suggestion);
                //return suggestion;
                break;
            case 4:
                suggestion = setArray[3];
                System.out.println(suggestion);
                //return suggestion;
                break;
            case 5:
                suggestion = setArray[4];
                System.out.println(suggestion);
                //return suggestion;
                break;
            case 6:
                suggestion = setArray[5];
                System.out.println(suggestion);
                //return suggestion;
                break;
            case 7:
                suggestion = setArray[6];
                System.out.println(suggestion);
                //return suggestion;
                break;
            case 8:
                suggestion = setArray[7];
                System.out.println(suggestion);
                //return suggestion;
                break;
            case 9:
                suggestion = setArray[8];
                System.out.println(suggestion);
                //return suggestion;
                break;
            case 10:
                suggestion = setArray[9];
                System.out.println(suggestion);
                //return suggestion;
                break;

        }
        //return suggestion;
    }

    public String[] getRecommendations(){
        System.out.println("List Returned");

        return this.setArray;
    }
}
