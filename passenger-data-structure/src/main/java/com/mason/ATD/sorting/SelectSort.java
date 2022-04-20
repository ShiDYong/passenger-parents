package com.mason.ATD.sorting;

import java.util.random.RandomGenerator;

/**
 * 选择排序的实现
 *
 * @author ShiYong
 * @create 2022-04-20 10:42
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 7, 1,1};
        System.out.println("打印排序前的数组：");
        printArray(arr);
        selectSort(arr);
        System.out.println("\n数组进行从小到的排序: ");
        printArray(arr);

    }

    /**
     * 选择排序的实现
     * 选择排序的介绍：
     *     可分为两类：比较和交换，也就是在每轮检查中把未排序的值跟该轮已经遇到的最小值做比较，
     *     以及将最小值与该起点的值交换以使其位置正确。
     *  原理过程图：自己画，非常重要
     *  时间复杂度：
     *  简单选择排序的比较次数与序列的初始排序无关。 假设待排序的序列有 n 个元素，选择排序的赋值操作介于 0 和 3 (n - 1） 次之间;
     *  则比较次数 永远都是n (n- 1) / 2; 而移动次数（即：交换操作）与序列的初始排序有关,介于 0 和 (n - 1） 次之间。当序列正序时，移动次数最少，为 0。当序列反序时，移动次数最多，为n - 1 次;逆序交换n/2次。综上，简单选择排序的时间复杂度为 O(n²)。
     *  选择排序的移动次数比冒泡排序少多了，由于交换所需CPU时间比 比较所需的CPU时间多，n值较小时，选择排序比冒泡排序快。
     *  性能分析：稳定性
     *  选择排序的时间复杂度为O(n²)，由于每次选择仅考虑某一位置上的数据情况，可能会破坏之前数据的相对位置，因此它是一种不稳定的排序方法。
     *  选择排序有两个重要的特点：
     *      1)运行时间和输入无关：即不论数组的初始状态的有序程度，选择排序的比较次数都没有变化。考虑到比较次数与元素个数的关系是n (n- 1)/ 2，
     *      所以当一个已经比较有序的数组使用选择排序会很不划算；
     *      2）数据的移动操作最少：移动操作次数是一个常量，最多为n-1，其他的算法都不具备这个特征
     *  与冒泡排序的区别：
     *      选择排序、冒泡排序都用for（for(if)）结构语句。一般选择排序效率会更高一些。
     *      自我总结分析原因：（更详细情况请参考上面选择排序的时间复杂度）
     *      冒泡排序的思想为每一次排序过程，通过相邻元素的交换，将当前没有排好序中的最大（小）移到数组的最右（左）端。
     *      而选择排序的思想也很直观：每一次排序过程，我们获取当前没有排好序中的最大（小）的元素和数组最右（左）端的元素交换，
     *      循环这个过程即可实现对整个数组排序。同样数据的情况下，两种算法的循环次数是一样的，但选择排序只有0到1次交换，
     *      而冒泡排序只有0到n次交换 。而影响我们算法效率的主要部分是循环和交换，显然，次数越多，效率就越差
     *      。选择排序的平均时间复杂度比冒泡排序的稍低。所以相比较而言选择排序效率会
     *
     。
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        int length = arr.length;
        if (length < 1) return;

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }


            }

        }

    }

    /**
     * 实现打印数组的方法
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int index = 0; index < arr.length; index++) {
            if (index != arr.length - 1)
                System.out.print(arr[index] + "、");
            else
                System.out.print(arr[index] + "]");

        }

    }
}
