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
        System.out.println("队列的删除头结点：" + delete);
        String front1 = arrayQueue.getFront();
        System.out.println("获取队列的头结点：" + front1);
        System.out.println(arrayQueue.isEmpty());
        arrayQueue.clear();


        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>测试通过单项循环列表实现的队列<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        TwoPartCircularLinkedQueue<String> circularLinkedQueue = new TwoPartCircularLinkedQueue<>();
        circularLinkedQueue.enqueue("BMW");
        circularLinkedQueue.enqueue("Toyota");
        System.out.println(circularLinkedQueue.getFront());
        System.out.println(circularLinkedQueue.dequeue());
        System.out.println(circularLinkedQueue.isEmpty());
        circularLinkedQueue.clear();
        System.out.println(circularLinkedQueue);


        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>测试通过双向循环列表实现的双端队列<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        LinkedDeque<String> deque = new LinkedDeque<>();
        deque.addToFront("北京市");
        deque.addToBack("上海市");
        deque.addToBack("深圳市");
        deque.addToBack("广州市");
        System.out.println(deque.getBack());
        System.out.println(deque.getFront());
        System.out.println(deque.removeBack());
        System.out.println(deque.removeFront());
        System.out.println(deque.isEmpty());
        deque.clear();
        deque.addToBack(null);
        System.out.println(deque.getBack());


    }
}
