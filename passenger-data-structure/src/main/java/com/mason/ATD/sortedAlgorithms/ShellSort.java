package com.mason.ATD.sortedAlgorithms;

import com.mason.ATD.chapter02.ResizableArrayBag;

import java.time.temporal.Temporal;
import java.util.Arrays;

/**
 * 希尔排序的实现
 *
 * @author ShiYong
 * @create 2022-04-20 14:18
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {99, 5, 69, 33, 56, 13, 22, 55, 77, 48, 12, 88, 2, 69, 99};
        System.out.println("排序之前数组：");
        System.out.print(Arrays.toString(arr));

        //希尔排序
        shellSort(arr);

        System.out.println("希尔排序后数组：");
        System.out.print(Arrays.toString(arr));
    }


    /**
     * 希尔排序(Shell Sort)是插入排序的一种算法，是对直接插入排序的一个优化，也称缩小增量排序。
     * 希尔排序是非稳定排序算法。
     * 希尔排序因DL．Shell于1959年提出而得名
     * 参考文章链接：https://www.jianshu.com/p/d730ae586cf3
     * https://www.codeleading.com/article/91043258858/
     * @param arr
     * @return
     */
    public static int[] shellSort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return arr;
        //希尔排序，升序
        for (int i = arr.length / 2; i > 0; i /= 2) {
            System.out.println("增量取值：" + i);
            for (int j = i; j < arr.length; j++) {
                for (int k = j - i; k >= 0; k -= i) {
                    if (arr[k] > arr[k + i]) {
                        swap(arr, k, k + i);
                    }
                }

            }
            for (int index = 0; index < arr.length; index++) {
                System.out.println(arr[index] + " ");

            }
            System.out.println("");

        }
        return arr;

    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
