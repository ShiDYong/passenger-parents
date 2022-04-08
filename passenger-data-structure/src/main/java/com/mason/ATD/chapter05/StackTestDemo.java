package com.mason.ATD.chapter05;

import java.util.Stack;

/**
 * 栈的测试类
 *
 * @author ShiYong
 * @create 2022-04-06 16:31
 **/
public class StackTestDemo {
    public static void main(String[] args) {

        System.out.println("、、、、、、、、、、、、、测试链表实现的栈。。。。。。。。。。。。。。。。。。。。。。");
        LinkedStack<String> linkedStack = new LinkedStack<>();
        //push方法
        linkedStack.push("小花");
        linkedStack.push("小明");
        linkedStack.push("小桃");

        //3.获取栈顶元素方法测试
        linkedStack.peek();
        //2.出栈方法
        linkedStack.pop();
        linkedStack.pop();
        linkedStack.pop();
        System.out.println(".......................测试数组实现的栈...................................................");
        ArrayStack<String> arrayStack = new ArrayStack<>();
        //3.测试扩容方法
        for (int index = 0; index < 50; index++) {
            arrayStack.push("广州");

        }
        arrayStack.push("广州");
        //4.测试获取栈顶元素
        System.out.println("arrayStack.pop() = " + arrayStack.pop());

        //3.清空栈方法的测试
        arrayStack.clear();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>测试通过vector实现stack>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        VectorStack<String> vectorStack = new VectorStack<>();
        vectorStack.push("数学");
        vectorStack.push("英语");
        vectorStack.push("计算机");
        vectorStack.push("物理");
        System.out.println("测试vectorStack的添加操作：" + vectorStack);

        //2.测试获取栈顶元素的方法
        System.out.println("获取栈顶元素 " + vectorStack.peek());

        //3.出栈操作的方法测试
        String pop = vectorStack.pop();

        //4.进行清除栈顶元素的操作
        vectorStack.clear();


        System.out.println("<<<<<<<<<<<<<<<<<<<<<<Jdk中的实现方案测试<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        Stack<String> myStack = new Stack<>();
        myStack.push("Java");
        myStack.push("C/C++");
        System.out.println("JDK中栈获取元素的方法：" + myStack.peek());
        System.out.println(myStack.empty());
        int resutl = myStack.search("Java");
        System.out.println("resutl = " + resutl);


    }
}
