package com.mason.ATD.iterator;

import com.mason.ATD.List.ListInterface;

import java.util.Iterator;

/**
 *  接口可以多继承
 * @author shiyong
 */
public interface ListWithIteratorInterface<T> extends ListInterface<T> ,Iterable<T> {

    /**
     * 返回接口iterator规范的一个迭代器
     * @return
     */
    public Iterator<T> getIterator();

}
