package com.mason.ATD.iterator;

import com.mason.ATD.List.ListInterface;

import java.util.ListIterator;

public interface ArrayListWithLisIteratInterface<T> extends Iterable<T>, ListInterface<T> {
    /**
     * 返回LisIterator接口实例
     * @return
     */
    public ListIterator getIterator();
}
