package com.young.priority_queue;

import edu.princeton.cs.algs4.*;

public class PQCase {
    // 找出最大的topM个数，并排序
    public static void main(String[] args) {
        StdOut.print("请输入优先队列的大小： ");
        int M = StdIn.readInt();
        MinPQ<Transaction> pq = new MinPQ<>(M+1);
        In in = new In("./resources/algs4_data/priority_queue_data/tinyBatch.txt");
        while (in.hasNextLine()){
            // 为下一行输入创建一个元素并放入优先队列中
            Transaction t = new Transaction(in.readLine());
            pq.insert(t);
            StdOut.println(t);
            if(pq.size() > M){
                pq.delMin(); // 如果优先队列中存在M+1个元素则删除其中最小的元素
            }
        }// 最大的M个元素都在优先队列中
        StdOut.println("筛选出来的最大的 "+ M + " 个Transaction" + "********************");
        Stack<Transaction> stack = new Stack<>();
        while(!pq.isEmpty()) stack.push(pq.delMin());
        for(Transaction t: stack) StdOut.println(t);
        in.close();
    }
}
