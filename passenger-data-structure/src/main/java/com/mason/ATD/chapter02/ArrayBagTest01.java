package com.mason.ATD.chapter02;


import java.util.zip.DeflaterInputStream;

/**
 * 测试ArrayBag类的核心方法的程序
 * A test of the constructors and the methods
 * add and toArray, as defined in the first
 * draft of the class ArrayBag.
 *
 * @author ShiYong
 * @create 2022-03-29 15:40
 **/
public class ArrayBagTest01 {

    public static void main(String[] args) {
        ArrayBag<String> bBag = new ArrayBag<>();
        displayBag(bBag);

        System.out.println("Test an initially empty bag with " + "sufficient capacity:");
        //不指定初始化数组容量大小
        BagInterface<String> aBag = new ArrayBag<>();
        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        testAdd(aBag, contentsOfBag1);


        // Filling an initially empty bag to capacity
        System.out.println("InTesting an initially empty bag that " + " wi11 be filled to capacity: ");
        //初始化指定数组容量大小
        aBag = new ArrayBag<>(7);
        String[] contentsOfBag2={"A","B","A","C","B","C","D","another string"};
        testAdd(aBag,contentsOfBag2);


    }

    /**
     * Tests the method add
     *
     * @param aBag
     * @param content
     */
    public static void testAdd(BagInterface<String> aBag, String[] content) {
        System.out.print("Adding the following strings to the bag:");
        for (int index = 0; index < content.length; index++) {
            if (aBag.add(content[index])) {
                System.out.print(content[index] + "");
            } else {
                System.out.print("\nUnable to add " + content[index] +
                        "to the bag.");
            }
            System.out.println();
        }
        displayBag(aBag);
    }


    private static void displayBag(BagInterface<String> aBag) {
        System.out.println("The bag contains the following stirng(s):");
        Object[] bagArray = aBag.toArray();
        for (int index = 0; index < bagArray.length; index++) {
            System.out.print(bagArray[index] + " ");

        }
        System.out.println();
    }
}
