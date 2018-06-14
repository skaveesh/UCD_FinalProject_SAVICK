package com.smsimulator.core;


import java.util.Arrays;
import java.util.Random;

public class EventComponent {

    private double eventsArray[] = new double[20];
    Random random = new Random();

    public EventComponent(){
        this.generateEvents();
    }

    public void generateEvents() {
        String eventsArray[] = {"BOOM","BUST","PROFIT_WARNING","TAKE_OVER","SCANDAL"};
        int currentSectorValuesIndex=0;

        for(int i = 0; i< this.eventsArray.length; i++){
            String selectedEvent = eventsArray[random.nextInt(eventsArray.length)];
//            System.out.println(selectedEvent);

            switch (selectedEvent){
                case "BOOM":
                    currentSectorValuesIndex = eventBoom(i);
                    i = currentSectorValuesIndex;
                    break;
                case "BUST":
                    currentSectorValuesIndex = eventBust(i);
                    i = currentSectorValuesIndex;
                    break;
                case "PROFIT_WARNING":
                    currentSectorValuesIndex = eventProfit_Warning(i);
                    i = currentSectorValuesIndex;
                    break;
                case "TAKE_OVER":
                    currentSectorValuesIndex = eventTake_Over(i);
                    i = currentSectorValuesIndex;
                    break;
                case "SCANDAL":
                    currentSectorValuesIndex = eventScandal(i);
                    i = currentSectorValuesIndex;
                    break;
                default:
                    System.out.print("Invalid");
            }
        }
        //System.out.println("Sector Values are : "+ Arrays.toString(this.eventsArray));
    }

    private int eventBoom(int j){
        int boomEvent = random.nextInt(5) + (1);
        eventsArray[j] = boomEvent;
        int boomTurns = random.nextInt(4) + (2);
//        System.out.println("Boom Turns "+boomTurns);
        for(int k=1;k<boomTurns;k++) {
            if(j< eventsArray.length-1) {
                eventsArray[j + 1] = boomEvent;
                j++;
            }
        }
        return j;
    }

    private int eventBust(int x){
        int bustEvent = random.nextInt(5) + (-5);
        eventsArray[x] = bustEvent;
        int bustTurns = random.nextInt(4) + (2);
//        System.out.println("Bust Turns "+bustTurns);
        for(int k=1;k<bustTurns;k++) {
            if(x< eventsArray.length-1) {
                eventsArray[x + 1] = bustEvent;
                x++;
            }
        }
        return x;
    }

    private int eventProfit_Warning(int y){
        int profitWarningEvent = random.nextInt(2) + (2);
        eventsArray[y] = profitWarningEvent;
        int profitWarningTurns = random.nextInt(7) + (1);
//        System.out.println("Profit Warning Turns "+profitWarningTurns);
        for(int k=1;k<profitWarningTurns;k++) {
            if(y< eventsArray.length-1) {
                eventsArray[y + 1] = profitWarningEvent;
                y++;
            }
        }
        return y;
    }

    private int eventTake_Over(int z){
        int takeOverEvent = random.nextInt(5) + (-5);
        eventsArray[z] = takeOverEvent;
        int ProfitWarningTurns = random.nextInt(7) + (1);
//        System.out.println("Take Over Turns "+ProfitWarningTurns);
        for(int k=1;k<ProfitWarningTurns;k++) {
            if(z< eventsArray.length-1) {
                eventsArray[z + 1] = takeOverEvent;
                z++;
            }
        }
        return z;
    }

    private int eventScandal(int m){
        int scandalEvent = random.nextInt(4) + (-6);
        eventsArray[m] = scandalEvent;
        int ProfitWarningTurns = random.nextInt(7) + (1);
//        System.out.println("Scandal Turns "+ProfitWarningTurns);
        for(int k=1;k<ProfitWarningTurns;k++) {
            if(m< eventsArray.length-1) {
                eventsArray[m + 1] = scandalEvent;
                m++;
            }
        }
        return m;
    }

    public double[] getEventsArray(){
        return eventsArray;
    }
}
