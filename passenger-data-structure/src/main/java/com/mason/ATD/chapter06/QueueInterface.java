package com.mason.ATD.chapter06;

/**
 * @author shiyong
 */
public interface QueueInterface<T> {

    /**
     * Adds an new entry to the back of this queue
     *
     * @param newEntry An object to be added.
     */
    public void enqueue(T newEntry);


    /**
     * Removes the entry at the front of this queue.
     *
     * @return The objcect at the front of the queue.
     * @trows EmptyQueueException if the queue is empty.
     */
    public T dequeue();

    /**
     * Retrieves the entry at the front of this queue.
     *
     * @return The object at the front of the queue
     * @throws  if the queue is empty
     */
    public T getFront();


    /**
     * Deteccts whether this queue is empty.
     *
     * @return True if the queue is empty, or false otherwise.
     */
    public boolean isEmpty();


    /**
     * Removes all entries from this queue.
     */
    public void clear();
}
