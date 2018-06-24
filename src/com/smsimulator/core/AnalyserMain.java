package com.smsimulator.core;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by asusgeforce on 16/06/2018.
 */
public class AnalyserMain {

    //use this array to get stock
    List<Sector> sectorList;
    List<String> stockNameList = new ArrayList<>();
    List<PredictionHistoryArray> predictedStockList = new ArrayList<>();
    protected Prediction prediction[] = new Prediction[10];

    public AnalyserMain(){
        sectorList = new Broker().getSectorList();
        //stock market eke danata thiyena hodama trans eka (buy or sell)
        Debugger.log("AnalyserMain");
        for(Sector sector: sectorList){
            for(CompanyStock companyStock: sector.stockList){
                stockNameList.add(companyStock.getStockName());
            }
        }

//        predictedStockList.clear();
//        for (String stockName : stockNameList){
//            predictedStockList.add(new PredictionHistoryArray(getCompanyStockHistoryArray(stockName,10),stockName));
//        }
//        turnPrediction(predictedStockList);


        //predicted stock lists
        int increasingStockNumber = 10;
        for (int i = 0; i < 10; i++) {
            predictedStockList.clear();
            for (String stockName : stockNameList){
                predictedStockList.add(new PredictionHistoryArray(getCompanyStockHistoryArray(stockName,increasingStockNumber),stockName));
            }
            prediction[i] = turnPrediction(predictedStockList,i);
            increasingStockNumber++;
        }
        //for the seconnd turn
//        predictedStockList.clear();
//        for (String stockName : stockNameList){
//            predictedStockList.add(new PredictionHistoryArray(getCompanyStockHistoryArray(stockName,11),stockName));
//        }
//        prediction[1] = turnPrediction(predictedStockList);
    }

    //predicted transaction(buy or sell)
    private Prediction turnPrediction(List<PredictionHistoryArray> predictedStockList,int i ){
        String buyOrSell = "";
        String stockName = "";
        double maxChange = 0;

        for (PredictionHistoryArray predictedHistory: predictedStockList){
            double[] predictedHistoryDouble = predictedHistory.getHistory();
            if(i == 0){
                buyOrSell = "buy";
                double maxValue = predictedHistoryDouble[0]; // 73.58
                double minValue = predictedHistoryDouble[0]; // 73.58
                for (int j = 1; j <predictedHistoryDouble.length ; j++) {
                    System.out.println(predictedHistoryDouble[j]);
                    if(predictedHistoryDouble[j]>maxValue){
                        maxValue = predictedHistoryDouble[j];
                    }
                    if(predictedHistoryDouble[j]<minValue) {
                        minValue = predictedHistoryDouble[j];
                    }

                }

                if((maxValue-minValue)>maxChange){
                    maxChange = maxValue - minValue;
                    stockName = predictedHistory.getStockName();
                }
                System.out.println("Change - "+(maxValue-minValue));
                System.out.println("Max Value - "+maxValue+"------- Min Value - "+minValue);
                System.out.println("maxChange - "+maxChange+"------- stockName - "+stockName);
            }
        }

        return new Prediction(buyOrSell,stockName);
    }

    protected double[] getCompanyStockHistoryArray(String stockName, int finalStockNumber){
        double[] stockArray = new double[finalStockNumber];
        for(Sector sector : new Broker().getSectorList()){
            for (CompanyStock companyStock : sector.stockList){
                if(companyStock.getStockName().equals(stockName)){
                    stockArray = Arrays.copyOfRange(companyStock.getStockPriceArray(), 0,finalStockNumber);
                }
            }
        }
        return stockArray;
    }


    protected double[] getCompanyStockArrayByStockName(String stockName){
        double[] stockArray = new double[10];
        for(Sector sector : new Broker().getSectorList()){
            for (CompanyStock companyStock : sector.stockList){
                if(companyStock.getStockName().equals(stockName)){
                    stockArray = Arrays.copyOfRange(companyStock.getStockPriceArray(), 10,20);
                }
            }
        }
        return stockArray;
    }

    protected List<String> getAllCompanyStockNames(){
        List<String> companyStockNames = new ArrayList<>();
        for(Sector sector : new Broker().getSectorList()){
            for (CompanyStock companyStock : sector.stockList){
                companyStockNames.add(companyStock.getStockName());
            }
        }
        return companyStockNames;
    }
}
