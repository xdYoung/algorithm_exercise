package com.young.linked_list;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class LinkedListBag<Item> implements Iterable<Item> {
    // 链表实现背包的抽象数据结构
    private Node first; // 链表的首结点
    private int N;

    private class Node{
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
    
    public boolean isEmpty(){ return first == null; }   // 或： N == 0
    public int size(){ return N; }
    public Item add(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListBagIterator();
    }
    
    private class LinkedListBagIterator implements Iterator<Item>{
        
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
        LinkedListBag<String> bag = new LinkedListBag<>();
        System.out.println("初始化链表实现的背包对象后背包对象为： " + (bag.isEmpty()?"空":"不为空"));
        // 向背包中添加元素
        while(!StdIn.isEmpty()){
            bag.add(StdIn.readString());
        }
        // 背包大小
        StdOut.println("添加元素后背包大小为： " + bag.size());
        // 背包中链表的大小
        StdOut.println("添加元素后背包中链表的大小为： " + bag.linkedListSize());
        // 遍历背包
        StdOut.println("遍历背包中的元素：（遵循 LIFO 后进先出）");
        for(String s: bag){
            StdOut.print(s + " ");
        }
        StdOut.println("\n--------------------------------------------------------------------------");
    }
}
