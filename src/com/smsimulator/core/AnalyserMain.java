package com.smsimulator.core;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by asusgeforce on 16/06/2018.
 */
public class AnalyserMain {

    //use this array to get stock
    List<Sector> sectorList = new Broker().getSectorList();


    public String[] listStocks = {"Buy HNB","Buy TAB","Sell SUN","Buy SIRA","Sell GSK","Sell DLT","Buy UNI","Buy MGC","Buy SHL","Sell JKH"};

    public void importList(){

            /*String[] listStocks = new String[sectorList.size()];
            listStocks = sectorList.toArray(listStocks);

            for (String sampleList : listStocks) {
                System.out.println("LIst is "+ sampleList);
            }*/

    }

    public void setRecomandedList(){
        /*try{
            for (int i =0; i<10; i++){
                String recm = listStocks[i];
                System.out.println(recm);
            }

            System.out.println("\nList Got");
        }catch (Exception e){
            System.out.println(e);
            System.out.println("List Fail");
        }*/
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
