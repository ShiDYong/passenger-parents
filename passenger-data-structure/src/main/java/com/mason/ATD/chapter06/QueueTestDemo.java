package com.mason.ATD.chapter06;

/**
 * 队列的实现类的测试方法
 *
 * @author ShiYong
 * @create 2022-04-08 11:16
 **/
public class QueueTestDemo {
    public static void main(String[] args) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>测试队链表实现的队列>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        LinkedQueue<String> linkedQueue = new LinkedQueue<>();
        linkedQueue.enqueue("Java");
        linkedQueue.enqueue("Python");
        linkedQueue.enqueue("Python");
        String front = linkedQueue.getFront();
        System.out.println("获取队列的头部元素：" + front);
        String dequeue = linkedQueue.dequeue();
        System.out.println("删除队列的元素：" + dequeue);
        System.out.println(linkedQueue.isEmpty());
        //清空队列
        linkedQueue.clear();
        //  System.out.println(linkedQueue.getFront());
        System.out.println("<<<<<<<<<<<<<<<<<<<<测试队列通过数组实现>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        ArrayQueue<String> arrayQueue = new ArrayQueue<>();
        arrayQueue.enqueue("BMW");
        arrayQueue.enqueue("Toyota");
        for (int indes = 0; indes < 9; indes++) {
            arrayQueue.enqueue("Tank");

        }
        String delete = arrayQueue.dequeue();
        System.out.println("队列的删除头结点："+delete);
        String front1 = arrayQueue.getFront();
        System.out.println("获取队列的头结点："+front1);
        System.out.println(arrayQueue.isEmpty());
        arrayQueue.clear();



    }
}
