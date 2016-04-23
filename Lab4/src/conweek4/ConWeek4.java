/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conweek4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 12023081
 */
public class ConWeek4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Queue q = new LinkedList<>();

        Offering o = new Offering(q);
        Polling p = new Polling(q);

        Thread t1 = new Thread(o);
        Thread t2 = new Thread(p);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ConWeek4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
