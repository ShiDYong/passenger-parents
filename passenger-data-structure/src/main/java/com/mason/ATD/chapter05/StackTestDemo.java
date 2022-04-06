package com.mason.ATD.chapter05;

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
        arrayStack.push("广州");
        arrayStack.push("上海");
        arrayStack.push("北京");
        arrayStack.push("北京");
        arrayStack.push("北京");
        arrayStack.push("北京");
        arrayStack.push("北京");
        arrayStack.push("北京");
        arrayStack.push("北京");
        arrayStack.push("北京");
        arrayStack.push("北京");

    }
}
