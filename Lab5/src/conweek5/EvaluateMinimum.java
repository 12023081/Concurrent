/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conweek5;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author 12023081
 */
public class EvaluateMinimum implements Runnable {

    double[] a;
    double min = 1000000.00;
    LinkedList minList;

    public EvaluateMinimum(double[] a, LinkedList minList) {
        this.a = a;
        this.minList = minList;
    }

    public void run() {
        for (int i = 0; i < 350; i++) {
            double temp = calculate(a);
            if (temp < min) {
                min = temp;
            }
            modify();
        }
        synchronized (minList) {
            minList.add(min);
        }
        System.out.printf("%.2f", min);
        System.out.println();
    }

    public double calculate(double[] array) {
        double sum = 0.00;
        for (int i = 0; i < 100; i++) {
            sum += (i + 1) * (array[i] * array[i]);
        }
        return sum;
    }

    public void modify() {
        Random rand = new Random();
        double r;

        for (int i = 0; i < 100; i++) {
            r = rand.nextDouble();
            r = -0.5 + (r * (0.5 - (-0.5)));

            if ((a[i] + r) < (-5.12)) {
                a[i] = -5.12;
            } else if ((a[i] + r) > (5.12)) {
                a[i] = 5.12;
            } else {
                a[i] += r;
            }
        }
    }
}
