package com.mason.ATD.sortedList;

import com.mason.ATD.List.LList;
import com.mason.ATD.List.ListInterface;

import javax.management.relation.RelationSupport;

/**
 * 通过组合实现对使用线性表的功能
 * An implementation of the ADT sorted list that uses the ADT list.
 *
 * @author ShiYong
 * @create 2022-04-21 15:25
 **/
public class SortedList<T extends Comparable<? super T>> implements SortedListInterface<T> {

    //通过组合方式，利用线性表的功能，达到代码的复用
    private ListInterface<T> list;

    public SortedList() {
        list = new LList<>();
    }


    @Override
    public void add(T newEntry) {
        //查看返回值是否小于0则返回负数
        int newPostion = Math.abs(getPosition(newEntry));
        list.add(newPostion, newEntry);

    }


    @Override
    public boolean remove(T anEntry) {
        boolean result = false;
        int position = getPosition(anEntry);
        if (position > 0) {
            //删除的是有序表中第一次出现的项或者元素
            list.remove(position);
            result = true;
        }
        return result;
    }

    @Override
    public int getPosition(T anEntry) {
        int position = 1;
        int length = list.getLength();
        //查找anEntry在有序列表中的位置
        while ((position <= length) && (anEntry.compareTo(list.getEntry(position)) > 0)) {
            position++;
        }
        //查看anEntry是否在有序表中
        if ((position > length) || (anEntry.compareTo(list.getEntry(position)) != 0)) {
            position = -position; //没有找到anEntry
        }

        return position;
    }

    @Override
    public T remove(int givenPosition) {

        return list.remove(givenPosition);
    }

    @Override
    public T getEntry(int givenPosition) {
        return list.getEntry(givenPosition);
    }

    @Override
    public T[] toArray() {
        return list.toArray();
    }

    @Override
    public boolean contain(T anEntry) {
        return list.contain(anEntry);
    }

    @Override
    public int getLength() {
        return list.getLength();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clear() {
        list.clear();
    }
}
