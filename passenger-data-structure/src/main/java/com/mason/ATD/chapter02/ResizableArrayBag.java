package com.mason.ATD.chapter02;

import java.util.Arrays;

/**
 * 实现动态扩容的数组
 * A class that implements a bag of objects by using an array
 * The bag is never full.
 *
 * @author ShiYong
 * @create 2022-03-30 14:35
 **/
public class ResizableArrayBag<T> implements BagInterface<T> {
    //表示当前数组 取消final，表示数组可以扩容
    private T[] bag;
    //表示当前数组的最大容量
    private static final int MAX_CPACITY = 10000;
    //表示当前数组的默认容量
    private static final int DEFAULT_CAPACTIY = 25;
    //表示当前数组中的元素或者项的个数
    private int numberOfEntries;

    //表示安全的符号位;所有公共方法进行操作确认数组是否初始化
    private boolean integrityOk = false;

    /**
     * Creates an empty bag whose initial capacity is 25.
     */
    public ResizableArrayBag() {
        this(DEFAULT_CAPACTIY);
    }

    /**
     * Creates an empty bag having a given initial capacity.
     *
     * @param initialCapacity The integer capacity desired.
     */
    public ResizableArrayBag(int initialCapacity) {
        //integrityOk = false;
        //判断是否超过数组最大容量
        //        if (desiredCapacity <= MAX_CPACITY) {
        //            //初始化指定数组
        //            T[] tempBag = (T[]) new Object[desiredCapacity];
        //            bag = tempBag;
        //            //设置数组的元素个数为0
        //            numberOfEntries = 0;
        //            integrityOk = true;
        //        } else {
        //            throw new IllegalStateException("Attemp to create a bag whose " +
        //                    "capacity execeds allowed maximum.");
        //        }

        checkCapacity(initialCapacity);
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[initialCapacity]; // Unchecked cast
        bag = tempBag;
        numberOfEntries = 0;
        integrityOk = true;


    }

    /**
     * Creates a bag containing given entries.
     * @param contents An array of objects.
     */
    public ResizableArrayBag(T[] contents) {
        checkCapacity(contents.length);
        bag = Arrays.copyOf(contents, contents.length);
        numberOfEntries = contents.length;
        integrityOk = true;
    }

    /**
     * Get current number of entries in this bag.
     *
     * @return The integer number of entries in the bag.
     */
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    /**
     * Sees whether thsi bag is empty.
     *
     * @return True if bag is empty,or false if not.
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful,or false.
     */
    @Override
    public boolean add(T newEntry) {
        //1.先检查数组是否初始化
        checkIntegrity();
        //定义一个符号位
        boolean result = true;
        //2.插入前先检查数组空间是否已经满了
        if (isArrayFull()) {
            //result = false;
            //调动扩容方法
            doubleCapacity();

        } else {
            //开始插入
            bag[numberOfEntries] = newEntry;
            //每次插入后都要增大计数器numberOfEntries的值
            numberOfEntries++;
        }
        return result;
    }

    /**
     * Double the size of the array bag.
     * Precondition:checkIntegrity has been called.
     */
    private void doubleCapacity() {
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    }


    private void checkCapacity(int capacity) {
        if (capacity > MAX_CPACITY) {
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
        if (!integrityOk) {
            throw new SecurityException("ArrayBag is corrupt.");

        }
    }

    /**
     * 判断数组是否已经满了，可以继续插入
     *
     * @return
     */
    private boolean isArrayFull() {
        return numberOfEntries >= bag.length;
    }

    /**
     * Remove an unspecified entry from this bag if possible.
     *
     * @return Either the remove entry,if the removal was successful, no null.
     */
    @Override
    public T remove() {
        checkIntegrity();
        // T result = null;
        //if (numberOfEntries > 0) {
        //1.访问数组最后一项，以便它能被返回
        //  result = bag[numberOfEntries - 1];
        //2.将数组最后一项的元素设置为null;
        //  bag[numberOfEntries - 1] = null;
        //3.numberOfEntries减1
        //numberOfEntries--;
        // }
        T result = removeEntry(numberOfEntries - 1);
        return result;
        /**该种方法相对于上面的有区别：
         * numberOfEntries
         * result = bag[numberOfEntries];
         * bag[numberOfEntries] = null;
         *在这种情形下,数组和计数器不同步的情况还是有可能的。
         * 不管怎样,如果逻辑更复杂,则数组处理过程中可能会发生异常。
         * 这个中断将会导致已更新的计数器不准确。
         */
    }

    /**
     * Removes one occurrence of a given entry from this bag. if possible.
     *
     * @param anEntry The entry to be removed.
     * @return True if the remove is successful, or false if not.
     */
    @Override
    public boolean remove(T anEntry) {
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }

    /**
     * 实现指定数组的下标进行删除的私有方法。
     *
     * @param givenIndex
     * @return
     */
    private T removeEntry(int givenIndex) {
        T result = null;
        if (!isEmpty() && givenIndex >= 0) {
            //Entry to remove
            result = bag[givenIndex];
            //Replace ti with last entry
            bag[givenIndex] = bag[numberOfEntries - 1];
            //Remove last entry
            bag[numberOfEntries - 1] = null;
            //reduce number of element.
            numberOfEntries--;
        }
        return result;
    }

    /**
     * Locates a given entry within the array bag.
     *
     * @param anEntry
     * @return Return the index of the entry, if located,or -1 otherwise.
     */
    private int getIndexOf(T anEntry) {
        int where = -1;
        boolean found = false;
        int index = 0;
        while (!found && index < numberOfEntries) {
            if (anEntry.equals(bag[index])) {
                found = true;
                where = index;
            } else {
                index++;
            }
        }
        return where;

    }

    /**
     * Remove all entries from this bag.
     */
    @Override
    public void clear() {
        //如果数组不为空
        while (!isEmpty()) {
            //调用一个未指定项的删除方法
            remove();
        }

        //while (remove() != null){
        //该方法是不使用isEmpty。
        //}
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
        //设置一个计数器用来记录元素出现的次数
        int counter = 0;
        for (int index = 0; index < numberOfEntries; index++) {
            if (bag[index].equals(anEntry)) {
                counter++;
            }

        }

        return counter;
    }

    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry The entry to find.
     * @return True if the bag contains an entry,or false not.
     */
    @Override
    public boolean contains(T anEntry) {
        checkIntegrity();
        // boolean found = false;
        // int index = 0;
        //while (!found && index < numberOfEntries) {
        //   if (anEntry.equals(bag[index])) {
        //       found = true;
        //  } else {
        //index++;
        //    }
        //}
        //return found;
        return getIndexOf(anEntry) > -1;
    }

    /**
     * Retrieves all entries that are in this bag.
     *
     * @return Anewly allocated array of all the the entries in the bag.
     * Note: If the bag is empty.the returned array is empty.
     */
    @Override
    public T[] toArray() {
        //1.重新申请一个数组，返回给用户使用
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        //2.将bag中的元素复制到新数组中
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = bag[index];
        }
        return result;
    }
}
