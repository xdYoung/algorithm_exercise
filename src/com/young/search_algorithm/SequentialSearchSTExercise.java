package com.young.search_algorithm;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class SequentialSearchSTExercise<Key, Value> implements Iterable<Key>{
    // 基于无序链表的顺序查找（sequential：顺序的，连续的）
    private Node first; // 链表首结点

    private class Node{
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key){
        // 查找给定的键，返回相关键的值
        for (Node x = first; x != null; x = x.next){
            if(x.key.equals(key)) return x.val; // 命中，赋值
        }
        return null;    // 未命中
    }

    public void put(Key key, Value val){
        // 查找给定的键，找到时更新其值，否则在表中新建结点
        for(Node x = first; x != null; x = x.next){
            if(x.key.equals(key)) {x.val = val; return;}    // 命中，更新
        }
        first = new Node(key, val, first);  // 未命中，新建结点
    }

    public boolean contains(Key key){
        // 查找顺序符号表中是否存在key，是返回true，否返回false
        for(Node x = first; x != null; x = x.next){
            if(x.key.equals(key)) return true;
        }
        return false;
    }

    public Iterable<Key> keys(){
        return this;
    }

    @Override
    public Iterator<Key> iterator() {
        return new SequentialSearchSTIterator();
    }

    public class SequentialSearchSTIterator implements Iterator<Key>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Key next() {
            Key item = current.key;
            current = current.next;
            return item;
        }
    }

    public static void frequencyCounterTest(){
        StdOut.print("请输入要统计的最小键长minlen： ");
        int minlen = StdIn.readInt();
        StdOut.print("请输入文件名： ");
        String fPath = StdIn.readString();
        fPath = "./resources/algs4_data/search_data/" + fPath + ".txt";
        SequentialSearchSTExercise<String, Integer> st = new SequentialSearchSTExercise<>();
        In in = new In(fPath);

        while(!in.isEmpty()){
            // 构造符号表并统计频率
            String word = in.readString();
            if(word.length() < minlen) continue;    // 忽略较短的单词
            if(!st.contains(word)) st.put(word, 1);
            else    st.put(word, st.get(word) + 1);
        }

        // 找出出现频率最高的单词
        String max = "";
        st.put(max, 0);
        for(String word: st.keys()){
            if(st.get(word) > st.get(max)){
                max = word;
            }
        }
        StdOut.println("统计最小单词的键长为： " + minlen + "\n频率出现最高的单词为： " + max + "\n出现的频次为: " + st.get(max));

    }

    public static void main(String[] args) {
        frequencyCounterTest();
    }
}
