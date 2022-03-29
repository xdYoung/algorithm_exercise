package com.young.linked_list;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class LinkedListStack<Item> implements Iterable<Item> {
    // 下压堆栈（链表实现）：通过链表头结点指向栈顶进行增删操作，可以实现栈的LIFO（后进先出）操作。
    // 用链表实现栈功能的优点：
        // 1、所需的空间总是和集合的大小成正比
        // 2、操作所需的时间总是和集合的大小无关，因为只用操作栈顶元素的增加和删除操作。

    private Node first; // 栈顶（最近添加的元素)
    private int N;  // 元素数量

    private class Node{
        // 定义了结点内部类，因为结点内部类为栈类所使用，所以定义成内部类。
        Item item;
        Node next;
    }

    public int linkedListSize(){
        int count = 0;
        // 堆栈中的链表进行遍历
        for (Node x = first; x != null; x = x.next){
            count++;
        }
        return count;
    }

    public boolean isEmpty(){ return first == null; }   // 或：N == 0
    public int size(){ return N; }
    public void push(Item item){
        // 向栈顶添加元素
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public Item pop(){
        // 从栈顶删除元素
        Item item;
        if(N == 0) {
            System.out.println("栈中没有元素可以删除了！");
            item = null;
        }
        else{
            item = first.item;
            first = first.next;
            N--;
        }
        return item;
    }

    // 实现迭代的方法模版
    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }
    private class LinkedListIterator implements Iterator<Item>{

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        LinkedListStack<String> stack = new LinkedListStack<>();
        System.out.println("初始化链表实现的栈对象后栈对象为： " + (stack.isEmpty()?"空":"不为空"));
        // 向栈中添加元素
        while(!StdIn.isEmpty()){
            stack.push(StdIn.readString());
        }
        // 栈大小
        StdOut.println("添加元素后栈大小为： " + stack.size());
        // 栈中链表的大小
        StdOut.println("添加元素后栈中链表的大小为： " + stack.linkedListSize());
        // 遍历栈
        StdOut.println("遍历栈中的元素：（遵循 LIFO 后进先出）");
        for(String s: stack){
            StdOut.print(s + " ");
        }
        StdOut.println("\n--------------------------------------------------------------------------");

        // 删除栈中的第一个栈顶元素
        StdOut.println("删除栈顶的第一个元素为： " + stack.pop());
        // 删除第一个栈顶元素后栈大小
        StdOut.println("删除第一个栈顶元素后栈大小为： " + stack.size());
        // 删除第一个栈顶元素后栈中链表的大小
        StdOut.println("删除第一个栈顶元素后栈中链表的大小为： " + stack.linkedListSize());

        StdOut.println("--------------------------------------------------------------------------");

        // 删除栈中的第二个栈顶元素
        StdOut.println("删除栈顶的第二个元素为： " + stack.pop());
        // 删除第二个栈顶元素后栈大小
        StdOut.println("删除第二个栈顶元素后栈大小为： " + stack.size());
        // 删除第二个栈顶元素后栈中链表的大小
        StdOut.println("删除第二个栈顶元素后栈中链表的大小为： " + stack.linkedListSize());

    }
}
