package com.mason.leetcode.sorting;

/**
 * 插入排序的实现
 *
 * @author ShiYong
 * @create 2022-02-25 15:27
 **/
public class InsertionSort {

    public static void main(String[] args) {
        int[] a = {7, 5, 6, 1, 2, 3};
        //排序前
        System.out.print("原始数组：");
        printArray(a);
        //进行排序
        insertionSort(a);
        System.out.println("升序排序后：");

        //排序后
        printArray(a);

    }


    public static void insertionSort(int[] a) {

        /*




         */

        if (a.length <= 1) return;
        int length = a.length;

        for (int i = 0; i < length; i++) {

            int value = a[i];
            int j = i - 1;
            //查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    //进行数据挪动
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            //插入数据
            a[j + 1] = value;

        }


    }

    //对数组 进行打印的方法
    public static void printArray(int[] arr) {
        System.out.println("[");
        for (int x = 0; x < arr.length; x++) {
            if (x != arr.length - 1) {
                System.out.print(arr[x]+",");
            } else {
                System.out.print(arr[x]+"]");
            }
        }
    }
}
