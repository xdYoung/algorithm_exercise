package com.young.algorithm_analysis;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ThreeSumFast {
    // 假设所有整数均各不相同，当且仅当-(a[i] + a[j])在数组中时，整数对（a[i],a[j])为某个和为0的三元组的一部分。
    // 下面代码框中的代码会将数组排序并进行N(N-1)/2次二分查找，每次查找所需的时间都和lgN成正比
    // 因此总的运行时间和N2lgN成正比

    public static int count(int[] a){
        // 计算和为0的三元组的数目
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if(BinarySearch.indexOf(a,-a[i]-a[j]) > j) cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = new In("./resources/algs4_data/16Kints.txt").readAllInts();
        StopWatch timer = new StopWatch();
        StdOut.println("ThreeSumFast算法在1Mints.txt文件中计算的三个数和为0的三元整数组的个数为： " + count(a));
        double time = timer.elapsedTime();
        StdOut.println("ThreeSumFast耗时： " + time);
    }
}
