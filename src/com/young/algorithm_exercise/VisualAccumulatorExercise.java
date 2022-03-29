package com.young.algorithm_exercise;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class VisualAccumulatorExercise {
    // 可视化累加器 抽象数据类型的实现
    private double total;
    private int N;

    public VisualAccumulatorExercise(int trials, double max){
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(0.005);
    }

    public void addDataValue(double val){
        N++;
        total += val;
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.point(N, val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(N, total/N);
    }

    public double mean(){
        return this.total/N;
    }

    @Override
    public String toString() {
        return "total=" + total + "\n" +
                "N=" + N + "\n" +
                "Mean( " + N + " values ): "
                + String.format("%7.5f", mean());
    }

    public static void main(String[] args) {
        System.out.println("请输入需要累加的数量： ");
        In in = new In();
        if(!in.isEmpty()){
            int T = in.readInt();
            VisualAccumulatorExercise a = new VisualAccumulatorExercise(T, 1.0);
            for (int i = 0; i < T; i++) {
                double data = StdRandom.uniform();
                System.out.println("这是第 " + i + " 个数据： " + data);
                a.addDataValue(data);
            }
            System.out.println("计算结果为： ");
            StdOut.println(a);
        }
    }
}
