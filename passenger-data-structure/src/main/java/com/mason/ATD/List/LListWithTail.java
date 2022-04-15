package com.mason.ATD.List;

import org.w3c.dom.Node;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * 通过头引用和尾引用实现的链表
 * 当链表有头引用和尾引用时以下叙述成立：
 * 在空链表中添加结点是特例。
 * 在链表表尾添加结点是特例,但不需要遍历。
 * 删除链表的最后结点是特例。除指向首结点的引用外,维护指向链表中最后结点的引用,当在链表表尾添加结点时可以消除遍历。
 * 所以,当链表有头引用和尾引用时,在线性表表尾的添加,比仅有头引用时更快。
 * 因此，我们使用有头引用和尾引用的链表来实现 ADT 线性表。
 *
 * @author ShiYong
 * @create 2022-04-14 15:02
 **/
public class LListWithTail<T> implements ListInterface<T> {
    private Node firstNode; //头结点
    private Node lastNode; //尾引用
    private int numberOfEntries; //结点的个数

    public LListWithTail() {
        initializeDataFIelds();
    }

    private void initializeDataFIelds() {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    }

    /**
     * Adds a new entry to the end of this list.
     * Entries currently in the list are unaffected.
     * The list's size is increased by 1.
     *
     * @param newEntry The object to be added as a new entry.
     */
    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        //判断是否当前链表是否为空
        if (isEmpty()) {
            firstNode = newNode;
        } else
            // {
            //添加到链表的尾部，使用尾引用好处就是不用遍历尾结点
            //Node lastNode = getNodeAt(numberOfEntries);
            lastNode.setNextNode(newNode);

        //可以使用以上方法替代
        //add(numberOfEntries + 1, newEntry);
        // }
        //将新结点指向尾结点
        lastNode = newNode;
        numberOfEntries++;

    }

    /**
     * 通过指定索引获取链表的结点
     *
     * @param givenPosition
     * @return
     */
