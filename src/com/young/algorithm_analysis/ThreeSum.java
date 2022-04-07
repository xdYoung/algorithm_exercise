package com.young.algorithm_analysis;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ThreeSum {
    public static int count(int[] a){
        // 统计和为0的元组的数量
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if(a[i] + a[j] + a[k] == 0){
//                        StdOut.println(a[i] + " + " + a[j] + " + " + a[k] + " = " + " 0 ");
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String filePath = "./resources/algs4_data/2Kints.txt";
        In in = new In(filePath);
        int[] a = in.readAllInts();
        StdOut.println("ThreeNum相加为零的总数为： " + count(a));
    }
}
