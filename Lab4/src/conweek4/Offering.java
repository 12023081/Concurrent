/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conweek4;

import java.util.Queue;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 12023081
 */
public class Offering implements Runnable {

    Random generator = new Random();
    Queue q;
    Boolean firstFive = false;
    int count = 0;

    public Offering(Queue q) {
        this.q = q;
    }

    public void run() {
        while (true) {
            if (q.size() != 5) {
                try {
                    synchronized (q) {
                        int ran = generator.nextInt(100) + 1;
                        q.offer(ran);
                        count++;
                        q.notifyAll();
                        System.out.println(ran + " is added");
                    }
                    Thread.sleep(1000);

                    if (count % 5 == 0) {
                        Thread.sleep(5000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Offering.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                synchronized (q) {
                    System.out.println("Offering is waiting");
                    try {
                        q.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Offering.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}
