package com.young.algorithm_analysis;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

public class StopWatch {
    // 一种表示计时器的抽象数据类型
    private final long start;

    public StopWatch(){
        start = System.currentTimeMillis();
    }

    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    public static void main(String[] args) {
        StdOut.print("请输入数组的大小： ");
        int N = StdIn.readInt();
        int[] a = new int[N];
        long seed = System.currentTimeMillis();
        int a1 = -1000000;
        int a2 = 1000000;
        Random random = new Random(seed);
        for (int i = 0; i < N; i++) {
            a[i] = a1 + random.nextInt(a2 - a1);
            System.out.println(a[i]);
        }
        StopWatch timer = new StopWatch();
        int cnt = ThreeSum.count(a);
        double time = timer.elapsedTime();
        System.out.println("在大小为 " + N + " 的数组中查找到 "  + cnt + " 个 triples（ThreeNum为零），耗时： " + time + " seconds ");
    }
}
