package com.mason.ATD.chapter06;

import com.mason.ATD.chapter02.ResizableArrayBag;
import org.w3c.dom.Node;

import java.util.EmptyStackException;

/**
 * 单循环链表组成的队列
 * A class implements a queue of object by using
 *
 * @author ShiYong
 * @create 2022-04-08 16:35
 **/
public class TwoPartCircularLinkedQueue<T> implements QueueInterface<T> {

    private Node queueNode; //References first node in queue
    private Node freeNode; //References node after back of queue

    public TwoPartCircularLinkedQueue() {
        freeNode = new Node(null, null);
        freeNode.setNextNode(freeNode);
        queueNode = freeNode;
    }


    @Override
    public void enqueue(T newEntry) {
        freeNode.setData(newEntry);
        if (isNewNodeNeede()) {
            //Allocate a new node and insert it after the node
            //that freeNode references
            Node newNode = new Node(null, freeNode.getNextNode());
            freeNode.setNextNode(newNode);

        }
        //freeNode要指向下一个结点
        freeNode = freeNode.getNextNode();

    }

    private boolean isNewNodeNeede() {
        return queueNode == freeNode.getNextNode();
    }

    @Override
    public T dequeue() {
        T front = getFront();
        queueNode.setData(null);
        queueNode = queueNode.getNextNode();
        return front;
    }

    @Override
    public T getFront() {
        if (isEmpty())
            throw new EmptyQueueException();
        else
            return queueNode.getData();
    }

    @Override
    public boolean isEmpty() {
        return queueNode == freeNode;
    }

    @Override
    public void clear() {
        while (!isEmpty())
            dequeue();

    }

    private class Node {
        private T data;
        private Node next;

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

        public void setNextNode(Node next) {
            this.next = next;
        }
    }
}