//    private Node getNodeAt(int givenPosition) {
//        Node currentNode = firstNode;
//        checkIndex(givenPosition);
//        for (int index = 1; index < givenPosition; index++)
//            currentNode = currentNode.getNextNode();
//
//        return currentNode;
//    }

    /**
     * 根据添加了尾引用进行一定的修改
     * @param givenPosition
     * @return
     */
    private Node getNodeAt(int givenPosition) {
        assert (firstNode != null) && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
        Node currentNode = firstNode;
        if (givenPosition == numberOfEntries)
            currentNode = lastNode;
        else if (givenPosition > 1) // Traverse the chain to locate the desired node
        {
            for (int counter = 1; counter < givenPosition; counter++)
                currentNode = currentNode.getNextNode();
        } // end if
        assert currentNode != null;
        return currentNode;
    }

    /**
     * Adds a new entry at a specified position within this list.
     * Entries originally at and above the specified position are
     * at the next higher position within the list.
     * the list's size is increased by 1.
     *
     * @param givenPosition An integer that specified the deisred position of the new entry
     * @param newEntry      The object to be added as a new entry.
     * @throws IndexOutOfBoundsException if either newPosition < 1 or newPositon> getlength()+1.
     */
    @Override
    public void add(int givenPosition, T newEntry) {
        checkIndex(givenPosition);
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
        }

        //插在头结点
        else if (givenPosition == 1) {
            newNode.setNextNode(newNode);
            firstNode = newNode;
            //插在尾结点
        } else if (givenPosition == numberOfEntries + 1) {
            lastNode.setNextNode(newNode);
            lastNode = newNode;
        } else {
            //元素添加在中间位置
            Node nodeBefore = getNodeAt(givenPosition - 1);
            Node nodeAfter = nodeBefore.getNextNode();
            nodeBefore.setNextNode(newNode);
            newNode.setNextNode(nodeAfter);
        }

        numberOfEntries++;

    }


    /**
     * 检查是否超出了当前链表的索引的范围
     *
     * @param givenPosition
     */
    private void checkIndex(int givenPosition) {
        if ((givenPosition < 1) || (givenPosition > numberOfEntries + 1))
            throw new IllegalArgumentException("givenPosition beyond the limit ");
    }


    /**
     * Removes the entry at a given position from this list.
     * Entries originally at positions higher than the given.
     * position are at the next lower position within the list
     * and the list's size is decreased by 1.
     *
     * @param givenPosition An integer that indicates the position of the entry to be removed.
     * @return A reference to the removed entry.
     * @throws IndexOutOfBoundsException if either givenPosition < 1 or givenPosition> getlength().</>
     */
    @Override
    public T remove(int givenPosition) {
        checkIndex(givenPosition);
        T result = null;
        if (givenPosition == 1) {
            //删除的是头结点
            result = firstNode.getData();
            firstNode = firstNode.getNextNode();
            //判断如果当前链表只有一个结点
            if (numberOfEntries == 1)
                lastNode = null;
        } else {
            //删除的是非头结点
            Node nodeBefore = getNodeAt(givenPosition - 1);
            Node nodeRemove = nodeBefore.getNextNode();
            //注意返回的数据不是结点!!!
            Node nodeAfter = nodeRemove.getNextNode();
            nodeBefore.setNextNode(nodeAfter);
            result = nodeRemove.getData();
            // nodeRemove = null;
            if (givenPosition == numberOfEntries)
                lastNode = nodeBefore;

        }
        numberOfEntries--;
        return result;
    }

    /**
     * Removes all entries from this list.
     */
    @Override
    public void clear() {
        while (!isEmpty()) {
            initializeDataFIelds();
        }

    }


    /**
     * Replaces the entry at a given position in this list.
     *
     * @param givenPosition An integer that indicates the position of the entry to be replaced.
     * @param newEntry      The object that will replace the entry at the postion givenPosition.
     * @return The original entry that was replaced.
     * @throws IndexOutOfBoundsException if either givenPostion < 1 or givenPosition> getlength().</>
     */
    @Override
    public T replace(int givenPosition, T newEntry) {
        checkIndex(givenPosition);
        Node entry = getNodeAt(givenPosition);
        T oldData = entry.getData();
        //注意替换这里是把整个entry设置进去，不是把data加进去，因为entry中包含了data
        //注意替换的结点的数据而不是结点本身
        entry.setData(newEntry);
        return oldData;
    }


    /**
     * Retrieves the entry at a given position in this list
     *
     * @param givenPosition An integer that indecates the position of the desired entry.
     * @return A reference to the indicated entry
     * * @throws IndexOutOfBoundsException if either givenPostion < 1 or givenPosition> getlength().</>
     */
    @Override
    public T getEntry(int givenPosition) {
        checkIndex(givenPosition);
        T data = getNodeAt(givenPosition).getData();
        return data;
    }


    /**
     * Retrieves all entries that are in this list in the order in which they occur in the list
     *
     * @return A newly allocated array of all the entries in the list .If the list if empty,
     * the returned array is empty.
     */
    @Override
    public T[] toArray() {
        Node currentNode = firstNode;
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        while (currentNode != null && index < numberOfEntries) {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        }
        return result;
    }


    /**
     * Sees whether this list contains a given entry.
     *
     * @param anEntry The object that is the desired entry.
     * @return True if the list conatins anEntry, or false if not.
     */
    @Override
    public boolean contain(T anEntry) {
        boolean found = false;

        if (!isEmpty()) {
            Node currentNode = firstNode;
            while ((currentNode != null) && (!found)) {
                if (anEntry.equals(currentNode.getData()))
                    found = true;
                else
                    currentNode = currentNode.getNextNode(); //如果没有找到就继续循环查找
            }
        }

        return found;
    }


    /**
     * Gets the length of this list.
     *
     * @return The integer number of entries currenctly in the list.
     */
    @Override
    public int getLength() {
        return numberOfEntries;
    }


    /**
     * Sees whether this list is empty
     *
     * @return True if the list is empty, or false if not.
     */
    @Override
    public boolean isEmpty() {
        boolean result;
        if ((firstNode == null) && (lastNode == null)) {
            result = true;
        }
        result = false;
        return result;

        //return numberOfEntries == 0;
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

        public void setNextNode(Node nextNode) {
            this.next = nextNode;
        }
    }
}
