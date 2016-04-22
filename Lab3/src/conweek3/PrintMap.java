/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conweek3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kang Jun Hong 12023081
 */
public class PrintMap implements Runnable {

    int[][] map;

    public PrintMap(int[][] map) {
        this.map = map;
    }

    public void run() {
        while (true) {
            print();
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(PrintMap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void print() {

        synchronized (map) {
            for (int i = 0; i < map.length; i++) {

                int[] sub = map[i];
                for (int x = 0; x < sub.length; x++) {
                    System.out.print(sub[x] + " ");
                }
                System.out.println("");
            }
            System.out.println("===============");
        }
    }
}
