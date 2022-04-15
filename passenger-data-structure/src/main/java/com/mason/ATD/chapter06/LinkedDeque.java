package com.mason.ATD.chapter06;

import org.w3c.dom.Node;

import java.awt.*;

/**
 * 双向链表实现双端队列
 * <p>
 * A class that implements a deque of objects by using
 * a chain of doubly linked nodes.
 *
 * @author ShiYong
 * @create 2022-04-11 11:27
 **/
public class LinkedDeque<T> implements DequeInterface<T> {


    private DLNode firstNode;  //References node af front of queue
    private DLNode lastNode;   //References node of back of guque

    public LinkedDeque() {
        firstNode = null;
        lastNode = null;
    }

    /**
     * Adds a new entry to the front front of this deque.
     *
     * @param newEntry an object to be added.
     */
    @Override
    public void addToFront(T newEntry) {
        DLNode newNode = new DLNode(null, newEntry, firstNode);
        //当前队列为空
        if (isEmpty()) {
            lastNode = newNode;
        } else
            firstNode.setPreviousNode(newNode);
        //新结点指向首结点
        firstNode = newNode;

    }

    /**
     * Adds a new entry to the back of this deque
     *
     * @param newEntry
     */
    @Override
    public void addToBack(T newEntry) {
        DLNode newNode = new DLNode(lastNode, newEntry, null);
        if (isEmpty()) {
            firstNode = newNode;

        } else
            lastNode.setNextNode(newNode);
        lastNode = newNode;

    }

    /**
     * Removes and returns the front entry of this deque.
     *
     * @return The object at the frontof the deque.
     * @throws EmptyQueueException if the deque is empty before the
     *                             operation.
     */
    @Override
    public T removeFront() {
        T front = getFront();
        //将当前首结点指向下一个结点
        firstNode = firstNode.getNextNode();
        //如果首结点为空
        if (firstNode == null)
            lastNode = null;
        else
            //将被删除的结点置空
            firstNode.setPreviousNode(null);
        return front;


    }


    /**
     * Removes and returns the back entry of this deque.
     *
     * @return The object at the back of the deque.
     * @throws EmptyQueueException if the deque is empty before the
     *                             operation.
     */
    @Override
    public T removeBack() {
        T back = getBack();
        lastNode = lastNode.getPreviousNode();
        if (lastNode == null)
            firstNode = null;
        else
            lastNode.setNextNode(null);

        return back;
    }


    /**
     * Retrieves the front entry of this deque.
     *
     * @return The object at the front of the deque.
     * @throws EmptyQueueException if the deque is empty.
     */
    @Override
    public T getFront() {
        if (isEmpty())
            throw new EmptyQueueException();
        else
            return firstNode.getData();
    }

    /**
     * Retrieves the back entry of this deque.
     *
     * @return The object at the back of the deque.
     * @throws EmptyQueueException if the deque is empty.
     */

    @Override
    public T getBack() {
        if (isEmpty())
            throw new EmptyQueueException();
        else
            return lastNode.getData();
    }


    /**
     * Detects whether this deque is empty.
     *
     * @return True if the deque is empty, or false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return (firstNode == null && lastNode == null);
    }

    /* Removes all entries from this deque. */
    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;


    }


    private class DLNode {
        private T data;   //entry in bag
        private DLNode previous; // link to previous node
        private DLNode next;  //link to next node

        private DLNode(T dataPortion) {
            this(null, dataPortion, null);
        }

        private DLNode(DLNode previousDLNode, T dataPortion, DLNode nextDLNode) {
            data = dataPortion;
            previous = previousDLNode;
            next = nextDLNode;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public DLNode getPreviousNode() {
            return previous;
        }

        public void setPreviousNode(DLNode previousNode) {
            this.previous = previousNode;
        }

        public DLNode getNextNode() {
            return next;
        }

        public void setNextNode(DLNode nextNode) {
            this.next = nextNode;
        }
    }
}
