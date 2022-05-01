package com.mason.ATD.chapter02;


/**
 * 类ArrayBag的框架
 * A class of bags whose entries are stored in
 * a fixed-sized array
 *
 * @author ShiYong
 * @create 2022-03-29 14:10
 **/
public class ArrayBag02<T> implements BagInterface<T> {

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
    public ArrayBag02() {
        //会调用下面含参数的构造器
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty bag having a given initial capacity.
     *
     * @param desiredCapacity desiredCapacity The integer capacity desired.
     */
    public ArrayBag02(int desiredCapacity) {
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
    public boolean remove(T anEntry) {
        return false;
    }

    @Override
    public void clear() {

    }

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry The entry to be counted.
     * @return The number of time anEntry appears in the bag.
     */
    @Override
    public int getFrequencyOf(T anEntry) {
        checkIntegrity();
        int counter = 0;
        for (int index = 0; index < numberOfEntries; index++) {
            if (anEntry.equals(bag[index])) {
                counter++;
            }

        }
        return counter;
    }

    /**
     * 查看数组中是否含有给定的对象，可以再次查找数组bag.一旦发现找要找项的第一次出现，循环
     * 就应该立刻停止
     * @param anEntry The entry to find.
     * @return
     */
    @Override
    public boolean contains(T anEntry) {
        checkIntegrity();
        boolean found = false;
        int index = 0;
        while (!found && (index < numberOfEntries)){
            if (anEntry.equals(bag[index])){
                found = true;
            }else {
                index++;
            }
        }
        return found;
    }

    /**
     * Retrieves all entries that are in this bag
     *
     * @return A newly allocated array of all the entries in the bag.
     * Note: If the bag is empty .the returned array is empty.
     */
    @Override
    public T[] toArray() {
        checkIntegrity();
        //方法一：
        //The cast is save because the new array contains null entries.
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++) {
            // Copy elements of bag into result  return new array to user
            result[index] = bag[index];
        }
        return result;


        //方法二：该方法更加简洁和使用
        //    return Arrays.copyOf(bag,bag.length);

    }
}
