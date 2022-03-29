package com.young.linked_list;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class LinkedListQueue<Item> implements Iterable<Item> {

    // 用链表实现队列：FIFO（First In First Out 先进先出）
    private Node first; // 指向最早添加的结点的链接
    private Node last;  // 指向最近添加的结点的链接
    private int N;  // 队列中的元素数量
    
    private class Node{
        // 定义了结点的嵌套类
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
    public Item enqueue(Item item){
        // 向表尾添加元素
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldLast.next = last;
        N++;
        return item;
    }
    public Item dequeue(){
        // 从表头删除元素
        Item item;
        if(isEmpty()){
            System.out.println("队列中没有元素可以删除！");
            item = null;
        }else{
            item = first.item;
            first = first.next;
            N--;
        }
        return item;
    }
    
    @Override
    public Iterator<Item> iterator() {
        return new linkedListQueueIterator();
    }
    
    public class linkedListQueueIterator implements Iterator<Item>{
        
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
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        System.out.println("初始化链表实现的队列对象后队列对象为： " + (queue.isEmpty()?"空":"不为空"));
        // 向队列中添加元素
        while(!StdIn.isEmpty()){
            queue.enqueue(StdIn.readString());
        }
        // 队列大小
        StdOut.println("添加元素后队列大小为： " + queue.size());
        // 队列中链表的大小
        StdOut.println("添加元素后队列中链表的大小为： " + queue.linkedListSize());
        // 遍历队列
        StdOut.println("遍历队列中的元素：（遵循 FIFO 先进先出）");
        for(String s: queue){
            StdOut.print(s + " ");
        }
        StdOut.println("\n--------------------------------------------------------------------------");

        // 删除队列中的第一个队列顶元素
        StdOut.println("删除队列的第一个元素为： " + queue.dequeue());
        // 删除第一个队列顶元素后队列大小
        StdOut.println("删除第一个队列元素后队列大小为： " + queue.size());
        // 删除第一个队列顶元素后队列中链表的大小
        StdOut.println("删除第一个队列元素后队列中链表的大小为： " + queue.linkedListSize());

        StdOut.println("--------------------------------------------------------------------------");

        // 删除队列中的第二个队列顶元素
        StdOut.println("删除队列的第二个元素为： " + queue.dequeue());
        // 删除第二个队列顶元素后队列大小
        StdOut.println("删除第二个队列元素后队列大小为： " + queue.size());
        // 删除第二个队列顶元素后队列中链表的大小
        StdOut.println("删除第二个队列元素后队列中链表的大小为： " + queue.linkedListSize());

    }
}
