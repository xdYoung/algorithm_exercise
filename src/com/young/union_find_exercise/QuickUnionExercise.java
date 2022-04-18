package com.young.union_find_exercise;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

public class QuickUnionExercise {
    // 此为quick-union的实现
    private int[] id;   // 仍然是定义了一个起始以触点为索引的id[]，但是id[]表示的元素不是连通分量，而是另外一个触点
    private int count;  // 仍表示的是触点的数量

    public QuickUnionExercise(int N){
        // 初始化的分量数量为N
        this.count = N;
        // 初始化的id[]元素是以触点为索引
        this.id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count(){
        return this.count;
    }

    public int find(int p){
        // quick-union中的id[]元素表示的不是连通分量，而是另一个触点的名称，这样一个找一个，直到找到根触点形成一个树的结构
        while (p != id[p]) p = id[p];
        return p;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;
        id[pRoot] = qRoot;
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
            StdDraw.setXscale(-1, 25);
            StdDraw.setYscale(-1, 25);
            StdDraw.setPenColor(StdDraw.BLACK);

            In in = new In(fPath);
            int N = in.readInt();
            QuickUnionExercise quUF = new QuickUnionExercise(N);
            while(!in.isEmpty()){
                int p = in.readInt();
                int q = in.readInt();
//                StdDraw.setPenRadius(.005);
//                StdDraw.point(p%25,p/25);
//                StdDraw.point(q%25,q/25);
                if(quUF.connected(p, q)) continue;
                quUF.union(p,q);
                StdOut.println(p + " " + q);
//                StdDraw.setPenRadius(.001);
                StdDraw.line(p%25, p/25, q%25, q/25);
            }
            StdOut.println("components is : " + quUF.count());
            in.close();
        }
    }
}
