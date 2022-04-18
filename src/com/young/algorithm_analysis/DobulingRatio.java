package com.young.algorithm_analysis;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DobulingRatio {
    private static int cnt;

    public static double timeTrial(int N){
        // 为处理N个随机的六位整数的ThreeSum.count()计时
        int Max = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-Max,Max);
        }
        StopWatch timer = new StopWatch();
        cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        double prev = timeTrial(125);
        StdOut.println("数据\t时间\t比率");
        for (int N = 250; true ; N+=N) {
            double time = timeTrial(N);
            StdOut.printf("%6d\t%7.1f", N, time);
            StdOut.printf("\t%5.1f\n", time/prev);
            prev = time;
        }
    }
}
