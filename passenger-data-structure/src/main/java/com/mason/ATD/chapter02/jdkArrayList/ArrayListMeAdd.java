package com.mason.ATD.chapter02.jdkArrayList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Arraylist常用的方法
 *
 * @author ShiYong
 * @create 2022-03-30 16:02
 **/
public class ArrayListMeAdd {
    public static void main(String[] args) {
        //1.不指定数组的容量初始化
        List<String> myList = new ArrayList<>();
        //2.指定数组的容量初始化测试
        //List<String> myList2 = new ArrayList<>(900000000);
        List<String> myList2 = new ArrayList<>(50);
        //3.添加单个元素的方法,默认插入的数组的末尾
        myList.add("Mason");
        myList.add("Google");
        myList2.add("Apple");
        myList2.add("Micsoft");

        //根据索引插入元素
        myList.add(1,"Taobao");
        myList2.add(0,"Tesla");
        System.out.println(myList);
        System.out.println(myList2);

        System.out.println(".............................................................");
        //使用addAll()方法
        // 创建一个动态数组
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        // 往动态数组里添加元素
        primeNumbers.add(3);
        primeNumbers.add(5);
        System.out.println("Prime Numbers: " + primeNumbers);
        // 创建另外的一个动态数组
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        // 把 primeNumbers 的所有元素添加到 numbers 的动态数组中
        numbers.addAll(primeNumbers);
        System.out.println("Numbers: " + numbers);

        ArrayList<String> languages1 = new ArrayList<>();
        languages1.add("Java");
        languages1.add("Python");
        System.out.println("ArrayList 1: " + languages1);
        System.out.println("...............................指定位置插入.......................................");
        // 创建另一个数组
        ArrayList<String> languages2 = new ArrayList<>();
        languages2.add("JavaScript");
        languages2.add("C");
        System.out.println("ArrayList 2: " + languages2);

        // 在索引值为1的位置将数组 languages1 的所有元素添加到 languages2
        languages2.addAll(1, languages1);
        System.out.println("更新 ArrayList 2: " + languages2);

        System.out.println("............................将集合Set中的元素插入到动态数组中.......................................................");
        // 创建一个String类型的hashset
        HashSet<String> set = new HashSet<>();

        // 往hashset中添加元素
        set.add("Java");
        set.add("Python");
        set.add("JavaScript");
        System.out.println("HashSet: " + set);

        // 创建一个数组
        ArrayList<String> list = new ArrayList<>();

        // 往数组中添加元素
        list.add("English");
        System.out.println("初始化 ArrayList: " + list);

        //  hashset中所有的元素添加至数组中
        list.addAll(set);
        System.out.println("更新 ArrayList: " + list);

    }


}
