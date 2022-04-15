package com.mason.ATD.List;

import org.w3c.dom.Node;

import java.util.PriorityQueue;

/**
 * 实现单项链表
 *
 * @author ShiYong
 * @create 2022-04-14 10:20
 **/
public class LList<T> implements ListInterface<T> {
    private Node firstNode; //头结点
    private int numberOfEntries; //结点的个数

    public LList() {
        initializeDataFIelds();
    }

    private void initializeDataFIelds() {
        firstNode = null;
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
        } else {
            //添加到链表的尾部
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.setNextNode(newNode);

            //可以使用以上方法替代
            //add(numberOfEntries + 1, newEntry);
        }
        numberOfEntries++;

    }

    /**
     * 总结：当链表仅有头引用时,以下叙述成立:
     * 在链表表头添加结点是特例。
     * 从链表中删除首结点是特例。
     * 在链表表尾添加或删除结点需要遍历整个链表。
     * 在链表中添加结点最多需要改变两个引用。
     * 从链表中删除结点最多需要改变两个引用。
     */
    /**
     * 通过指定索引获取链表的结点
     *
     * @param givenPosition
     * @return
     */
    private Node getNodeAt(int givenPosition) {
        Node currentNode = firstNode;
        checkIndex(givenPosition);
        for (int index = 1; index < givenPosition; index++)
            currentNode = currentNode.getNextNode();

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
        //插在头结点
        if (givenPosition == 1) {
            newNode.setNextNode(newNode);
            firstNode = newNode;

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
        } else {
            //删除的是非头结点
            Node nodeBefore = getNodeAt(givenPosition - 1);
            Node nodeRemove = nodeBefore.getNextNode();
            //注意返回的数据不是结点!!!
            result = nodeRemove.getData();
            Node nodeAfter = nodeRemove.getNextNode();
            nodeBefore.setNextNode(nodeAfter);
            nodeRemove = null;

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
        if (numberOfEntries == 0)
            result = true;
        else
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
