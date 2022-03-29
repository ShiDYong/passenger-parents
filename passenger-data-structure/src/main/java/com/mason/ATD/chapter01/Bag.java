package com.mason.ATD.chapter01;

import com.mason.ATD.chapter01.BagInterface;

/**
 * BagInterface的实现类
 *
 * @author ShiYong
 * @create 2022-03-28 14:57
 **/
public class Bag implements BagInterface {

    @Override
    public int getCurrentSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean add(Object entry) {
        return false;
    }

    @Override
    public Object remove() {
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
    public Object[] toArray() {
        return new Object[0];
    }
}
