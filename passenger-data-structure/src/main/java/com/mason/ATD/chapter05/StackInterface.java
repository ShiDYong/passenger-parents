package com.mason.ATD.chapter05;

/**
 * @author shiyong
 */
public interface StackInterface<T> {

    /**
     * Adds a new entry to the top of this stack.
     *
     * @param newEntry An object to be added to the stack.
     */
    public void push(T newEntry);


    /**
     * Remove and return this stack's top entry.
     *
     * @return The object at the top of stack.
     * throws emptyStackException if the stack is empty before the operation.
     */
    public T pop();


    /**
     * Retrives this stack's top entry.
     *
     * @return The object at the top of stack.
     * @therows EmpteyStackException if the stack is emtpy.
     */
    public T peek();

    /**
     * Detects whether this stack is empty.
     *
     * @return True if the stack is empty.
     */
    public boolean isEmpty();

    /**
     * Remove all entries from this stack.
     */
    public void clear();


}
