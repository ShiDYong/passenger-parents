package com.mason.leetcode.orders;

/**
 * 实现快速排序
 *
 * @author ShiYong
 * @create 2022-03-01 16:49
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {49, 38, 65, 97, 13, 27};
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);

        }
    }


    public static void quickSort(int[] n, int left, int right) {
        int priot;
        if (left < right) {
            //privot作为枢轴，较之小的元素在左，较之大元素在右
            priot = partition(n, left, right);
            //对左右数组递归调用快速排序，直到顺序完全正确
            quickSort(n, left, priot - 1);
            quickSort(n, priot + 1, right);


        }
    }

    public static int partition(int[] n, int left, int right) {
        int privotkey = n[left];
        //枢轴选定后永远不变，最终在中间，前小后大
        while (left < right) {
            while (left < right && n[right] >= privotkey) --right;
            //将比枢轴小的元素移到低端，此时right位相当于空，等待低位比pivotkey大的数补上
            n[left] = n[right];
            while (left < right && n[left] <= privotkey) ++left;
            //将比枢轴大的元素移到高端，此时left位相当于空，等待高位比pivotkey小的数补上
            n[right] = n[left];
        }
        //当left == right，完成一趟快速排序，此时left位相当于空，等待pivotkey补上
        n[left] = privotkey;
        return left;
    }
}
