package com.mason.ATD.chapter02;


import com.mason.ATD.chapter02.BagInterface;

import java.util.Arrays;

/**
 * BagInterface的实现类
 *
 * @author ShiYong
 * @create 2022-03-28 14:57
 **/
public class ArrayBag01<T> implements BagInterface<T> {


    private boolean integrityOk;
    //数组的最大容量，防止出现实例化超过这个容量出现内存不足OOM的情况
    private static final int MAX_CAPACITY = 10000;

    private final T[] bag;
    /**
     * 记录当前包元素的个数
     */
    private int numberOfEntries;
    //提供数组的默认容量
    private static final int DEFAULT_CAPACITY = 25;

    /**
     * Create an empty bag whose initial capacity is 25
     */
    public ArrayBag01() {
        //会调用下面含参数的构造器
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty bag having a given initial capacity.
     *
     * @param desiredCapacity desiredCapacity The integer capacity desired.
     */
    public ArrayBag01(int desiredCapacity) {
        //设置表示位
        integrityOk = false;

        //判断是否超出数组最大容量
        if (desiredCapacity <= MAX_CAPACITY) {
            //The cast is save because the new array contains null entries.
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[desiredCapacity];
            bag = tempBag;
            numberOfEntries = 0;
            //类的每每个重要方法执行其操作之前都可以检查域integrityOk的状态，
            //这样方式下，畸形对象就不会再有动作
            integrityOk = true;

        } else {
            throw new IllegalStateException("Attemp to create a bag whose " +
                    "capacity execeds allowed maximum.");
        }


    }

    /**
     * 在数组bag已成功分配的基础上，ArrayBag中的任何共有方法在继续执行之前，
     * 都要确保数据域integrityOk的值为真，如果integrityOk为假，则这样的方法
     * 可以抛出一个异常
     * 在bag类中很多方法中都要检查integrityOk，所以为了避免代码重复，
     * 可以定义私有方法
     */
    private void checkIntegrity() {
        if (!integrityOk)
            throw new SecurityException("ArrayBag object is corrupt.");

    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /**
     * Adds a new entry to that bag.
     *
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful,or false if not.
     */
    @Override
    public boolean add(T newEntry) {
        //检查integrityOk是否为真
        checkIntegrity();
        boolean result = true;
        //judge whether bag is full
        if (isArrayFull()) {
            result = false;
        } else {
            // Assertion: result is true here
            bag[numberOfEntries] = newEntry;
            //每次添加项后，要增大计数器numberOfEntries的值
            numberOfEntries++;
        }

        return result;


    }

    /**
     * Returns true if the bag is full, or false if not.
     *
     * @return
     */
    private boolean isArrayFull() {
        return numberOfEntries >= bag.length;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public boolean remove(Object anEntry) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getFrequencyOf(Object anEntry) {
        return 0;
    }

    @Override
    public boolean contains(Object anEntry) {
        return false;
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(bag, bag.length);
    }
}
