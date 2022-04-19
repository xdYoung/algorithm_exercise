package com.young.sort_algorithm;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Insertion_Sort {

    public static void sort(Comparable[] a){
        // 将a[]按升序排列
        int N = a.length;
        for (int i = 1; i < N; i++) {
            // 将a[i]插入到a[i-1],a[i-2],a[i-3]...之中。
            for(int j=i; j>0 && less(a[j],a[j-1]); j--){
                exch(a, j, j-1);
            }
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
        for (Comparable item : a) {
            StdOut.print(item + " ");
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
