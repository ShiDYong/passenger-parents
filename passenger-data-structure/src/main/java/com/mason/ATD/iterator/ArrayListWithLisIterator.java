package com.mason.ATD.iterator;

import com.mason.ATD.List.EmptyArrayException;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * 迭代的实现方式
 *
 * @author ShiYong
 * @create 2022-04-15 14:38
 **/
public class ArrayListWithLisIterator<T> implements ArrayListWithLisIteratInterface<T> {
    //一个对象数组
    private T[] list;
    //记录线性表中项的个数的整数
    private int numberOfEntries;
    //定义线性表默认容量的整型常数
    private final static int DEFAULT_CAPACITY = 25;
    //定义线性表最大容量的整型常数
    private static final int MAX_CAPACITY = 10000;
    //表示线性表是否已经正确初始化的布尔标志,有助于提升安全性
    private boolean integrityOK;


    public ArrayListWithLisIterator() {
        this(DEFAULT_CAPACITY);  //call the next Constructor
    }

    public ArrayListWithLisIterator(int initialCapacity) {
        integrityOK = false;
        if (initialCapacity < DEFAULT_CAPACITY)
            initialCapacity = DEFAULT_CAPACITY;
        else
            checkCapacity(initialCapacity);
        T[] tempList = (T[]) new Object[initialCapacity + 1];
        list = tempList;
        numberOfEntries = 0;
        integrityOK = true;


    }


    /**
     * 将newEntry添加到线性表尾
     *
     * @param newEntry The object to be added as a new entry.
     */
    @Override
    public void add(T newEntry) {
        //isIntegrityOk();
        //list[numberOfEntries + 1] = newEntry;
        // numberOfEntries++;
        /**
         * 这里ensureCapacity位置和前面不一样的原因考虑：
         * 设计决策:方法add 应当何时调用 ensureCapacity?
         * 之前分别在第2章和第6章给出的类ArrayBag和ArrayStack中所定义的,将项添加到基于数组的包和栈的方法,
         * 能确保在向数组中添加其他的项之前,数组有足够的容量。所以,向数组中进行添加操作时,
         * 或许必须要等待有一个更大的数组可用时。不过,当添加操作让数组变满时,在下一次调用add时才扩展数组对于线性表,我们采用相反的方法。
         * 我们选择在向数组添加另外一项后，通过调用ensureCapacity 来修改数组的容量。
         * 因为构造方法创建的数组有足够的空间,至能应对第一次的添加,而我们可以在添加操作装满数组后立即扩大数组。
         * 所以,数组永远为接收下一项做好了准备。不过如果没有出现再一次的添加,则数组扩展就是不必要的。
         * 在本书目前介绍的情况下,调用ensureCapacity的时间点无关紧要。但是，同时执行某些任务或称并行,是当今可行及常见的技术。
         * 对于后调用ensureCapacity,可以将其作为一个独立的线程(thread)让数组在后台扩展。
         * 这能让方法add返回，故数组扩展时客户可继续执行其他的代码。使用这种方式,可以确保当客户必须添加一项时有足够的数组容量,且不会延迟。
         * 但创建一个独立的线程不在我们讨论的范围内注:因为AList的每个构造方法都创建了容量至少是DEFAULT_CAPACITY的线性表,
         * 所以方法add可以假定,至少对线性表的第一次添加,数组有足够的空间。
         */
        //ensureCapacity();
        /**
         * 方法二直接调用第二个方法
         * 优势：易于实现这个 add 方法。如果另一个 add 方法是正确的，这个代码更容易正确。
         * 不足：：调用另一个方法，花费了更多的运行时间。另外，第二个 add 方法必须决定当被第一个 add
         * 方法调用时它不调用 makeRoom。
         */
        //通常数组的下标都是从0开始的，这是因为初始化的为0，比较方便，但是为了方便阅读只要在数组插入的
        //的时候把数据放在第1位，0位就属于空的状态，方便阅读也是可以的。
        add(numberOfEntries + 1, newEntry);

    }

