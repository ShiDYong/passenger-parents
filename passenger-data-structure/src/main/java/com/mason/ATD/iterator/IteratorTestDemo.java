package com.mason.ATD.iterator;

import com.mason.ATD.List.LList;
import com.mason.ATD.List.ListInterface;

import java.util.Iterator;

/**
 * 迭代器测试类
 *
 * @author ShiYong
 * @create 2022-04-14 17:23
 **/
public class IteratorTestDemo {
    public static void main(String[] args) {
        System.out.println("测试独立迭代器的基本功能");
        ListInterface<String> nameList = new LList<>();
        //创建一个迭代对象
        Iterator<String> nameIterator = new SeparateIterator<>(nameList);
        nameList.add("Json");
        nameList.add("Mason");
        nameList.add("Tom");
        nameList.add("Hanlen");
        //1.测试：hasNext()方法
        System.out.println("hasnext       " + nameIterator.hasNext());
        System.out.println("next       " + nameIterator.next());
        //进行迭代删除操作
        nameIterator.remove();
        //打印线性表
        displayList(nameList);


    }

    /**
     * 显示所有线性表的项
     *
     * @param list
     */
    public static void displayList(ListInterface<String> list) {
        System.out.println("The list contains " + list.getLength() +
                " entries, as follows:");
        Object[] listLinked = list.toArray();
        for (int index = 0; index < listLinked.length; index++) {
            System.out.print(listLinked[index] + " ");
        } // end for
        System.out.println();
    } // end d
}
