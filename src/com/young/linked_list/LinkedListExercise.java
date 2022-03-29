package com.young.linked_list;

import edu.princeton.cs.algs4.StdOut;

public class LinkedListExercise<Item> {

    Node first = new Node();
    Node second = new Node();
    Node last = new Node();

    // 链表定义：链表是一种递归的数据结构，它或者为空（null），或者是指向一个结点（node）的引用，
    // 该结点含有一个泛型的元素和一个指向另一条链表的引用。
    private class Node{
        // 在面向对象的编程中，实现链表并不困难。我们首先用一个嵌套类来定义结点的抽象数据类型。
        // 结点记录：
        /*
        一个Node对象含有两个实例变量，类型分别为Item（参数类型）和Node。
        我们会在需要使用Node类的类中定义它并将它标记为private，因为它不是为用例准备的。
        和任意数据类型一样，我们通过new Node()触发（无参数的）构造函数来创建一个Node类型的对象。
        调用的结果是一个指向Node对象的引用，它的实例变量均被初始化为null。
        Item是一个占位符，表示我们希望用链表处理任意数据类型。（java泛型）
        Node类型的实例变量显示了这种数据结构的链式本质。
        为了强调我们在组织数据时只使用了Node类，我们没有定义任何方法且会在代码中直接引用实例变量。这种类型的类有时候也被称为记录。
         */
        Item item;
        Node next;
    }

    // 构造链表
    public void constructNode(Item i1, Item i2, Item i3){
        first.item = i1;
        second.item = i2;
        last.item = i3;
        first.next = second;
        second.next = last;
    }

    // 遍历链表
    public void bianLiLink(){
        for(Node x = first; x != null; x = x.next){
            // 处理链表，判断链表中间需要插入和删除的链表结点。
            StdOut.println(x.item);
        }
    }

    // 在表头插入结点
    public Item insertLinkHead(Item s){
        Node oldFirst = first;
        first = new Node();
        first.item = s;
        first.next = oldFirst;
        return s;
    }

    // 在表头删除结点，即删除链表的首结点
    public Item deleteLinkHead(){
        Item d = first.item;
        first = first.next;
        return d;
    }

    // 在表尾插入结点
    public Item insertLinkTail(Item s){
        Node oldLast = last;
        last = new Node();
        last.item = s;
        oldLast.next = last;
        return s;
    }

    // 删除表尾的结点需要知道表尾结点的上一个结点。（即其它位置的插入和删除操作）有两种方式可以解决。
        // 1、通过链表遍历的方式判断链表元素进行处理
        // 2、通过建立双向链表的方式处理。实现不难，在此不做练习。


    public static void main(String[] args) {
        LinkedListExercise<String> link = new LinkedListExercise<>();
        link.constructNode("to", "be", "or");
        String insertItemHead = link.insertLinkHead("not");
        StdOut.println("插入链表表头结点的元素是： " + insertItemHead);
        link.bianLiLink();
        String deleteItemHead = link.deleteLinkHead();
        StdOut.println("删除链表表头结点的元素是： " + deleteItemHead);
        link.bianLiLink();
        String insertItemLast = link.insertLinkTail("to");
        StdOut.println("插入链表尾部结点的元素是： " + insertItemLast);
        link.bianLiLink();
    }
}
