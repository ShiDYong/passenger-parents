package com.mason.ATD.listsAndInheritance;

/**
 * 实现有序列表
 *
 * @author ShiYong
 * @create 2022-04-22 16:35
 **/
public class LinkedChainSortedList<T extends Comparable<?super T>> extends LinkedChainBase<T> implements SortedListInterface<T>  {


    @Override
    public void add(T newEntry) {

    }

    @Override
    public boolean remove(T anEntry) {
        return false;
    }

    @Override
    public int getPosition(T anEntry) {
        return 0;
    }

    @Override
    public T getEntry(int givenPosition) {
        return null;
    }

    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    @Override
    public T remove(int givenPosition) {
        return null;
    }

    @Override
    public int getLength() {
        return 0;
    }
}