    private void ensureCapacity() {
        //获取当前数组的容量
        int capacity = list.length - 1;
        if (capacity <= numberOfEntries) {
            //进行扩容2倍
            int newCapacity = capacity << 1;
            checkCapacity(newCapacity);

            //通过迭代方法实现数组元素的复制
            //T[] newList = (T[]) new Object[newCapacity + 1];
            //for (int index = 0; index < numberOfEntries; index++) {
            //    newList[index] = list[index + 1];
            //}
            //list = newList;
            //利用JDK提供的数组复制方法
            list = Arrays.copyOf(list, newCapacity + 1);


        }
    }

    /**
     * 将newEntry添加到线性表的newPosition处，位置1表示线性表的第一项
     *
     * @param givenPosition An integer that specified the deisred position of the new entry
     * @param newEntry      The object to be added as a new entry.
     *                      如果在操作前newPosition是这个线性表中的无效位置，则抛出一个异常
     */
    @Override
    public void add(int givenPosition, T newEntry) {
        isIntegrityOk();
        //if ((givenPosition >= 1) && (givenPosition <= getLength() + 1)) {
        checkIndex(givenPosition);
        //索引在numberOfEntries和1之间，需要发生数据挪动
        if (givenPosition <= numberOfEntries)
            makeRoom(givenPosition);
        /**
         * 为什么要挪动数组，保持数据的连续性，因为添加或者删除中间不挪动数组的话的
         * 就会导致中间的有一个项是Null，那么就要用其它的变量去表示这个空的项，会带来很多的麻烦的，
         * 所以要保持数组的项的连续性
         */
        list[givenPosition] = newEntry;
        numberOfEntries++;
        ensureCapacity();

        // } else
        //    throw new IndexOutOfBoundsException(
        //           "Given positon of add's new entry is out of bounds.");


    }

    /**
     * Makes room for a new entry at newPosition.
     * Precondition: 1 <= newPosition <= numberOfEntries+1;
     * numberOfEntries is list's length before additon;
     * isIntegrityOk has been called.
     *
     * @param newPosition
     */
    private void makeRoom(int newPosition) {
        // assert (newPosition >= 1) && (newPosition <= numberOfEntries + 1);
        int newIndex = newPosition;
        int lastIndex = numberOfEntries;
        for (int index = lastIndex; index >= newIndex; index--) {
            //从newPositon位置的数据往后挪动一位
            list[index + 1] = list[index];

        }

    }

    /**
     * 删除并返回指定位置的项
     *
     * @param givenPosition An integer that indicates the position of the entry to be removed.
     * @return 返回被删除的项，如果指定的索引是线性表中的无效位置则抛出一个异常，注意操作前如果线性表是空的，则任何的删除
     * 操作都是无效的。
     */
    @Override
    public T remove(int givenPosition) {
        isIntegrityOk();
        //  if ((givenPosition >= 1) && (givenPosition <= getLength() + 1)) {
        checkIndex(givenPosition);
        T result = list[givenPosition];
        if (givenPosition < numberOfEntries)
            removeGap(givenPosition);
        list[numberOfEntries] = null;
        numberOfEntries--;
        return result;
        //} else
        //  throw new IndexOutOfBoundsException("I11egal position given to remove operation");

    }

    private void removeGap(int givenPosition) {

        int removeIndex = givenPosition;
        for (int index = removeIndex; index < numberOfEntries; index++) {
            //将数组元素从给定位置向前挪动
            list[index] = list[index + 1];

        }

    }

    /**
     * 从线性表中删除所有内容
     */
    @Override
    public void clear() {
        isIntegrityOk();
        if (isEmpty())
            throw new EmptyArrayException();
        //1.以下方法实现将线性表置为null，方便垃圾回收
        for (int index = 0; index < numberOfEntries; index++) {
            list[index + 1] = null;
        }
        //2.如果没有将数组的个数置为0，则个项的值都为null.
        numberOfEntries = 0;

        //使用方法二:
        // while (!isEmpty())
        //     remove(numberOfEntries);

    }

    /**
     * 指定位置进行替换操作
     *
     * @param givenPosition An integer that indicates the position of the entry to be replaced.
     * @param newEntry      The object that will replace the entry at the postion givenPosition.
     * @return 成功返回被替换的项，如果指定索引是线性表中无效的位置，则抛出一个异常。
     */
    @Override
    public T replace(int givenPosition, T newEntry) {
        isIntegrityOk();

        T oldEntry = list[givenPosition];
        list[givenPosition] = newEntry;
        return oldEntry;


    }

