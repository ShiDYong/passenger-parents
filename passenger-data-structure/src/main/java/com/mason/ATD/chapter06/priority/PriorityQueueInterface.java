package com.mason.ATD.chapter06.priority;

import java.util.PriorityQueue;

/**
 * ATD优先队列的接口
 *
 * @author ShiYong
 * @create 2022-04-12 9:03
 **/
public interface PriorityQueueInterface<T extends Comparable<? super T>>  {

    /**
     * Adds a new entry to this priority queue.
     * @param newEntry An object to be added.
     */
    public void add(T newEntry);

    /**
     * Removes and returns the entry having the highest priority.
     * @return  Either the object having the having the highest priority or,if the
     *          priority queue is empty before the operation ,null.
     */
    public T remove();


    /**
     * Retrives the entry having the highest priority.
     * @return Either the object having having the highest priority or ,if the priority
     *          queue is empty ,null
     */
    public T peek();

    /**
     * Detects whether this priority queue is empty.
     * @return  True if the priority queue is empty, or false otherwise.
     */
    public boolean isEmpty();


    /**
     * Gets the size of this priority queue
     * @return  The number of entries currency in the priority queue.
     */
    public int getSize();

    /**
     * Removes all entries from this priority queue.
     */
    public void clear();











}
