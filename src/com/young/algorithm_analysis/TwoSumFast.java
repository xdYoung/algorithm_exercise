package com.young.algorithm_analysis;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class TwoSumFast {
    // 2-sum问题的线性对数增长数量级别的解法。
    // 归并排序的增长数量级是 NlgN：即算法运行所需的时间与 NlgN 成正比
    // 二分查找算法的增长数量级是 lgN：即算法运行所需时间与 lgN 成正比
    // 因此整个算法运行所需的时间与 NlgN 成正比

    public static int count(int[] a){
        // 计算和为0的整数对的数目
        int N = a.length;
        int cnt = 0;
        Arrays.sort(a);
        for (int i = 0; i < N; i++) {
            if(BinarySearch.indexOf(a, -a[i]) > i){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = new In("./resources/algs4_data/1Mints.txt").readAllInts();
        StopWatch timer = new StopWatch();
        StdOut.println("TwoSumFast算法在1Mints.txt文件中计算的两数和为0的整数对个数为： " + count(a));
        double time = timer.elapsedTime();
        StdOut.println("TwoSumFast耗时： " + time);
    }
}
