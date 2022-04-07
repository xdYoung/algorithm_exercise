package com.young.algorithm_analysis;

import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DoublingTest {
    static int cnt;

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

    public static void main(String[] args){
        // 打印运行时间的表格
        Out out = new Out("./resources/files/DoublingTestResult.txt");
        for (int N = 200; true; N+=N) {
            double time = timeTrial(N);
            StdOut.printf("数组大小：%7d , ThreeSum查找耗时：%5.1f s ， 满足ThreeSum的个数为：%d\n", N, time, cnt);
            out.printf("数组大小：%7d , ThreeSum查找耗时：%5.1f s ， 满足ThreeSum的个数为：%d\n", N, time, cnt);
            if(time > 300){
                break;
            }
        }
        out.close();
    }
}
