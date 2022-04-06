package com.mason.ATD.chapter05;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 基于数组实现栈
 * A class of stack whose entries are stored in an array.
 *
 * @author ShiYong
 * @create 2022-04-06 16:56
 **/
public class ArrayStack<T> implements StackInterface<T> {
    private T[] stack; //Array of stack entries;
    private int topIndex; //Index of top entry;
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    /**
     * Create an empty stack whose initial capacity is 50
     */
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Create an empty stack having a given capacity.
     *
     * @param initialCapacity initialCapacity The integer capacity desired.
     */
    public ArrayStack(int initialCapacity) {
        integrityOK = false;
        //属性的初始化
        checkCapacity(initialCapacity);
        T[] tempStack = (T[]) new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;

    }

    /**
     * Checks whether biger than array max capacity.
     */
    private void checkCapacity(int initialCapacity) {
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
        isIntegrityOK();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;

    }

    /**
     * 检查当前数组是否有空闲空间保存新元素
     * 如果不够则进行扩容操作
     */
    private void ensureCapacity() {
        if (topIndex == stack.length - 1) {
            //If array is full, double its size
            int newLength = stack.length << 1;
            checkCapacity(newLength);
            //调用native方法对数组元素进行复制
            Arrays.copyOf(stack, newLength);
        }

    }

    @Override
    public T pop() {
        isIntegrityOK();
        if (isEmpty())
            throw new EmptyStackException();
        else {
            T top = stack[topIndex];
            //出于安全考虑和方便Jvm进行垃圾回收
            stack[topIndex] = null;
            topIndex--;
            return top;
        }
        /*T top = peek(); // Might throw EmptyStackException
        assert !isEmpty();
        stack[topIndex] = null;
        topIndex--;
        return top;*/

    }

    @Override
    public T peek() {
        isIntegrityOK();
        if (isEmpty()) {
            throw new EmptyStackException();
        } else
            return stack[topIndex];

    }

    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }

    @Override
    public void clear() {
        while (isEmpty())
            pop();

       /* while (topIndex >-1){
            stack[topIndex] = null;
            topIndex--;
        }*/

    }

    private void isIntegrityOK() {
        if (!integrityOK)
            throw new SecurityException("ArrayStack object is corrupt.");
    }

}
