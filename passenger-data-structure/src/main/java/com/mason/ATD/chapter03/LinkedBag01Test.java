package com.mason.ATD.chapter03;


import com.mason.ATD.chapter02.BagInterface;

import java.util.LinkedList;
import java.util.SimpleTimeZone;

/**
 * LinedBag01的测试类
 *
 * @author ShiYong
 * @create 2022-03-31 13:40
 **/
public class LinkedBag01Test {
    public static void main(String[] args) {
        BagInterface<String> myList = new LinedBag01<>();
        myList.add("Google");
        myList.add("AMAZON");
        myList.add("APPLE");

        int size = myList.getCurrentSize();
        System.out.println("size = " + size);
        int result = myList.getFrequencyOf("Google");
        System.out.println("result = " + result);
        boolean empty = myList.isEmpty();
        System.out.println("empty = " + empty);
        boolean apple = myList.remove("APPLE");
        System.out.println("apple = " + apple);
        myList.clear();



    }

}





