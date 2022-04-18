package com.young.union_find_exercise;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class QuickFindExercise {
    // 将对象称为触点、将整数对称为连接，将等价类称为连通分量或是简称分量。
    private int[] id;   // 分量id（开始以触点作为索引），索引的值就是连通分量的标识符号，可以看作是一系列相连对象的集合叫做一个连通分量。
    private int count;  // 分量数量

    public QuickFindExercise(int N){
        // 初始化分量id数组，起始的分量标识符即为触点的索引
        this.count = N;
        this.id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count(){
        // 返回连通分量的数量
        return this.count;
    }

    public int find(int p){
        return id[p];
    }

    public boolean connected(int p, int q){
        // 判断整数对中整数p和整数q是否在同一个连通分量中，返回一个布尔值类型
        return find(p) == find(q);
    }

    public void union(int p, int q){
        // 将p和q归并到相同的分量中
        int pID = find(p);
        int qID = find(q);

        // 如果p和q已经在相同的分量之中则不需要采取任何行动
        if(pID == qID) return;

        // 将p的分量重命名为q的名称
        for (int i = 0; i < id.length; i++) {
            if(id[i] == pID) id[i] = qID;
        }
        // 连通了两个分量后，分量的数量需要减一
        count--;
    }

    public static String fPath(String fileName){
        String filePath = null;
        switch (fileName){
            case "tinyUF":
                filePath = "./resources/algs4_data/uf_data/tinyUF.txt";
                break;
            case "mediumUF":
                filePath = "./resources/algs4_data/uf_data/mediumUF.txt";
                break;
            case "largeUF":
                filePath = "./resources/algs4_data/uf_data/largeUF.txt";
                break;
            default:
                filePath = "-1";
                break;
        }
        return filePath;
    }

    public static void main(String[] args){
        // tinyUF中的数据含义：第一行为10个触点，其余行表示整数对连接。mediumUF和largeUF含义一样。
        // 测试文件：tinyUF、mediumUF、largeUF
        String fPath = fPath("tinyUF");
        if (fPath.equals("-1")){
            System.out.println("对不起，不存在测试数据文件！");
        }
        else{
            In in = new In(fPath);
            int N = in.readInt();
            QuickFindExercise quf = new QuickFindExercise(N);
            while(!in.isEmpty()){
                int p = in.readInt();
                int q = in.readInt();
                if(quf.connected(p, q)) continue;
                quf.union(p,q);
                StdOut.println(p + " " + q);
            }
            StdOut.println("components is : " + quf.count());
            in.close();
        }
    }
}
