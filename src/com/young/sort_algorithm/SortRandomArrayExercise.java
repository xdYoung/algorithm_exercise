package com.young.sort_algorithm;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdRandom;

public class SortRandomArrayExercise {
    public static Double[] a = new Double[20];
    public static void main(String[] args) {
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(0.0, 500.0);
        }
        for (Double n1 : a) {
            System.out.printf("%.2f", n1);
            System.out.print(" -> ");
        }
        Quick.sort(a);
        System.out.println("\n*********************************");
        for(double n2 : a){
            System.out.printf("%.2f", n2);
            System.out.print(" -> ");
        }

    }
}
