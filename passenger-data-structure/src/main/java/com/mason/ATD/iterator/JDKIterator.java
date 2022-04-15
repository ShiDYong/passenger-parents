package com.mason.ATD.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * JDK迭代器的实现测试
 *
 * @author ShiYong
 * @create 2022-04-15 16:22
 **/
public class JDKIterator {

    public static void main(String[] args) {
        List<String> it = new ArrayList<>();
        it.add("Google");
        it.add("Apple");
        it.add("HuaWei");
        it.add("Micsoft");
        //获取迭代器
        Iterator<String> iterator = it.iterator();
        // 输出集合中的第一个元素:next() 会返回迭代器的下一个元素，并且更新迭代器的状态
        System.out.println(iterator.next());
        //循环集合所有元素：调用 it.hasNext() 用于检测集合中是否还有元素
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("<<<<<<<<<<<<<<<<<<<<测试迭代器的删除>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(12);
        numbers.add(8);
        numbers.add(2);
        numbers.add(23);
        Iterator<Integer> its = numbers.iterator();
        while (its.hasNext()) {
            Integer i = its.next();
            if (i < 10) {
                its.remove();  // 删除小于 10 的元素
            }
        }
        System.out.println(numbers);
    }

}
