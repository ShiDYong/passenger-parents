package com.mason.ATD.listsAndInheritance;

import java.util.Arrays;

/**
 * @author Mason
 * @Description 单链表实现的线性表和有序表通过继承方式实现代码的复用的测试类
 * @date 2022/4/22 23:50
 */
public class ListAndInheritanceTest {
    public static void main(String[] args) {
        LinkedChainList<String> linkedChainList = new LinkedChainList<>();
        //测试添加
        linkedChainList.add("广州");
        linkedChainList.add("深圳");
        linkedChainList.add("北京");
        linkedChainList.add(1,"东莞");
        System.out.println(linkedChainList.getEntry(2));
        linkedChainList.replace(4,"上海");
        System.out.println(linkedChainList.contain("深圳"));
        //不止如何使用这个方法
   //    String[] strings =(String[]) linkedChainList.toArray();
        linkedChainList.clear();

       // Arrays.toString(strings);

        //测试删除
        System.out.println(linkedChainList.remove(2));

    }

}
