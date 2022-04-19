package com.young.sort_algorithm;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.concurrent.TimeUnit;

public class Selection_Sort {

    public static void sort(Comparable[] a) throws InterruptedException {
        int N = a.length;
        Double[] aa = (Double[]) a;
        for (int i = 0; i < N; i++) {
            int min = i;
            show(a);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledRectangle(min*25, aa[min]/2,9,aa[min]/2);
            for (int j = i + 1; j < N; j++) {
                if(less(a[j], a[min])) {
                    min = j;
                    StdDraw.filledRectangle(j*25, aa[j]/2,9,aa[j]/2);
                }
            }
            TimeUnit.SECONDS.sleep(2);
            exch(a, i, min);
        }
    }

    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private static void show(Comparable[] a){
        Double[] aa = (Double[]) a;
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.clear();
        // 在单行打印数组
        for (int i = 0; i < aa.length; i++) {
            StdOut.print(aa[i] + " ");
            StdDraw.filledRectangle(i*25, aa[i]/2, 9, aa[i]/2);
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

    public static void test01() throws InterruptedException {
        // 从标准输入读取字符串，将它们排序并输出
        String[] a;
        In in = new In("./resources/algs4_data/sort_data/str_data_1.txt");
        a = in.readAllStrings();
        show(a);
        sort(a);
        assert isSorted(a);
        show(a);
    }

    public static void test02() throws InterruptedException {
        Double[] a;
        a = new Double[20];
        StdDraw.setYscale(-50,100);
        StdDraw.setXscale(-125, 600);
//        StdDraw.setPenColor(StdDraw.GRAY);
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(10.0, 60.0);
//            StdDraw.filledRectangle(i*25, a[i]/2, 9, a[i]/2);
        }
        show(a);
        sort(a);


    }

    public static void main(String[] args) throws InterruptedException {
//        test01();
        test02();
    }
}
