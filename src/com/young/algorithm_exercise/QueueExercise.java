package com.young.algorithm_exercise;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class QueueExercise {
    // 队列Queue数据类型：遵循FIFO（First In First Out 先进先出），队列也是可迭代的集合数据类型
    // 当用例使用foreach语句迭代访问队列中的元素时，元素的处理顺序就是它们被添加到队列中的顺序。
    // 在应用程序中使用队列的主要原因是在用集合保存元素的同时保存它们的相对顺序：使它们入列顺序和出列顺序相同。
    // 如果处理数据的顺序不重要，也可以诶使用Bag对象。

    public static int[] readInts(String name){
        In in = new In(name);
        Queue<Integer> q = new Queue<>();
        while (!in.isEmpty()){
            // 命令行读取int类型的原始类型数据后自动装箱至原始int数据类型的封装数据类型Integer中。
            q.enqueue(in.readInt());
        }
        int N = q.size();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            // 队列中的Integer封装数据类型按顺序被移出队列后自动拆箱编程int原始数据类型。
            a[i] = q.dequeue();
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = QueueExercise.readInts("./resources/algs4_data/1Kints.txt");
        StdOut.println(a.length);
        for (int i = 0; i < 20; i++) {
            StdOut.println("数组中的第" + (i+1) + "个数字： " + a[i]);
        }
    }
}
