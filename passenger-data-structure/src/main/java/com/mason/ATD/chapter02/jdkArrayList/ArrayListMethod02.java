package com.mason.ATD.chapter02.jdkArrayList;

import java.util.ArrayList;

/**
 * 测试ArrayList的常用方法
 *
 * @author ShiYong
 * @create 2022-03-31 9:24
 **/
public class ArrayListMethod02 {
    public static void main(String[] args) {
    //1.返回动态数组中元素的索引值
        // 创建一个数组
        ArrayList<String> sites = new ArrayList<>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        System.out.println("网站列表: " + sites);
        // 查找位置索引值为 Runoob 的元素
        int position1 = sites.indexOf("Runoob");
        System.out.println("Runoob 的索引位置: " + position1);
        // 查找位置索引值为 Weibo 的元素
        int position2 = sites.indexOf("Weibo");
        System.out.println("Weibo 的索引位置: " + position2);
        /**
         * 从动态数组中返回指定元素的位置的索引值。
         * 如果 obj 元素在动态数组中重复出现，返回在数组中最先出现 obj 的元素索引值。
         * 如果动态数组中不存在指定的元素，则该 indexOf() 方法返回 -1。
         */
        sites.add("Google");
        int position3 = sites.indexOf("Google");
        System.out.println("position3 = " + position3);
        //返回指定元素在arraylist中最后一次出现的位置
        int lastPosition = sites.lastIndexOf("Google");
        System.out.println("lastPosition = " + lastPosition);


        System.out.println("........................截取功能...........................................");
        /**
         * fromIndex - 截取元素的起始位置，包含该索引位置元素
         * toIndex - 截取元素的结束位置，不包含该索引位置元素
         * 返回给定的动态数组截取的部分。
         * 如果fromIndex 小于 0 或大于数组的长度，则抛出 IndexOutOfBoundsException 的异常
         * 如果 fromIndex 大于 toIndex 的值则抛出 IllegalArgumentException 异常。
         * 注意：该动态数组包含的元素起始于 fromIndex 位置，直到元素索引位置为 toIndex-1，
         * 而索引位置 toIndex 的元素并不包括
         */
        System.out.println("Sublist:"+sites.subList(1,3));


        System.out.println("............................动态数组的替换方法...................................................");

        //将所有元素改为大写
        sites.replaceAll(e->e.toUpperCase());
        System.out.println("更新后的arraylist " + sites);;

    }
}
