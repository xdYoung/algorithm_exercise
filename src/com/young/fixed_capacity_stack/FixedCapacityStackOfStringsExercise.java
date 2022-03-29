package com.young.fixed_capacity_stack;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import com.young.iteration_template.ResizingArrayStack;

import java.util.Iterator;

public class FixedCapacityStackOfStringsExercise {

    // 一种表示定容字符串栈的抽象数据类型
    public static class FixedCapacityStackOfStrings{
        private final String[] a; // stack entries
        private int N;  // size
        public FixedCapacityStackOfStrings(int cap){
            a = new String[cap];
        }
        public boolean isEmpty(){ return N == 0; }
        public int size(){ return N; }
        public void push(String item){ a[N++] = item; }
        public String pop(){ return a[--N]; }
    }

    public void test01(){
        // 测试：to be or not to - be - - that - - - is
        StdOut.print("请输入定容栈字符串的容量： ");
        In in = new In();
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(in.readInt());
        StdOut.println("请输入存入栈中的字符串：");
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-")) s.push(item);
            else if(!s.isEmpty()) StdOut.println(s.pop() + "");
        }
        StdOut.println("( " + s.size() + " string item left on the stack.)");
        // StdOut.println(s.pop());
        // StdOut.println(s.pop());
        StdOut.println("在栈中的元素是：");
        int N = s.size();
        for (int i = 0; i < N; i++) {
            StdOut.println(s.pop());
        }
    }

    // ----------------------------------------------------------------------------------

    // 用泛型实现定容栈的抽象数据类型，支持多个数据类型。
    public static class FixedCapacityStack<Item>{
        private final Item[] a; // stack entries
        private int N;  // size
        public FixedCapacityStack(int cap){
            a = (Item[]) new Object[cap];
        }
        public boolean isEmpty(){ return N == 0; }
        public int size(){ return N; }
        public void push(Item item){ a[N++] = item; }
        public Item pop(){ return a[--N]; }
    }

    public void test02(){
        StdOut.print("请输入定容栈字符串的容量： ");
        In in = new In();
        FixedCapacityStack<Double> s = new FixedCapacityStack<>(in.readInt());
        StdOut.println("请输入存入栈中的字符串：");
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-")) s.push(Double.parseDouble(item));
            else if(!s.isEmpty()) StdOut.println(s.pop() + "");
        }
        StdOut.println("( " + s.size() + " string item left on the stack.)");
        // StdOut.println(s.pop());
        // StdOut.println(s.pop());
        StdOut.println("在栈中的元素是：");
        int N = s.size();
        for (int i = 0; i < N; i++) {
            StdOut.println(s.pop());
        }
    }

    // ----------------------------------------------------------------------------------

    // 调整数组的大小
    public static class FixedCapacityStackResize<Item>{
        private Item[] a; // stack entries
        private int N;  // size
        public FixedCapacityStackResize(int cap){
            a = (Item[]) new Object[cap];
        }
        // 首先，实现一个方法将栈移动到另一个大小不同的数组中.
        public void resize(int max){
            // 将大小为 N <= max 的栈移动到另一个新的大小为max的数组中
            Item[] temp = (Item[]) new Object[max];
            for (int i = 0; i < N; i++) {
                temp[i] = a[i];
            }
            a = temp;
        }
        public boolean isEmpty(){ return N == 0; }
        public int size(){ return N; }
        public int arraySize(){ return a.length; }
        // 在push()中检查数组是否太小。具体来说，我们会通过检查栈大小N和数组大小a.length是否相等来检查数组是否能够容纳新的元素。
        // 如果没有多余的空间，我们会将数组的长度加倍。
        public void push(Item item){
            if(N == a.length) resize(2*a.length);
            a[N++] = item;
        }
        // 在pop()中，首先删除栈顶元素，如果数组太大我们就将它的长度减半。正确的检测条件是栈大小是否小于数组的四分之一。
        // 如果栈的大小小于数组的四分之一，在数组长度被减半之后，栈的状态约为半满。
        public Item pop(){
            Item item;
            if(N == 0) {
                StdOut.println("栈为空，不可以删除元素!");
                return null;
            }else{
                item = a[--N];
                a[N] = null;    // 避免对象游离，当数组中的元素称为孤儿元素了以后，需置空以让系统垃圾回收。
            }
            if(N > 0 && N == a.length/4) resize(a.length/2);
            return item;
        }
    }

    public void test03(){
        StdOut.print("请输入定容栈字符串的容量： ");
        In in = new In();
        FixedCapacityStackResize<Double> s = new FixedCapacityStackResize<>(in.readInt());
        StdOut.println("请输入存入栈中的字符串：");
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-")) s.push(Double.parseDouble(item));
            else if(!s.isEmpty()) StdOut.println(s.pop() + "");
        }
        StdOut.println("( " + s.size() + " item left on the stack.)");
        StdOut.println(s.pop());
        StdOut.println("Stack_array_size: " + s.arraySize());
        StdOut.println("Stack_size: " + s.size());
        // StdOut.println(s.pop());
    }

    // ----------------------------------------------------------------------------------

    public void test04(){
        StdOut.print("请输入定容栈字符串的容量： ");
        In in = new In();
        ResizingArrayStack<String> s = new ResizingArrayStack<>(in.readInt());
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            s.push(item);
        }
        StdOut.println("字符串栈的大小为： " + s.size());
        StdOut.println("栈中数组的大小为： " + s.arraySize());
        // 迭代遍历的第一种方式：foreach遍历，其实就是while循环的一种简写形式。
        for (String str1: s) {
            StdOut.print(str1 + " ");
        }
        StdOut.println();
        StdOut.println("字符串栈的大小为： " + s.size());
        StdOut.println("栈中数组的大小为： " + s.arraySize());
        // 迭代遍历的第二种方式：
        Iterator<String> str2 = s.iterator();
        while(str2.hasNext()){
            StdOut.print(str2.next() + " ");
        }
    }

    // ----------------------------------------------------------------------------------

    public static void main(String[] args) {
//        new FixedCapacityStackOfStringsExercise().test01();
//        new FixedCapacityStackOfStringsExercise().test02();
//        new FixedCapacityStackOfStringsExercise().test03();
        new FixedCapacityStackOfStringsExercise().test04();
    }

}
