package com.young.iteration_template;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item>{
    // 在任意可迭代的集合数据类型中我们都需要实现的代码
        // 1）集合数据类型必须实现一个iterator()方法并返回一个Iterator对象。
        // 2）Iterator类必须包含两个方法：hasNext()（返回一个布尔值）和next()（返回集合中的一个泛型元素。
    private Item[] a; // stack entries
    private int N;  // size
    public ResizingArrayStack(int cap){
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

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove(){}
    }

    public static void main(String[] args) {
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
}
