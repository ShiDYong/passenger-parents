package com.mason.ATD.chapter05;

import java.util.EmptyStackException;
import java.util.Vector;

/**
 * 通过向量实现栈
 * A class of stacks whose entries are stored in a vector
 *
 * @author ShiYong
 * @create 2022-04-07 11:16
 **/
public class VectorStack<T> implements StackInterface<T> {

    private Vector<T> stack;

    private boolean integrityOk;

    private final static int DEFAULT_CAPACITY = 10;

    private final static int MAX_CAPACITY = 10000;


    public VectorStack() {
        this(DEFAULT_CAPACITY);
    }

    public VectorStack(int initialCapacity) {
        integrityOk = false;
        //检查是否大于栈的最大值
        ensureCapacity(initialCapacity);
        //实例化一个指定大小的的vector
        stack = new Vector<>(initialCapacity);
        integrityOk = true;
    }

    private void ensureCapacity(int initialCapacity) {
        if (initialCapacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a stack " +
                    "whose capacity exceeds " +
                    "allowed maximum of ." + MAX_CAPACITY);
    }

    /**
     * Adds an new entry to the top of stack.
     *
     * @param newEntry An object to be added to the stack.
     */
    @Override
    public void push(T newEntry) {
        isIntegrityOk();
        stack.add(newEntry);


    }


    /**
     *
     */
    private void isIntegrityOk() {
        if (!integrityOk)
            throw new SecurityException("VectorStack object is curropt");
    }

    /**
     * Gets the top of stack entry
     *
     * @return
     */
    @Override
    public T pop() {
        isIntegrityOk();
        if (isEmpty())
            throw new EmptyStackException();
        else
            return stack.remove(stack.size() - 1);
    }

    /**
     * @return
     */
    @Override
    public T peek() {
        isIntegrityOk();
        if (isEmpty())
            throw new EmptyStackException();
        else
            return stack.lastElement();


    }

    /**
     * @return
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     *
     */
    @Override
    public void clear() {
        isIntegrityOk();
        stack.clear();
    }
}
