package com.mason.ATD.chapter05;

import java.io.PrintStream;

/**
 * 根据链表实现的栈
 * A class stacks whose entries are stored in a chain of nodes.
 *
 * @author ShiYong
 * @create 2022-04-01 17:00
 **/
public class LinkedStack<T> implements StackInterface<T> {


    @Override
    public void push(T newEntry) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    private class Node {
        private T data; //Entry in bag
        private Node next; //Link next node

       private Node(T dataPortion) {
            this(dataPortion, null);
        }

        private  Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        private T getData() {
            return data;
        }

        private void setData(T data) {
            this.data = data;
        }

        private Node getNext() {
            return next;
        }

        private void setNext(Node next) {
            this.next = next;
        }
    }


}
