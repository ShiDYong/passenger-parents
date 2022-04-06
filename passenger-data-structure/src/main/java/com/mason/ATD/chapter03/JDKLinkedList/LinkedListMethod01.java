package com.mason.ATD.chapter03.JDKLinkedList;

import org.w3c.dom.ls.LSInput;

import java.util.LinkedList;

/**
 * LinkedList常用的方法
 *
 * @author ShiYong
 * @create 2022-04-06 9:23
 **/
public class LinkedListMethod01 {
    public static void main(String[] args) {
        System.out.println(".......................链表的添加。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
        LinkedList<String> list = new LinkedList<>();
        /*1.链表末尾添加元素*/
        list.add("Google");
        list.add("Apple");
        list.add("Amazon");
        list.add("Alibaba");
        System.out.println("链表末尾添加元素：" + list);


        //2.向指定位置插入元素
        list.add(2, "Oracle");
        System.out.println("指定位置添加元素: " + list);


        //3.将元素插到头部
        list.addFirst("Tesla");
        System.out.println("将元素插到链表头部：" + list);


        //4.将元素添加到尾部
        list.addLast("HuaWei");
        System.out.println("将元素添加到尾部：" + list);

        //5.将一个集合的所欲元素添加到链表指定位置后面成功为true, 失败为否
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("1");
        list2.add("1");
        list2.add(null);
        list2.add("Apple");

        list.addAll(list2);
        System.out.println("将一个集合元素添加到链表的末尾：" + list);

        System.out.println(".......................链表的查询。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
        //1.判断是否含有某一个元素
        boolean result = list2.contains("1");
        boolean result2 = list2.contains(null);
        System.out.println("判断是有含有某个元素：" + result);
        System.out.println("判断是有含有某个元素：" + result2);

        //2.返回指定未指定元素
        String index = list.get(3);
        System.out.println("根据索引获取指定位置的元素：" + index);

        //3.返回第一个元素
        String first = list.getFirst();
        System.out.println("获取链表第一个元素：" + first);

        //4.指定元素从前往后第一次出现的索引
        int indexFirst = list.indexOf(null);
        System.out.println("元素出现的第一次索引：" + indexFirst);
        //查找元素最后一次出现的索引
        int lastIndex = list.lastIndexOf("Apple");
        System.out.println("元素最后一次出现的索引：" + lastIndex);


        System.out.println(".......................链表的删除。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");

        //1.设置指定位置的元素
        String speiciedLocation = list.set(2, "DJI");
        System.out.println("指定替换元素：" + speiciedLocation);
        System.out.println(list);


        //2.删除并返回第一个元素
        String deleteFirst = list.removeFirst();
        System.out.println("删除并返回第一个元素：" + deleteFirst);

        //3.删除并返回最后一个元素
        String lastNode = list.removeLast();
        System.out.println("删除并返回链表中最后一个元素：" + lastNode);

        //4.删除某一个元素，返回是否成功，成功为true,失败为false.这个要稍微分析一下
        boolean removeNode = list.remove("DJI");
        System.out.println("删除链表中的某一个元素：" + removeNode);
        //5.删除指定位置的元素
        String remove = list.remove(2);
        System.out.println("删除指定位置的元素：" + remove);

        //6.清楚的链表中的所有元素
        list.clear();
        System.out.println("执行clear方法：" + list);

    }
}
