package com.young.Dijkstra_algorithm;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DijkstraExercise {
    /*
    E.W.Dijkstra在20世纪60年代发明了一个简单的算法，
    用两个栈（一个用于保存运算符，一个用于保存操作数）实现了一个计算算数表达式的解释器。
    表达式由括号、运算符和操作数（数字）组成，根据以下4中情况从左到右逐个将这些实体送入栈处理
    1、将操作数压入操作数栈；
    2、将运算符压入运算符栈；
    3、忽略左括号；
    4、在遇到右括号时，弹出一个运算符，弹出所需数量的操作数，并将运算符和操作数的运算结果压入操作数栈。
     */
    public static class DijkstraEvaluate{
        public static void Evaluate(){
            Stack<String> ops = new Stack<>();
            Stack<Double> vals = new Stack<>();
            while(!StdIn.isEmpty()){
                // 读取字符，如果是运算符则压入栈
                String s = StdIn.readString();
                if(s.equals("(")) ;
                else if(s.equals("+")) ops.push(s);
                else if(s.equals("-")) ops.push(s);
                else if(s.equals("*")) ops.push(s);
                else if(s.equals("/")) ops.push(s);
                else if(s.equals("sqrt")) ops.push(s);
                else if(s.equals(")")){
                    // 如果字符为"）"，弹出运算符和操作数，计算结果并压入栈。
                    String op = ops.pop();
                    double v = vals.pop();
                    if(op.equals("+")) v = vals.pop() + v;
                    else if(op.equals("-")) v = vals.pop() - v;
                    else if(op.equals("*")) v = vals.pop() * v;
                    else if(op.equals("/")) v = vals.pop() / v;
                    else if(op.equals("sqrt")) v = Math.sqrt(v);
                    vals.push(v);
                }
                // 如果字符既非运算符也不是括号，将它作为double值压入栈
                else vals.push(Double.parseDouble(s));
            }
            StdOut.println("表达式的计算结果为：" + vals.pop());
        }
    }

    public static void main(String[] args) {
        // 简单起见，这段实现代码没有处理任何省略的括号，所以括号要写全。
        // 在输入表达式的时候需要以空格作为分隔符，读取字符时按空格分割读取，不然读取并解析字符时报错。
        // 测试：( ( 1 + sqrt ( 5.0 ) ) / 2.0 ) 和 ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
        // 算术表达式的解析器更为复杂的判断可以不断的练习。
        DijkstraEvaluate.Evaluate();
    }
}
