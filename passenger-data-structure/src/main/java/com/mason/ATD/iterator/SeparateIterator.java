package com.mason.ATD.iterator;

import com.mason.ATD.List.ListInterface;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * 实现独立迭代器
 *
 * @author ShiYong
 * @create 2022-04-14 17:04
 **/
public class SeparateIterator<T> implements Iterator<T> {
    //引用线性表中的操作
    private ListInterface<T> list;
    //记录迭代的位置
    private int nextPosition;
    //进行删除操作之前判断是否已经调用了next().
    private boolean wasNextCalled;


    public SeparateIterator(ListInterface<T> myList) {
        list = myList;
        nextPosition = 0;
        wasNextCalled = false;

    }

    /**
     * Returns true if the iteration has more elements. (In other words, returns true if next would return an element rather than throwing an exception.)
     * Returns:true if the iteration has more elements
     *
     * @return
     */
    @Override
    public boolean hasNext() {
        //类SeparateIterator不能直接访问操作线性表的类私有的数据域
        //它只是信息线性表的客户，所以只能使用线性表的ATD操作来处理线性表。
        return nextPosition < list.getLength();
    }

    /**
     * Returns:the next element in the iteration
     * Throws:NoSuchElementException – if the iteration has no more element
     *
     * @return
     */
    @Override
    public T next() {
        if (hasNext()) {
            wasNextCalled = true;
            nextPosition++;
            return list.getEntry(nextPosition);
        } else
            throw new NoSuchElementException("Illegal call to next(): " + "iterator is" +
                    "after end of list.");
    }

    /**
     * Removes from the underlying collection the last element returned by this iterator (optional operation). This method can be called only once per call to next.
     * The behavior of an iterator is unspecified if the underlying collection is modified while the iteration is in progress in any way other than by calling this method,
     * unless an overriding class has specified a concurrent modification policy.
     * The behavior of an iterator is unspecified if this method is called after a call to the forEachRemaining method.
     * Throws:UnsupportedOperationException – if the remove operation is not supported by this iterator
     * IllegalStateException – if the next method has not yet been called, or the remove method has already been called after the last call to the next method
     * Implementation Requirements:
     * The default implementation throws an instance of UnsupportedOperationException and performs no other action.
     */
    @Override
    public void remove() {
        if (wasNextCalled) {
            list.remove(nextPosition);
            nextPosition--;
            wasNextCalled = false;
        } else
            throw new NoSuchElementException("Illegal call to next(): " + "iterator is" +
                    "after end of list.");
    }

    /**
     * 独立迭代器总结如下：
     * 独立类选代器必须使用ADT的公有方法访问ADT的数据。
     * 但是,某些ADT,例如栈，没有提供足够的对其数据的公有访问方法,能让这样的选代器可行。
     * 而且，典型的独立类选代器要比其他类型的选代器花费更多的执行时间，因为它们不能直接访问ADT 的数据。
     * 另一方面，独立类选代器的实现通常很简单。对所给的ADT,可以同时有几个相互无关的独立类选代器存在。
     * 要为已经实现且其实现不会被修改的ADT提供一个选代器,或许需要定义一个独立类选代器
     */
}
