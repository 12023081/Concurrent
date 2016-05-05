/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conweek5;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author 12023081
 */
public class ConWeek5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        double[][] a = new double[200][100];
        Thread[] tArray = new Thread[200];
        LinkedList minList = new LinkedList();

        Random rand = new Random();
        double r;

        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 100; j++) {
                r = rand.nextDouble();
                r = -5.12 + (r * (5.12 - (-5.12)));
                a[i][j] = (Math.round(r * 100.00) / 100.00);

                //System.out.println(a[i][j]);
            }
        }

        for (int i = 0; i < 200; i++) {
            EvaluateMinimum em = new EvaluateMinimum(a[i], minList);
            tArray[i] = new Thread(em);
            tArray[i].start();
        }

        for (int i = 0; i < 200; i++) {
            tArray[i].join();
        }
        System.out.printf("Minimum of all Threads: %.2f", (double) minList.get(minList.indexOf(Collections.min(minList))));
    }
}
