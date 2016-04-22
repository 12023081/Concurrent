/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conweek3;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kang Jun Hong 12023081
 */
public class RandomRobot implements Runnable {

    int map[][] = new int[8][8];
    int x = 0;
    int y = 0;
    int choice;
    Random random = new Random();

    public RandomRobot(int[][] map) {
        this.map = map;
    }

    public void getX() {
        if (random.nextBoolean() == true && x < 7) {
            x++;
        } else {
            if (x > 0) {
                x--;
            }
        }
    }

    public void getY() {
        if (random.nextBoolean() == true && y < 7) {
            y++;
        } else {
            if (y > 0) {
                y--;
            }
        }
    }

    public void run() {
        while (true) {
            synchronized (map) {
                map[x][y] = 0;

                choice = random.nextInt(4 - 1) + 1;
                switch (choice) {
                    case 1:
                        getX();
                        break;
                    case 2:
                        getY();
                        break;
                    case 3:
                        getX();
                        getY();
                        break;
                }
                map[x][y] = 1;
            }
            try {
                Thread.sleep(600);
            } catch (InterruptedException ex) {
                Logger.getLogger(RandomRobot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
