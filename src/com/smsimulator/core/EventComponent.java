package com.smsimulator.core;


import java.util.Arrays;
import java.util.Random;

public class EventComponent {
    private static void getRandomProbability(){
        Random random = new Random();
        double StockValues[] = new double[20];
        String event;


        for(int i=0; i<StockValues.length; i++){
            double prob = Math.random();
            if(prob >= 0.33 && prob < 0.67){
                String SelectionArray[] = {"Boom","Bust"};
                int select =random.nextInt(SelectionArray.length);
                event = SelectionArray[select];

                System.out.println(prob);
                System.out.println(event);
                if(event.equals("Boom")){
                    Random r2 = new Random();
                    for (int j= 0; j<StockValues.length; j++){
                        StockValues[j]=r2.nextInt(6) + (1);

                    }
                    System.out.println("StockValues is : "+ Arrays.toString(StockValues));
                }
            }
            else if(prob >=0.67){
                String SelectionArray[] = {"Profit_Warning", "Take_Over", "Scandal"};

                int select =random.nextInt(SelectionArray.length);
                event = SelectionArray[select];
                System.out.println(prob);
                System.out.println(event);
            }
        }
    }
    public static void main(String[] args) {
        getRandomProbability();
    }
}
