package com.mason.ATD.chapter04.base;

/**
 * list的抽象类
 *
 * @author ShiYong
 * @create 2022-03-31 17:00
 **/
public abstract class AbstractList<E> implements List<E> {
    /**
     * 元素的数量
     */
    protected int size;

    /**
     * 获取元素的数量
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 不指定添加元素
     *
     * @param element
     */
    @Override
    public void add(E element) {
        add(size, element);
    }
    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }
    /**
     * 列表是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 判断是否越界
     *
     * @param index
     */
    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);

    }

    /**
     * 判断索引的范围
     *
     * @param index
     */
    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size){
            outOfBounds(index);
        }
    }

}
