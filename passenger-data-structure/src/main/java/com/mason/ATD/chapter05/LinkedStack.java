package com.mason.ATD.chapter05;

import java.io.PrintStream;
import java.util.EmptyStackException;

/**
 * 根据链表实现的栈
 * A class stacks whose entries are stored in a chain of nodes.
 *
 * @author ShiYong
 * @create 2022-04-01 17:00
 **/
public class LinkedStack<T> implements StackInterface<T> {
    private Node topNode; //Reference to first node in the chain

    public LinkedStack() {
        topNode = null;

    }

    /**
     * Adds a new entry to the top of this stack
     *
     * @param newEntry An object to be added to the stack.
     */
    @Override
    public void push(T newEntry) {
        //Add to beginning of chain
        Node newNode = new Node(newEntry, topNode);
        //Make new node reference rest of chain
        //New node is at beginning of chain
        topNode = newNode;


    }

    /**
     * Removes and return this stack's top entry.
     *
     * @return The object at the top of the stack.
     * @throws java.util.EmptyStackException if the stack is empty before the operation.
     */
    @Override
    public T pop() {
       /* if (topNode != null) {
            T topData = topNode.getData();
             topNode = topNode.getNextNode();
            return topData;
        } else
            throw new EmptyStackException();*/
        //方法二
        T top = peek();
        assert topNode != null;
        //将下一个结点的数据设置为top，即栈顶元素
        topNode = topNode.getNextNode();
        return top;


    }

    /**
     * Retrieves this stack's top entry.
     *
     * @return The object at the top of the stack.
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else
            return topNode.getData();
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void clear() {
        //将头部引用置为null，整个单链表就会没有引用
        topNode = null;

    }

    private class Node {
        private T data; //Entry in bag
        private Node next; //Link next node

        private Node(T dataPortion) {
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        private T getData() {
            return data;
        }

        private void setData(T data) {
            this.data = data;
        }

        private Node getNextNode() {
            return next;
        }

        private void setNextNode(Node next) {
            this.next = next;
        }
    }


}
