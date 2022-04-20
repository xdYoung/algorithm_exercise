package com.young.sort_algorithm;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Merge_Down_Up_Sort {
    private static Comparable[] aux;

    // 原地归并的抽象方法
    public static void merge(Comparable[] a, int lo, int mid, int hi){
        // 将a[lo..mind]和a[mid+1..hi]归并
        int i = lo, j = mid+1;

        for(int k = lo; k <= hi; k++){
            // 将a[lo..hi]复制到aux[lo..hi]
            aux[k] = a[k];
//            System.out.println(Arrays.toString(aux));
        }

        for (int k = lo; k <= hi; k++) {
            // 归并回到a[lo..hi]
//            System.out.println(Arrays.toString(a));
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static void sort(Comparable[] a){
        // 进行lgN次两两归并
        int N = a.length;
        aux = new Comparable[N];
        for(int sz=1; sz<N-sz; sz+=sz){
            // sz子数组大小
            for(int lo=0; lo<N-sz; lo+=sz+sz){
                // lo:子数组索引
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
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
