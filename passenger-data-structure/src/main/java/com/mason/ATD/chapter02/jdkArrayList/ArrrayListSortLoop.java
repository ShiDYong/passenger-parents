package com.mason.ATD.chapter02.jdkArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 测试Arraylist的排序和迭代方法
 *
 * @author ShiYong
 * @create 2022-03-31 9:52
 **/
public class ArrrayListSortLoop {
    public static void main(String[] args) {
        // 创建一个动态数组
        ArrayList<String> sites = new ArrayList<>();

        sites.add("Runoob");
        sites.add("Google");
        sites.add("Wiki");
        sites.add("Taobao");
        System.out.println("网站列表: " + sites);

        System.out.println("不排序: " + sites);


        /**Collections 类也是一个非常有用的类，位于 java.util 包中，提供的 sort() 方法可以对字符或数字列表进行排序
         * sort() 方法根据指定的顺序对动态数组中的元素进行排序
         * sort() 方法不返回任何值，它只是更改动态数组列表中元素的顺序
         */
        //排序方法一：
        sites.sort(Comparator.naturalOrder());
        System.out.println("排序后: " + sites);
        //排序方法二：
        Collections.sort(sites);  // 字母排序
        for (String i : sites) {
            System.out.println(i);
        }
        System.out.println("。。。。。。。。。。。。。。。。数字排序。。。。。。。。。。。。。。。。。。。。。。。。。。。");
        ArrayList<Integer> myNumbers = new ArrayList<Integer>();
        myNumbers.add(33);
        myNumbers.add(15);
        myNumbers.add(20);
        myNumbers.add(34);
        myNumbers.add(8);
        myNumbers.add(12);
        Collections.sort(myNumbers);  // 数字排序
        for (int i : myNumbers) {
            System.out.println(i);
        }

        System.out.println(".........................数组的迭代.....................................................");

        // 我们可以使用 for 来迭代数组列表中的元素
        for (int index = 0; index < sites.size(); index++) {
            System.out.println(sites.get(index));

        }

        //使用forEach()方法用于遍历动态数组中每一个元素并执行特定操作
        // 创建一个数组
        ArrayList<Integer> numbers = new ArrayList<>();

        // 往数组中添加元素
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        System.out.println("ArrayList: " + numbers);

        // 所有元素乘以 10
        System.out.print("更新 ArrayList: ");

        // 将 lambda 表达式传递给 forEach
        numbers.forEach((e) -> {
            e = e * 10;
            System.out.print(e + " ");
        });
    }

}
