/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conweek3;


/**
 *
 * @author Kang Jun Hong 12023081
 */
public class ConWeek3 {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        int[][] map = new int[][]{
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };//not required. default initialized to 0
        RandomRobot thread1 = new RandomRobot(map);
        PrintMap thread2 = new PrintMap(map);
        
            Thread t1 = new Thread(thread1);
            Thread t2 = new Thread(thread2);
            
            t1.start();
            t2.start();
            
            t1.join();
            t2.join();
    }

}
