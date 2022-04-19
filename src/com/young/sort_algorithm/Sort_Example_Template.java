package com.young.sort_algorithm;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Sort_Example_Template {
    public static void sort(Comparable[] a){}

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

    public static double time(String alg, Comparable[] a) throws InterruptedException{
        Stopwatch timer = new Stopwatch();
        if(alg.equals("Insertion")) Insertion_Sort.sort(a);
        if(alg.equals("Selection")) Selection_Sort.sort(a);
//        if(alg.equals("Shell")) Shell_Sort.sort(a);
//        if(alg.equals("Merge")) Merge_Sort.sort(a);
//        if(alg.equals("Quick")) Quick_Sort.sort(a);
//        if(alg.equals("Heap")) Heap_Sort.sort(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        // 从标准输入读取字符串，将它们排序并输出
        String[] a;
        In in = new In();
        a = in.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
