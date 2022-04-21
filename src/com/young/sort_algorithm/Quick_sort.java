package com.young.sort_algorithm;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class Quick_sort {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        System.out.println(Arrays.toString(a));
        sort(a, 0, a.length-1);
    }

    public static void sort(Comparable[] a, int lo, int hi){
        if(lo >= hi) return;
        int j = parttition(a, lo, hi);  // 对数组进行切分，并返回左子数组不大于a[lo]，有子数组不小于a[lo]的位置下标。
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    public static int parttition(Comparable[] a, int lo, int hi){
        // 将数组切分为a[lo..i-1],a[i],a[i+1..hi]
        int i = lo, j = hi + 1; // 左右扫描指针
        Comparable v = a[lo];
        while(true){
            // 扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v)) if(i == hi) break;
            while(less(v, a[--j])) if(j == lo) break;
            if(i>=j) break;
            exch(a, i, j);
        }
        exch(a, lo, j); // 将 v=a[j]放入正确的位置
        return j;   // a[lo..j-1] <= a[j] <= a[j+1..hi] 达成
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
        In in = new In("./resources/algs4_data/sort_data/str_data_1.txt");
        a = in.readAllStrings();
        show(a);
        Stopwatch timer = new Stopwatch();
        sort(a);
        assert isSorted(a);
        System.out.println(timer.elapsedTime());
        show(a);
    }

    public static void main(String[] args) {
        test01();
    }
}
