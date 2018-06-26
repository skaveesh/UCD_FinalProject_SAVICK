package com.smsimulator.core;

import org.omg.CORBA.Object;

import javax.xml.bind.SchemaOutputResolver;
import java.util.*;


public class AnalyserMain {

    private List<Sector> sectorList;
    private List<String> stockNameList = new ArrayList<>();
    private List<PredictionHistoryArray> predictedStockList = new ArrayList<>();
    private String tempStockName = "";

    protected static final String BUY_TAG = "buy";
    protected static final String SELL_TAG = "sell";

    protected Prediction prediction[] = new Prediction[10];

    public AnalyserMain(){
        this.analyseToBuyOrSell();
    }


    /**
     * Analyse to buy or sell stocks from the stock market
     */
    private void analyseToBuyOrSell() {
        sectorList = new Broker().getSectorList();

        Debugger.log("AnalyserMain");
        for(Sector sector: sectorList){
            for(CompanyStock companyStock: sector.stockList){
                stockNameList.add(companyStock.getStockName());
            }
        }

        for (int currentTurn = 0; currentTurn < 10; currentTurn++) {
            predictedStockList.clear();
            for (String stockName : stockNameList){
                predictedStockList.add(new PredictionHistoryArray(getCompanyStockHistoryArray(stockName),stockName));
            }
            prediction[currentTurn] = turnPrediction(predictedStockList,currentTurn);
        }

        for (int testIndex = 0; testIndex <prediction.length ; testIndex++) {
            Debugger.log(prediction[testIndex].getBuyOrSell()+" "+prediction[testIndex].getStockName());
        }
    }

    /**
     * analyse for each turn
     *
     * @param predictedStockList stock list to be analysed
     * @param currentTurn Each turn
     * @return analysed prediction for each turn
     */
    private Prediction turnPrediction(List<PredictionHistoryArray> predictedStockList,int currentTurn ) {
        String buyOrSell = "";
        String stockName = "";
        double maximumChange = 0;

        for (PredictionHistoryArray predictedHistory : predictedStockList) {
            double[] predictedHistoryDouble = predictedHistory.getHistory();
            Debugger.log(predictedHistory.getStockName());
            for (int i = 0; i < predictedHistoryDouble.length ; i++) {
                Debugger.log(predictedHistoryDouble[i]);
            }

            switch (currentTurn){
                case 0:
                    buyOrSell = BUY_TAG;
                    Debugger.log("Change - "+(predictedHistoryDouble[1] - predictedHistoryDouble[0]));
                    if ((predictedHistoryDouble[1] - predictedHistoryDouble[0]) > maximumChange) {
                        maximumChange = predictedHistoryDouble[1] - predictedHistoryDouble[0];
                        stockName = predictedHistory.getStockName();
                        tempStockName = stockName;
                    }
                    Debugger.log("Maximum Change - "+maximumChange);
                    break;
                case 1:
                    buyOrSell = SELL_TAG;
                    stockName = tempStockName;
                    break;
                case 2:
                    buyOrSell = BUY_TAG;
                    if ((predictedHistoryDouble[3] - predictedHistoryDouble[2]) > maximumChange) {
                        maximumChange = predictedHistoryDouble[3] - predictedHistoryDouble[2];
                        stockName = predictedHistory.getStockName();
                        tempStockName = stockName;
                    }
                    break;
                case 3:
                    buyOrSell = SELL_TAG;
                    stockName = tempStockName;
                    break;
                case 4:
                    buyOrSell = BUY_TAG;
                    if ((predictedHistoryDouble[5] - predictedHistoryDouble[4]) > maximumChange) {
                        maximumChange = predictedHistoryDouble[5] - predictedHistoryDouble[4];
                        stockName = predictedHistory.getStockName();
                        tempStockName = stockName;
                    }
                    break;
                case 5:
                    buyOrSell = SELL_TAG;
                    stockName = tempStockName;
                    break;
                case 6:
                    buyOrSell = BUY_TAG;
                    if ((predictedHistoryDouble[7] - predictedHistoryDouble[6]) > maximumChange) {
                        maximumChange = predictedHistoryDouble[7] - predictedHistoryDouble[6];
                        stockName = predictedHistory.getStockName();
                        tempStockName = stockName;
                    }
                    break;
                case 7:
                    buyOrSell = SELL_TAG;
                    stockName = tempStockName;
                    break;
                case 8:
                    buyOrSell = BUY_TAG;
                    if ((predictedHistoryDouble[9] - predictedHistoryDouble[8]) > maximumChange) {
                        maximumChange = predictedHistoryDouble[9] - predictedHistoryDouble[8];
                        stockName = predictedHistory.getStockName();
                        tempStockName = stockName;
                    }
                    break;
                case 9:
                    buyOrSell = SELL_TAG;
                    stockName = tempStockName;
                    break;
                default:
                    Debugger.log("Something went wrong.....  :(");
            }
        }
        return new Prediction(buyOrSell,stockName);
    }

    /**
     * get the stock history of companies
     *
     * @param stockName Name of the company in which the stocks contain
     * @return returns stock history Array
     */
    protected double[] getCompanyStockHistoryArray(String stockName){
        double[] stockArray = new double[10];
        for(Sector sector : new Broker().getSectorList()){
            for (CompanyStock companyStock : sector.stockList){
                if(companyStock.getStockName().equals(stockName)){
                    stockArray = Arrays.copyOfRange(companyStock.getStockPriceArray(), 9,19);
                }
            }
        }
        return stockArray;
    }

    /**
     * get the stock array for a particular company
     *
     * @param stockName Name of the company to return the stock values
     * @return returns stocks of the company
     */
    protected double[] getCompanyStockArrayByStockName(String stockName){
        double[] stockArray = new double[10];
        for(Sector sector : new Broker().getSectorList()){
            for (CompanyStock companyStock : sector.stockList){
                if(companyStock.getStockName().equals(stockName)){
                    stockArray = Arrays.copyOfRange(companyStock.getStockPriceArray(), 9,19);
                }
            }
        }
        return stockArray;
    }
}
