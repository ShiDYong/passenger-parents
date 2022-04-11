package com.mason.ATD.chapter06;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

/**
 * 基于循环数组实现的队列
 * A class that implements a queue of objects by using an array.
 *
 * @author ShiYong
 * @create 2022-04-08 11:55
 **/
public class ArrayQueue<T> implements QueueInterface<T> {
    // Circular array of queue entries and
    // one unused element.
    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private boolean integrityOk;
    private static final int DEFAULT_CAPACTIY = 10;
    private static final int MAX_CAPACITY = 10000;

    public ArrayQueue() {
        this(DEFAULT_CAPACTIY);

    }

    public ArrayQueue(int initialCapacity) {
        integrityOk = false;
        checkCapacity(initialCapacity);
        T[] tempQueue = (T[]) new Object[initialCapacity + 1];
        queue = tempQueue;
        backIndex = initialCapacity;
        frontIndex = 0;
        integrityOk = true;

    }


    private void checkCapacity(int initialCapacity) {
        if (initialCapacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a queue " +
                    "whose capacity exceeds " +
                    "allowed maximum of ." + MAX_CAPACITY);
    }

    /**
     * Adds an new entry to the back of this queue
     *
     * @param newEntry An object to be added.
     */
    @Override
    public void enqueue(T newEntry) {
        checkIntegrity();
        //检查数组是否满了，需要扩容
        ensureCapacity();
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;


    }

    /**
     * Doubles the size of the array queue if it is full.
     * Precondition:checkIntegrity has been called.
     */
    private void ensureCapacity() {
        //If array is full, double size of array
        if (frontIndex == ((backIndex + 2)) % queue.length) {
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = oldSize << 1;
            checkCapacity(newSize - 1);
            integrityOk = true;
            //重新申请2倍的数组
            T[] tempQueue = (T[]) new Object[newSize];
            queue = tempQueue;
            //数组元素的拷贝
            for (int index = 0; index < oldSize - 1; index++) {
                queue[index] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;

            }
            //重新设置frontIndex和backIndex的值
            frontIndex = 0;
            backIndex = oldSize - 2;
            integrityOk = true;
        }

    }


    /**
     * Removes the entry at the front of this queue.
     *
     * @return The objcect at the front of the queue.
     * @trows EmptyQueueException if the queue is empty.
     */
    @Override
    public T dequeue() {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyStackException();
        else {
            T front = queue[frontIndex];
            queue[frontIndex] = null;
            // frontIndex++;因为用的是循环队列所以要用下面的取余的方式
            frontIndex = (frontIndex + 1) % queue.length;
            return front;
        }
    }

    /**
     * Retrieves the entry at the front of this queue.
     *
     * @return The object at the front of the queue
     * @throws  if the queue is empty
     */
    @Override
    public T getFront() {
        checkIntegrity();
        if (isEmpty())
            throw new EmptyQueueException();
        else
            return queue[frontIndex];
    }

    /**
     * Deteccts whether this queue is empty.
     *
     * @return True if the queue is empty, or false otherwise.
     */
    @Override
    public boolean isEmpty() {
        checkIntegrity();
        return frontIndex == ((backIndex + 1) % queue.length);
    }


    /**
     * Removes all entries from this queue.
     */
    @Override
    public void clear() {
        checkIntegrity();
//        while (true) {
//            if (isEmpty())
//                throw new EmptyStackException();
//            else
//                dequeue();
//        }
        while (!isEmpty())
            dequeue();
        //方式二
//        if (!isEmpty()) {
//            int index = frontIndex;
//            while (index != backIndex) {
//                queue[index] = null;
//                index = (index + 1) % queue.length;
//            }
//            queue[backIndex] = null;
//        }
//        frontIndex = 0;
//        backIndex = queue.length - 1;

    }

    private void checkIntegrity() {
        if (!integrityOk)
            throw new SecurityException("ArrayQueue object is corrupt.");
    }
}
