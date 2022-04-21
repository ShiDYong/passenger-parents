package com.mason.ATD.sortedAlgorithms;

import com.mason.ATD.List.EmptyArrayException;


/**
 * 插入排序
 *
 * @author ShiYong
 * @create 2022-04-20 13:39
 **/
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 1, 3};
        System.out.println("数组插入排序之前操作：");
        printArray(arr);
        insertiontSort(arr);
        System.out.println("\n数组插入排序后从小到大排序：");
        printArray(arr);


    }

    /**
     * 插入排序的实现
     * 简介：
     *     插入排序（Insertion Sort）算法是一个对少量元素进行排序的有效算法。
     *     插入排序是稳定的（即：两个相等的数不会交换位置）
     * 分类：
     *     直接插入排序，二分插入排序（又称折半插入排序），链表插入排序，希尔排序（又称缩小增量排序）
     * 原理：
     *      从数组的第二个元素开始,将数组中的每一个元素按照（升序或者降序）规则插入到已排好序的数组中以达到排序的目的.
     *      一般情况下将数组的第一个元素作为起始元素,从第二个元素开始依次插入。由于要插入到的数组是已经排好序的,所以只要从右向左（或者从后向前）找到排序插入点插入元素，以此类推，直到将最后一个数组元素插入到数组中,整个排序过程完成。
     *
     *原理过程图：要画非常重要的，结合代码实现能更深入的理解
     *
     * 时间复杂度：
     *       将有n个元素的数组排序。
     *      最佳情况就是，数组已经是正序排列了，在这种情况下，需要进行的比较操作是 （n-1）次即可。
     *      最坏情况就是，数组是反序排列，那么此时需要进行的比较共有n(n-1)/2次。
     *      插入排序的赋值操作是比较操作的次数加上 (n-1）次。
     *      平均插入排序算法的时间复杂度为 O(n²)。因而，插入排序不适合对于数据量比较大的排序应用。
     *      但是，如果需要排序的数据量很小（eg：量级小于千），那么插入排序是一个不错的选择
     *      Note：尽管插入排序的时间复杂度也是O(n²)，但一般情况下，插入排序会比冒泡排序快一倍，要比选择排序还要快一点
     *性能分析(稳定性)
     *插入排序是在一个已经有序的小序列的基础上，一次插入一个元素。
     *      当然，刚开始这个有序的小序列只有1个元素，就是第一个元素。比较是从有序序列的末尾开始，
     *      也就是想要插入的元素和已经有序的最大者开始比起，如果比它大则直接插入在其后面，
     *      否则一直往前找直到找到它该插入的位置。如果碰见一个和插入元素相等的，
     *      那么插入元素把想插入的元素放在相等元素的后面。所以，相等元素的前后顺序没有改变，
     *      从原无序序列出去的顺序就是排好序后的顺序，所以插入排序是稳定的
     * @param arr
     */
    public static int[] insertiontSort(int[] arr) {
        int length = arr.length;
        if (length < 1) throw new EmptyArrayException();
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }

            }

        }
        return arr;
    }

    /**
     * 打印数组的方法
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1)
                System.out.print(arr[i] + "、");
            else
                System.out.print(arr[i] + "]");

        }
    }
}
