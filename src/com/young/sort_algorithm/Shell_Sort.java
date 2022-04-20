package com.young.sort_algorithm;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Shell_Sort {
    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while(h < N/3) h = h*3 + 1; // 1 ， 4 ， 13 ， 40 ， 121， 364 ... 称为递增序列。从N/3会递减至1。
        while(h >= 1){
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            h /= 3;
        }
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private static void show(Comparable[] a){
        // 在单行打印数组
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a){
        // 测试数组元素是否有序
        for (int i = 1; i < a.length; i++) {
            if(less(a[i], a[i-1])) return false;
        }
        return true;
    }

    public static void test01(){
        // 从标准输入读取字符串，将它们排序并输出
        String[] a;
        In in = new In("./resources/algs4_data/sort_data/mobydick.txt");
        a = in.readAllStrings();
//        show(a);
        Stopwatch timer = new Stopwatch();
        sort(a);
        assert isSorted(a);
        System.out.println(timer.elapsedTime());
//        show(a);
    }

    public static void main(String[] args) {
        test01();
    }
}
