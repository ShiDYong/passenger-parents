package com.mason.ATD.chapter07.recursive;

/**
 * 递归在数组中的运用
 *
 * @author ShiYong
 * @create 2022-04-12 15:13
 **/
public class ArrayRecursive {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6};
//        displayArray(arr, 0, arr.length - 1);
        dispalyArray03(arr, 0, arr.length - 1);

    }


    /**
     * 通过递归实现对数组的所有元素的显示
     *
     * @param array 传入的数组
     * @param first 数组的下标
     * @param last  数组的尾索引
     */
    public static void displayArray(int array[], int first, int last) {
        System.out.println(array[first] + "");
        if (first < last)
            displayArray(array, first + 1, last);
    }

    public static void dispalyArray02(int[] array, int first, int last) {
        if (first <= last) {
            dispalyArray02(array, first, last - 1);
            System.out.println(array[last] + " ");
        }
    }

    /**
     * 将数组分半实现对素组所有元素的显示
     * @param array
     * @param first
     * @param last
     */
    public static void dispalyArray03(int[] array, int first, int last) {
        if (first == last)
            System.out.print(array[first] + " ");
        else {
            int mid = (first + last) / 2;
            dispalyArray03(array, first, mid);
            dispalyArray03(array, mid + 1, last);
        }
    }
}
