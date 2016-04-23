/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conweek4;

import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 12023081
 */
public class Polling implements Runnable {

    Queue q;

    public Polling(Queue q) {
        this.q = q;
    }

    public void run() {
        while (true) {
            if (q.size() > 0) {
                synchronized (q) {
                    System.out.println(q.poll() + " is removed");
                    q.notifyAll();
                }
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Polling.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                synchronized (q) {
                    try {
                        System.out.println("Polling is waiting");
                        q.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Polling.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}
