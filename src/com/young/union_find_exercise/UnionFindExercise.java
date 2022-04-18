package com.young.union_find_exercise;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

public class UnionFindExercise {
    public static void main(String[] args) {
        In in = new In("./resources/algs4_data/uf_data/tinyUF.txt");
        int N = in.readInt();
        UF uf = new UF(N);
        while(!in.isEmpty()){
            int p = in.readInt();
            int q = in.readInt();
            if(uf.connected(p, q)) continue;
            uf.union(p,q);
            StdOut.println(p + " " + q);
        }
        StdOut.println("components is : " + uf.count());
        in.close();
    }
}
