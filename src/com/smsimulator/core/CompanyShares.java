package com.smsimulator.core;

import java.util.HashSet;
import java.util.Random;

public class CompanyShares {

    public void randomStocks() {

        for(int i=0;i<10;i++) {
            for (int j = 0; j < 5; j++) {
                Random r = new Random();
                HashSet<Float> numSet = new HashSet<>();

                while (numSet.size() < 1) {
                    float random = r.nextInt(99) + 10;
                    numSet.add(random);
                }
                for (Float ranStock : numSet) {
                    System.out.print(ranStock + "\t");
                }
            }
            System.out.print("\n");
        }
    }

}
