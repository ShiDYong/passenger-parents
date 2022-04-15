package com.mason.ATD.iterator;

import com.mason.ATD.List.ListInterface;

import java.util.Iterator;

/**
 * 链表组合实现的迭代器的测试类
 *
 * @author ShiYong
 * @create 2022-04-15 9:07
 **/
public class LinkedIteratorTest {
    public static void main(String[] args) {
        LinkedListWithIterator<String> myList = new LinkedListWithIterator<>();
        Iterator<String> bookIterator = myList.getIterator();
        myList.add("三国演义");
        myList.add("水浒传");
        myList.add("西游记");
        myList.add("红楼梦");
        System.out.println("hasnext()   " + bookIterator.hasNext());
        System.out.println("next()    " + bookIterator.next());
        bookIterator.remove();

    }
}
