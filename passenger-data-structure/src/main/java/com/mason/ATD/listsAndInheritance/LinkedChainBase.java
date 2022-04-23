package com.mason.ATD.listsAndInheritance;

/**
 * 将结点链表的处理设置为抽象基类
 *
 * @author ShiYong
 * @create 2022-04-22 9:38
 **/
public abstract class LinkedChainBase<T> {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedChainBase() {
        initializeDataFields();
    }

    public void clear() {
        initializeDataFields();
    }

    public int getlength() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        boolean result;
        if (numberOfEntries == 0)   // Or getLength(0 == 0
        {
            assert firstNode == null;
            result = true;
        } else {
            assert firstNode != null : "numberOfEntries is not 0 but firstNode is null";
            result = false;
        } // end if
        return result;
    }


    public T[] toArray() {
        // The cast is safe because the new array contains null entries.
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast

        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        //OR for (int index = 0; index < numberOfEntries; index++)
        {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        } // end for
        return result;
    }

    protected final Node getFirstNode() {
        return firstNode;
    }

    /**
     * Adds a node to the beginning of a chain.
     *
     * @param newNode The new node to be inserted.
     */
    protected final void addFirstNode(Node newNode) {
        assert newNode != null : "null argument in addFirstNode";
        newNode.setNextNode(firstNode);
        firstNode = newNode;
        numberOfEntries++;
    } // end addFirstN

    /**
     * Adds a node to a chain after a given node.
     *
     * @param nodeBefore The node before the new node.
     * @param newNode    The node to be inserted.
     */
    protected final void addAfterNode(Node nodeBefore, Node newNode) {
        assert newNode != null : "null argument in addFirstNode";
        Node nodeAfter = nodeBefore.getNextNode();
        newNode.setNextNode(nodeAfter);
        nodeBefore.setNextNode(newNode);
        numberOfEntries++;
    } // end addAfterNode


    // Returns a reference to the node at a given position.
    // Precondition: The chain is not empty;
    //               1 <= givenPosition <= numberOfEntries.
    protected final Node getNodeAt(int givenPosition) {
        assert (firstNode != null) &&
                (1 <= givenPosition) && (givenPosition <= numberOfEntries);
        Node currentNode = firstNode;
        // Traverse the chain to locate the desired node
        // (skipped if givenPostiion is 1)
        for (int counter = 1; counter < givenPosition; counter++)
            currentNode = currentNode.getNextNode();
        assert currentNode != null;

        return currentNode;
    } // end getNodeAt

    /**
     * Removes a chain’s first node.
     *
     * @return A datum that is removed.
     */
    protected final T removeFirstNode() {
        T result = firstNode.getData();       // Save entry to be removed
        firstNode = firstNode.getNextNode(); // Remove entry
        numberOfEntries--;                      // Update count
        return result;
    } // end removeFirstNode

    /**
     * Removes the node after a given one.
     *
     * @param nodeBefore The node before the node to be removed.
     * @return The datum that is removed.
     */
    protected final T removeAfterNode(Node nodeBefore) {
        Node nodeToRemove = nodeBefore.getNextNode();
        T result = nodeToRemove.getData();    // Save entry to be removed
        Node nodeAfter = nodeToRemove.getNextNode();
        nodeBefore.setNextNode(nodeAfter);  // Remove entry
        numberOfEntries--;                      // Update count
        return result;
    } // removeAfterNode

    /**
     * 初始化抽象类属性的方法
     */
    protected final void initializeDataFields() {
        firstNode = null;
        numberOfEntries = 0;
    }

    /**
     * 终极保护内部类
     */
    protected final class Node {
        private T data;
        private Node next;

        protected Node(T dataPortion) {
            this(dataPortion, null);
        }

        /**
         * 设置结点的链接部分的方法为私有的
         *
         * @param dataPortion
         * @param nextNode
         */
        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;

        }

        protected final T getData() {
            return data;
        }

        protected final void setData(T data) {
            this.data = data;
        }

        protected final Node getNextNode() {
            return next;
        }

        private final void setNextNode(Node nextNode) {
            this.next = nextNode;
        }
    }


}
