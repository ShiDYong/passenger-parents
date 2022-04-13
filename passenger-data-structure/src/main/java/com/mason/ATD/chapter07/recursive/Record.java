package com.mason.ATD.chapter07.recursive;

/**
 * 栈记录对象
 *
 * @author ShiYong
 * @create 2022-04-13 10:32
 **/
public class Record {
    private int first;
    private int last;

    public Record(int first, int last) {
        this.first = first;
        this.last = last;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }
}
