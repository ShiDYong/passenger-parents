package com.mason.ATD.chapter06;

import java.util.EmptyStackException;

/**
 * ADT队列链式实现的框架
 * A class that implements a queue of objects by using
 * a chain of linked nodes.
 *
 * @author ShiYong
 * @create 2022-04-08 10:24
 **/
public class LinkedQueue<T> implements QueueInterface<T> {
    private Node firstNode; //Reference node at front of queueu
    private Node lastNode; //Reference node at back of queue

    public LinkedQueue() {
        firstNode = null;
        lastNode = null;
    }

    /**
     * Adds an new entry to the back of this queue
     *
     * @param newEntry An object to be added.
     *
     *  为什么要用尾引用？？？
     *   参考：队尾在链表表尾。因为你在队尾添加，所以必须将一个结点链接在链表表尾。尾引用能
     *        让你做到这一点，而不需要先遍历链表找到最后一个结点，所以尾引用能让enqueue操作
     *        更高效。记住尾引用相当变量指针，只是存储尾结点的内存地址。
     *
     */
    @Override
    public void enqueue(T newEntry) {
        //实例化一个新结点
        Node newNode = new Node(newEntry, null);
        //判断当前队列是否为空
        if (isEmpty())
            //队头项指向新结点
            firstNode = newNode;
        else
            //将链尾下项一个引用指向新结点
            lastNode.setNextNode(newNode);
        //将队尾项指向新结点
        lastNode = newNode;


    }

    @Override
    public T dequeue() {
        T front = getFront();
        //设置数据为Null,方便垃圾回收
        firstNode.setData(null);
        //将firstNode指向链表的第二个结点，从而删除链表的首结点
        firstNode = firstNode.getNextNode();
        //如果链表仅含有一个结点，将firstNode和lastNode都置为空
        if (firstNode == null)
            lastNode = null;
        return front;
    }

    /**
     * Removes the entry at the front of this queue.
     *
     * @return The objcect at the front of the queue.
     * @trows EmptyQueueException if the queue is empty.
     */
    @Override
    public T getFront() {
        if (isEmpty())
            throw new EmptyQueueException();
        else
            return firstNode.getData();
    }


    /**
     * Deteccts whether this queue is empty.
     *
     * @return True if the queue is empty, or false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    }


    /**
     * Removes all entries from this queue.
     */
    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
    }


    private class Node {
        private T data;  //Entry in queue
        private Node next; //link to next queue

        public Node(T dataPortion) {
            this(dataPortion, null);
        }

        public Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNextNode() {
            return next;
        }

        public void setNextNode(Node  next) {
            this.next = next;
        }
    }
}
