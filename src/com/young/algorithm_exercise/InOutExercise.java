package com.young.algorithm_exercise;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

public class InOutExercise {
    public static void main(String[] args) {
        Out out = new Out("./resources/files/out.text");
        for (int i = 0; i < 3; i++) {
            if(i == 0){
                In in = new In("./resources/files/a.txt");
                String s = in.readAll();
                out.println(s);
                in.close();
            }
            if(i == 1){
                In in = new In("./resources/files/b.txt");
                String s = in.readAll();
                out.println(s);
                in.close();
            }
            if(i == 2){
                System.out.println("请输入文本：");
                In in = new In();
                if(!in.isEmpty()){
                    System.out.println("输入结束！");
                    String s = in.readString();
                    out.println(s);
                    in.close();
                }
            }

        }
        out.close();
    }
}
