package com.mason.ATD.chapter03;

import com.mason.ATD.chapter02.BagInterface;

import java.util.TreeMap;

/**
 * 链表的实现
 * A class of bags whose entries are stored in
 * charin of lined nodes.
 *
 * @author ShiYong
 * @create 2022-03-31 10:54
 **/
public final class LinedBag01<T> implements BagInterface<T> {

    //节点链表中第一个节点的地址，也称为头引用：head reference
    private Node firstNode;

    //记录链表中节点的个数
    private int numberOfEntries;

    public LinedBag01() {

        //初始化私有数据域
        firstNode = null;
        numberOfEntries = 0;
    }

    /**
     * Gets the current number of entries in this bag.
     *
     * @return The interge number of entries currency in this bag.
     */
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    /**
     * Sees whether this bag is empty.
     *
     * @return True if the bag is empty, or false if not
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /**
     * Adds a new entry to this bag
     *
     * @param newEntry The object to be added as a new entry.
     * @return True
     */
    @Override
    public boolean add(T newEntry) {
        //Add to beginning of chain:将数据放到newNode中
        Node newNode = new Node(newEntry);
        //设置newNode的连接部分为firstNode
        newNode.next = firstNode;
        //让新节点指向链表中的首结点，让它称为新的首结点
        firstNode = newNode;
        numberOfEntries++;
        //对于链式实现，包不会满，除非用光了计算机的所有内存，
        return true;
    }

    /**
     * Remove one unspecified entry from this bag,if possible
     *
     * @return Either the removed object, if the removal was successful or null.
     */
    @Override
    public T remove() {
        T result = null;
        //检查链表是否为空
        if (firstNode != null) {
            //访问第一个结点的项
            result = firstNode.data;
            //设置firstNode指向第二个结点，
            firstNode = firstNode.next;
            //结点自减
            numberOfEntries--;
        }
        return result;
    }

    /**
     * Remove one occurrence of  a given entry for this bag, if prossible
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful ,or false otherwise.
     */
    @Override
    public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);
        if (nodeN != null) {
            //用第一结点的项替换结点N中的项
            nodeN.data = firstNode.data;
            //从链表中删除第一个结点
            firstNode = firstNode.next;
            //结点项自减
            numberOfEntries--;
            result = true;
        }
        return result;
    }

    /**
     * Locates a given entry within this bag.
     *
     * @param anEntry a reference to the node containing the entry,if possible
     * @return or null otherwise.
     */
    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        }
        return currentNode;
    }

    /**
     * 使用计数器及numberofEntries而不是用currentNode来控制循环.
     * 上面第一种方法能保证currentNode不是null,所以避免NullPointgerException异常
     *
     * @param anEntry
     * @return
     */
    private Node getReferenceTo02(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        int counter = 0;
        while (!found && (counter < numberOfEntries)) {
            if (anEntry.equals(currentNode.data))
                found = true;
            else {
                currentNode = currentNode.next;
                counter++;
            }
        }
        return currentNode;
    }

    /**
     * Removes all entries from this bag.
     */
    @Override
    public void clear() {
        while (isEmpty())
            remove();

        //firstNode = null 该方法将firstNode为Null,则没有引用指向了链表中的首结点了。所以系统
        //会释放首结点。结果没有引用指向第二个结点，故系统将释放它，依次类推直到整个链表被释放完伟为止。


    }

    /**
     * Counts the number of times a given entry appear in this bag.
     *
     * @param anEntry The entry to be counted.
     * @return the number of anEntry appear in this bag.
     */
    @Override
    public int getFrequencyOf(T anEntry) {
        //出现多少次数
        int frequency = 0;
        //可以完全忽略这个变量，为了进行逻辑检查，所以保留它
        int loopCounter = 0;
        Node currentNode = firstNode;

        while ((loopCounter < numberOfEntries) && (currentNode != null)) {
            if (anEntry.equals(currentNode.data))
                frequency++;
            //对终点进行计数以便控制循环
            loopCounter++;
            //指向下一个结点
            currentNode = currentNode.next;
        }

        return frequency;
    }

    /**
     * Tests the bag contains a given entry
     *
     * @param anEntry The entry to find.
     * @return True if the bag contains ,or false if not.
     */
    @Override
    public boolean contains(T anEntry) {
        //   由于也是被删除时使用，随意对该方法进行抽取成为公共方法
        //        boolean found = false;
        //        Node currentNode = firstNode;
        //        while (!found && (currentNode != null)) {
        //            if (anEntry.equals(currentNode.data))
        //                found = true;
        //            else
        //                currentNode = currentNode.next;
        //        }

        // return getReferenceTo(anEntry).equals(anEntry); 因为该方法返回的是一个entry如归再用的话
        //显的非常重复不必要，所以判断该返回的实体是否为null即可
        return getReferenceTo(anEntry) != null;
    }

    /**
     * Retrieves all entries that are in this bag
     *
     * @return A newly allocated array of all the entries in the bag.
     */
    @Override
    public T[] toArray() {
        //申请一个新数组存储返回给客户端的数据
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        //设置一个临时变量存储,将首结点赋值
        Node currentNode = firstNode;
        //遍历链表将元素复制给result
        while ((index < numberOfEntries) && (currentNode != null)) {
            //获取当前结点的数据
            result[index] = currentNode.data;
            index++;
            //移到下一个节点
            currentNode = currentNode.next;
        }

        return result;
    }


    /**
     * 通过递归实现对链表结点的数据的访问
     *
     *
     * @param nodeOne
     */
    public void display(Node nodeOne) {
        display(firstNode);

    }

    /**
     * 当写一个方法递归处理结点链表时，可以通过以下工作：
     * 1.使用链表指向链表中首结点的引用作为方法的参数；
     * 2.处理首结点，然后处理链表中的其余结点；
     * 3.当参数是null时停止
     * @param nodeOne
     */
    private void displayChain(Node nodeOne) {
        if (nodeOne != null) {
            //正常顺序显示链表数据
            System.out.println(nodeOne.getData());
            display(nodeOne.getNextNode());
            //若打印语句如下面所示则是反向显示链表的链接
            //相比于递归方式以反序遍历结点链表，比起采用迭代实现要简单些
            //System.out.println(nodeOne.getData());
        }


    }

    /**
     * 私有内部类Node,外部类可以按名直接访问内部类的
     * 数据域，而不需要通过方法或者赋值方法；因为Node是一个内部类
     * 故泛型T将于包含Node的外部类声明的泛型是一样的。所以我们没有在Node
     * 后写T<></>
     */
    private class Node {

        private T data;  //Entry in bag

        private Node next; //link to next node

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

        private Node getNextNode() {
            return next;
        }
    }
}
