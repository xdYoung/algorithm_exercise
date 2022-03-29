package com.young.algorithm_exercise;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BagExercise {
    // bag背包数据类型的用例，背包是可迭代的集合数据类型。
    public static void main(String[] args) {
        // 泛型：类型参数化，即类模版编程。
        Bag<Double> numbers = new Bag<>();
        // algs4库的Stdin类输入结束，windows按ctrl + d结束，mac按command + d结束输入。
        while (!StdIn.isEmpty()){
            numbers.add(StdIn.readDouble());
        }
        int N = numbers.size();

        double sum = 0.0;
        for(double x: numbers){
            sum += x;
        }
        double mean = sum/N;

        sum = 0.0;
        for(double x: numbers){
            sum += (x - mean)*(x - mean);
        }
        double std = Math.sqrt(sum/N-1);

        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}
