package com.smsimulator.core;

/**
 * Created by asusgeforce on 16/06/2018.
 */
public class Analyst extends AnalyserMain {

    public void setRecomandations(){

        AnalyserMain listAnalyt = new AnalyserMain();
        String suggetion = "";

        for (int i=0; i<listAnalyt.listStocks.length; i++){
            suggetion = listStocks[i];
            System.out.println(suggetion);
        }

    }
}
