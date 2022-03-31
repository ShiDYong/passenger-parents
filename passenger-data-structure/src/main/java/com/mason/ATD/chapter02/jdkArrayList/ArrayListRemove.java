package com.mason.ATD.chapter02.jdkArrayList;

import java.util.ArrayList;

/**
 * ArrayList的删除操作
 *
 * @author ShiYong
 * @create 2022-03-30 17:21
 **/
public class ArrayListRemove {
    public static void main(String[] args) {
        ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        //删除指定元素,找不到返回false,一般都是删除第一个找到的元素就删除，后面就不删除
        sites.remove("Taobao");
        // 删除指定索引位置的元素，如果传入索引值，则返回删除的元素。
        String  removeElement = sites.remove(2);
        System.out.println("removeElement = " + removeElement);

        System.out.println(sites);
        System.out.println(".........................................删除arraylist所有满足特定条件的数组元素.................................................................");
        // 删除名称中带有 Tao 的元素
        sites.add("TaoTe");
        sites.add("TaoDong");
        sites.removeIf(e -> e.contains("Tao"));;
        System.out.println("删除后的 ArrayList: " + sites);

        System.out.println("....................................删除所有的元素..................................");
        // 创建一个数组
        ArrayList<String> sites02 = new ArrayList<>();

        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        System.out.println("网站列表: " + sites);

        // 删除所有元素
        sites.removeAll(sites);
        System.out.println("所有 removeAll() 方法后: " + sites);
        /**
         * 在上面实例中，我们创建了一个名为 oddNumbers 的动态数组，然后使用 removeAll() 方法删除数组中所有的元素。
         * removeAll() 和 clear() 方法功能都是一样都。但是 clear() 方法的比 removeAll() 更常被用到，
         * 因为 clear() 比 removeAll() 更快，更高效。
         */

        System.out.println("。。。。。。。。。。。。。。。。。。。。。。。使用clear删除所有数组元素。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
        // 创建一个数组
        ArrayList<String> sites03 = new ArrayList<>();

        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        System.out.println("网站列表: " + sites);

        // 删除所有元素
        sites.clear();
        System.out.println("所有 clear() 方法后: " + sites03);



    }
}
