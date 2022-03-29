package com.young.algorithm_exercise;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class AccumulatorExercise {
    // 累加器 抽象数据类型的实现
    private double total;
    private int N;
    public void addDataValue(double val){
        N++;
        total += val;
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
            AccumulatorExercise a = new AccumulatorExercise();
            for (int i = 0; i < T; i++) {
                a.addDataValue(StdRandom.uniform());
            }
            System.out.println("计算结果为： ");
            StdOut.println(a);
        }

    }
}
