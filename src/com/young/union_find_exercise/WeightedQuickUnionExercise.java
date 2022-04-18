package com.young.union_find_exercise;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionExercise {
    private int[] id;   // 父连接数组（由触点索引）
    private int[] sz;   // （由触点索引的）各个根节点所对应的分量的大小
    private int count;  // 连通分量的数量

    public WeightedQuickUnionExercise(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }

    public int count(){ return count; }

    public int find(int p){
        // 寻找传入节点的根节点
        while(p != id[p]) p = id[p];
        return p;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public void union(int p, int q){
        // 找到p和q的根节点
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;
        // 将小树的根节点连接到大树的根节点
        if(sz[pRoot] < sz[qRoot]){
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else{
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
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
        String fPath = fPath("mediumUF");
        if (fPath.equals("-1")){
            System.out.println("对不起，不存在测试数据文件！");
        }
        else{
//            StdDraw.setXscale(-1, 25);
//            StdDraw.setYscale(-1, 25);
//            StdDraw.setPenColor(StdDraw.BLACK);

            In in = new In(fPath);
            int N = in.readInt();
            WeightedQuickUnionExercise wquUF = new WeightedQuickUnionExercise(N);
            while(!in.isEmpty()){
                int p = in.readInt();
                int q = in.readInt();
//                StdDraw.setPenRadius(.005);
//                StdDraw.point(p%25,p/25);
//                StdDraw.point(q%25,q/25);
                if(wquUF.connected(p, q)) continue;
                wquUF.union(p,q);
                StdOut.println(p + " " + q);
//                StdDraw.setPenRadius(.001);
//                StdDraw.line(p%25, p/25, q%25, q/25);
            }
            StdOut.println("components is : " + wquUF.count());
            in.close();
        }
    }
}
