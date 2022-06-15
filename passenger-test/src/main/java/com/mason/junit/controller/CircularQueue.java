package com.mason.junit.controller;

import com.mason.junit.exception.CircularQueueException;

import java.util.Arrays;

/**
 * @author Mason
 * @Description 通过循环数组实现一个简单循环队列
 * 队列做的一些契约定义：
 * 1.前置条件(put())：不允许将空元素添加到队列中;
 * 2.前置条件(用于put()):将元素放入到完整队列中是违法的；
 * 3.前置条件(用于get()):不能从空队列中获取元素是非法的;
 * 4.后置条件用于get()：不能从数组中生成空元素；
 * 5.不变性：包含对象的区域不能包含任何空元素；
 * 6.不变性：不包含对象的区域必须只有空值
 * @date 2022/5/24 21:31
 */
public class CircularQueue {

    private Object[] data;
    private int in = 0; //指示数组下一个对象的所在位置
    private int out = 0; //指示数组下一个对象的来自何处
    private boolean wrapped = false; //队列是满的

    public CircularQueue(int size) {
        data = new Object[size];
        assert invariant();
    }

    //队列是否已经已经满了
    public boolean full() {
        return wrapped && in == out;
    }

    //队列是否为空
    public boolean empty() {
        return !wrapped && in == out;
    }

    public void put(Object item) {
        precondition(item != null, "put() null item");
        precondition(!full(), "put() into full CircularQueue");
        assert invariant();
        data[in++] = item;
        if (in >= data.length) {
            in = 0;
            wrapped = true;
        }
        assert invariant();

    }


    // 出队
    public Object get() {
        precondition(!empty(), "get() from empty CircularQueue");
        assert invariant();
        Object returnVal = data[out];
        data[out] = null;
        out++;
        if (out >= data.length) {
            out = 0;
            wrapped = false;
        }
        assert postcondition(returnVal != null, "Null item in CircularQueue");
        assert invariant();
        return returnVal;

    }

    private static void precondition(boolean cond, String msg) {
        if (!cond) throw new CircularQueueException(msg);
    }

    private static boolean postcondition(boolean cond, String msg) {
        if (!cond) throw new CircularQueueException(msg);
        return true;
    }

    //检查数组是否初始化
    public boolean invariant() {
        for (int i = out; i != in; i = (i + 1) % data.length)
            if (data[i] == null)
                throw new CircularQueueException("null in CircularQueue");
        if (full()) return true;
        for (int i = in; i != out; i = (i + 1) % data.length)
            if (data[i] != null)
                throw new CircularQueueException("non-null outside of CircularQueue range:"
                        + dump());
        return true;
    }

    public String dump() {
        return "in = " + in + ", out = " + out
                + ", full() = " + full() + ", empty() = " + empty() +
                ", CircularQueue = " + Arrays.asList(data);

    }
}