    /**
     * 获取指定索引处的项或者元素
     *
     * @param givenPosition An integer that indecates the position of the desired entry.
     * @return
     */
    @Override
    public T getEntry(int givenPosition) {
        isIntegrityOk();
        boolean find = false;
        checkIndex(givenPosition);
        return list[givenPosition];
    }

    /**
     * 检查数组是否出现越界
     *
     * @param givenPosition
     */
    private void checkIndex(int givenPosition) {
        if ((givenPosition < 1) || (givenPosition > getLength() + 1))
            throw new IndexOutOfBoundsException("I11egal position given to remove operation");


    }

    /**
     * 按项在线性表中出现的次序获取表中的所有项
     *
     * @return 返回含有显性表中当前项的新数组
     */
    @Override
    public T[] toArray() {
        isIntegrityOk();
        T[] result = (T[]) new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = list[index + 1];

        }
        return result;
    }

    /**
     * 查看线性表中是否含有指定的项
     *
     * @param anEntry The object that is the desired entry.
     * @return 成功返回true，失败返回false.
     */
    @Override
    public boolean contain(T anEntry) {
        isIntegrityOk();
        boolean found = false;
        int index = 1;
        //  for (int index = 1; index < getLength(); index++) {
        //if (anEntry.equals(list[index]) && !found)
        //      find = true;

        //}
        while (!found && (index <= numberOfEntries)) {
            if (anEntry.equals(list[index]))
                found = true;
            index++;
        }
        return found;
    }

    /**
     * 得到线性表中的项的个数
     *
     * @return 返回线性表中当前项的个数
     */
    @Override
    public int getLength() {
        return numberOfEntries;
    }

    /**
     * 检查线性表是否为空
     *
     * @return 如果线性表为空，则返回真，否则返回假。
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /**
     * 校验参数是否超过线性表的最大容量值
     *
     * @param initialCapacity
     */
    private void checkCapacity(int initialCapacity) {
        if (initialCapacity > MAX_CAPACITY)
            throw new IllegalStateException("Attemp to create a array whose capacity exceed allowed maximum");

    }

    /**
     * 检查数组是否初始化符号位
     */
    private void isIntegrityOk() {
        if (!integrityOK)
            throw new SecurityException("ArrayBag is corrupt.");
    }


    @Override
    public ListIterator getIterator() {
        return new ListIteratorForArrayList();
    }

    @Override
    public Iterator iterator() {
        return getIterator();
    }

    private class ListIteratorForArrayList implements ListIterator<T> {
        private boolean isRemoveOrSetLegal;
        private int intIndex;
        private Move lastMove;

        private enum Move {NEXT, PREVIOUS}

        private ListIteratorForArrayList() {
            intIndex = 1;
            isRemoveOrSetLegal = false;
            lastMove = null;
        }


        @Override
        public boolean hasNext() {
            return intIndex <= numberOfEntries;
        }

        /**
         * Returns the next element in the list and advances the cursor position.
         * This method may be called repeatedly to iterate through the list,
         * or intermixed with calls to previous to go back and forth.
         * (Note that alternating calls to next and previous will return the same element repeatedly.)
         *
         * @Returns: the next element in the list
         * @Throws:NoSuchElementException – if the iteration has no next elemen
         */
        @Override
        public T next() {
            if (hasNext()) {
                lastMove = Move.NEXT;
                isRemoveOrSetLegal = true;
                T nextEntry = list[intIndex];
                intIndex++;
                return nextEntry;
            } else
                throw new NoSuchElementException("Illegal call to next();" +
                        "iterator is after end of list.");


        }

        /**
         * Returns true if this list iterator has more elements when traversing the list
         * in the reverse direction. (In other words,
         * returns true if previous would return an element rather than throwing an exception.)
         *
         * @Returns: the previous element in the list
         * @Throws:NoSuchElementException – if the iteration has no previous element
         */
        @Override
        public boolean hasPrevious() {
            return (intIndex > 1) && (intIndex <= numberOfEntries + 1);
        }

        /**
         * Returns the previous element in the list and moves the cursor position backwards.
         * This method may be called repeatedly to iterate through the list backwards,
         * or intermixed with calls to next to go back and forth.
         * (Note that alternating calls to next and previous will return the same element repeatedly.)
         *
         * @return:the previous element in the list
         * @Throws:NoSuchElementException – if the iteration has no previous element
         */
        @Override
        public T previous() {
            if (hasPrevious()) {
                lastMove = Move.PREVIOUS;
                isRemoveOrSetLegal = true;
                T result = list[intIndex - 1];
                intIndex--;
                return result;
            } else
                throw new NoSuchElementException("Illegal call to previous();" +
                        "iterator is after end of list.");

        }

        /**
         * Returns the index of the element that would be returned by a subsequent call to next.
         * (Returns list size if the list iterator is at the end of the list.)
         *
         * @Returns:the index of the element that would be returned by a subsequent call to next,
         * or list size if the list iterator is at the end of the list
         */
        @Override
        public int nextIndex() {
            int result;
            if (hasNext())
                result = intIndex - 1;
            else
                result = numberOfEntries;
            return result;
        }

        /**
         * Returns the index of the element that would be returned by a subsequent call to previous.
         * (Returns -1 if the list iterator is at the beginning of the list.)
         *
         * @Returns:the index of the element that would be returned by a subsequent call to previous,
         * or -1 if the list iterator is at the beginning of the list
         */
        @Override
        public int previousIndex() {
            int result;
            if (hasPrevious())
                result = intIndex - 2;
            else
                result = -1;
            return result;
        }

        /**
         * Removes from the list the last element that was returned by next or previous
         * (optional operation).
         * This call can only be made once per call to next or previous.
         * It can be made only if add has not been called after the last call to next or previous.
         *
         * @Throws:UnsupportedOperationException – if the remove operation is not supported by this list iterator
         * IllegalStateException – if neither next nor previous have been called,
         * or remove or add have been called after the last call to next or previous
         */
        @Override
        public void remove() {
            if (isRemoveOrSetLegal) {
                isRemoveOrSetLegal = false;
                if (lastMove.equals(Move.NEXT)) {
                    ArrayListWithLisIterator.this.remove(intIndex - 1);
                    intIndex--;
                } else
                    ArrayListWithLisIterator.this.remove(intIndex);
            } else
                throw new IllegalStateException("I11egal call to remove (): " + "next() or previous() was not called, OR" +
                        "add() or remove () called since then. ");


        }

        /**
         * Replaces the last element returned by next or previous with the specified element (optional operation).
         * This call can be made only if neither remove nor add have been called after the last call to next or previous.
         *
         * @Params:e – the element with which to replace the last element returned
         * by next or previous
         * @Throws: UnsupportedOperationException – if the set operation is not supported by this list iterator
         * ClassCastException – if the class of the specified element prevents it from being added to this list
         * IllegalArgumentException – if some aspect of the specified element prevents it from being added to this list
         * IllegalStateException – if neither next nor previous have been called,
         * or remove or add have been called after the last call to next or previous
         */

        @Override
        public void set(T t) {
            if (isRemoveOrSetLegal) {
                if (lastMove.equals(Move.NEXT)) {
                    list[nextIndex() - 1] = t;
                } else {
                    list[intIndex] = t;
                }
            } else
                throw new IllegalStateException("IT1egal call to set (): " + "next () or previous () was not called, OR " +
                        "add () or remove () called since then. ");

        }

        /**
         * Inserts the specified element into the list (optional operation).
         * The element is inserted immediately before the element that would be returned by next,
         * if any, and after the element that would be returned by previous, if any.
         * (If the list contains no elements, the new element becomes the sole element on the list.)
         * The new element is inserted before the implicit cursor: a subsequent call to next
         * would be unaffected, and a subsequent call to previous would return the new element.
         * (This call increases by one the value that would be returned by a call to
         * nextIndex or previousIndex.)
         *
         * @Params:e – the element to insert
         * @Throws:UnsupportedOperationException – if the add method is not supported by
         * this list iteratorClassCastException – if the class of the specified element
         * prevents it from being added to this list
         * IllegalArgumentException – if some aspect of this element prevents it
         * from being added to this list
         */
        @Override
        public void add(T t) {
            isRemoveOrSetLegal = false;
            ArrayListWithLisIterator.this.add(intIndex, t);
            intIndex++;

        }
    }
}
