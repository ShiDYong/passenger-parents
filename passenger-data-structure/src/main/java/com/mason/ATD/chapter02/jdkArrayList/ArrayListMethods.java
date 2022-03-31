package com.mason.ATD.chapter02.jdkArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList的常用方法集合
 *
 * @author ShiYong
 * @create 2022-03-30 17:59
 **/
public class ArrayListMethods {
    public static void main(String[] args) {
        ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        // 1.通过索引值获取arraylist中的元素
        System.out.println(sites.get(1));

        // 2.替换arraylist中指定索引的元素
        sites.set(2,"WIKI");
        System.out.println(sites);

        //3.返回arraylist里元素的数量
        int size = sites.size();
        System.out.println(size);

        //4.判断arraylist是否为空
        boolean empty = sites.isEmpty();
        System.out.println("empty = " + empty);

        //5.判断元素是否在arraylist
        sites.add("WIKI");
        System.out.println("WIKI是否存在于arraylist中：");
        boolean result = sites.contains("WIKI");
        sites.add(null);
        //该方法只返回arraylist中找到的第一个元素
        boolean contains = sites.contains(null);
        System.out.println("contains = " + contains);

        //查看arraylist是否包含指定集合中的所有元素
        // 创建另一个动态数组
        ArrayList<String> sites2 = new ArrayList<>();
        // 往动态数组中添加元素
        sites2.add("Runoob");
        sites2.add("WIKI");
        boolean out = sites.containsAll(sites2);
        System.out.println("out = " + out);


        //6.将arraylist转换为数组
        // 创建一个新的 String 类型的数组
        // 数组长度和 ArrayList 长度一样
        String[] arr = new String[sites.size()];
        sites.toArray(arr);
        for (String item : arr) {
            System.out.print(item+",");
        }

        //7.将arraylist转换为字符串
        String list = sites2.toString();
        System.out.println("list = " + list);


    }
}
