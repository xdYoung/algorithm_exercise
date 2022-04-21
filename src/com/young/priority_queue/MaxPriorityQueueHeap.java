package com.young.priority_queue;

import edu.princeton.cs.algs4.*;

public class MaxPriorityQueueHeap<Key extends Comparable<Key>> {
    // 基于堆有序实现的最大优先队列
    private Key[] pq;   // 优先队列由一个基于堆heap的完全二叉树表示，存储于数组pq[1..N]中，pq[0]没有使用，从下标为1开始。
    private int N = 0;

    public MaxPriorityQueueHeap(int maxN){
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty(){ return N == 0; }

    public int size(){ return N; }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key delMax(){
        Key max = pq[1];    // 从根结点得到最大元素
        exch(1, N--);       // 将其和最后一个结点交换，交换后并将队列大小减1
        pq[N+1] = null;     // 将交换后的最后一个元素置空，防止对象游离
        sink(1);            // 恢复堆的有序性
        return max;
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j){
        Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;
    }

    private void swim(int k){
        while (k>1 && less(k/2, k)){
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k){
        while (2*k <= N){
            int j = 2*k;
            if(j < N && less(j, j+1)) j++;
            if(!less(k, j)) break;
            exch(k,j);
            k = j;
        }
    }

    public static void main(String[] args) {
        StdOut.print("请输入优先队列的大小： ");
        int M = StdIn.readInt();
        MaxPriorityQueueHeap<Transaction> pq = new MaxPriorityQueueHeap<>(M+1);
        In in = new In("./resources/algs4_data/priority_queue_data/tinyBatch.txt");
        while (in.hasNextLine()){
            // 为下一行输入创建一个元素并放入优先队列中
            Transaction t = new Transaction(in.readLine());
            pq.insert(t);
            StdOut.println(t);
            if(pq.size() > M){
                pq.delMax(); // 如果优先队列中存在M+1个元素则删除其中最大的元素
            }
        }// 最小的M个元素都在优先队列中
        StdOut.println("筛选出来的最小的 "+ M + " 个Transaction" + "********************");
        Stack<Transaction> stack = new Stack<>();
        while(!pq.isEmpty()) stack.push(pq.delMax());
        for(Transaction t: stack) StdOut.println(t);
        in.close();
    }
}
