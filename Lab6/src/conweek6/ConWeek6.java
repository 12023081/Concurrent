/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conweek6;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author 12023081
 */
public class ConWeek6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        double[][] a = new double[200][100];
        LinkedList minList = new LinkedList();
        //Thread[] tArray = new Thread[200];
        double min = 100000.00;
        long start;
        long end;

        ExecutorService exec = Executors.newFixedThreadPool(5);

        Random rand = new Random();
        double r;

        start = System.currentTimeMillis();
        
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
            exec.execute(em);
        }
        exec.shutdown();
        exec.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        for (int i = 0; i < minList.size(); i++) {
            if ((double) minList.get(i) < min) {
                min = (double) minList.get(i);
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Time needed to run program: " + (end - start) + "ms");
        System.out.printf("Smallest number: %.2f", min);
//        for (int i = 0; i < 200; i++) {
//            EvaluateMinimum em = new EvaluateMinimum(a[i]);
//            tArray[i] = new Thread(em);
//            tArray[i].start();
//        }

//        for (int i = 0; i < 200; i++) {
//            tArray[i].join();
//        }
    }
}
