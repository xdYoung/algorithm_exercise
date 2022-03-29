package com.young.algorithm_exercise;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackExercise {
    // 下压栈（或简称栈）是一种基于后进先出（LIFO：Last In First Out）策略的集合类型。栈也是迭代的集合数据类型。
    // 当用例使用foreach语句迭代遍历栈中的元素时，元素的处理顺序和它们被压入的顺序正好相反。
    // 在应用程序中使用栈迭代器的一个典型原因是在用集合保存元素的同时颠倒它们的相对顺序。
    public static class Reverse{
        public static void stackReverse(){
            Stack<Integer> stack = new Stack<>();
            while(!StdIn.isEmpty()){
                stack.push(StdIn.readInt());
            }

            for(int i: stack){
                StdOut.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Reverse.stackReverse();
    }
}
