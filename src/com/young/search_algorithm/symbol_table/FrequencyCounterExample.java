package com.young.search_algorithm.symbol_table;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounterExample {

    public static String getPath(String fileName){
        return "./resources/algs4_data/search_data/" + fileName + ".txt";
    }

    public static void main(String[] args) {
        StdOut.print("请输入要统计的最小键长minlen： ");
        int minlen = StdIn.readInt();
        StdOut.print("请输入文件名： ");
        String fPath = StdIn.readString();
        ST<String, Integer> st = new ST<>();
        In in = new In(getPath(fPath));

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
}
