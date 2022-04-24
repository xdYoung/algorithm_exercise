package com.young.search_algorithm.symbol_table;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SymbolTableExample {
    public static void main(String[] args) {
        ST<String, Integer> st;
        st = new ST<>();
        StdOut.print("请输入字符串，并以空格分割，以Cril+d结束： \n");
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        for(String k: st.keys()){
            StdOut.println("key: " + k + " " + "value: " + st.get(k));
        }
    }
}
