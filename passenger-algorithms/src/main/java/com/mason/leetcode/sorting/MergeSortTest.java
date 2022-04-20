package com.mason.leetcode.sorting;

/**
 * 归并排序算法的实现
 *
 * @author ShiYong
 * @create 2022-03-01 11:15
 **/
public class MergeSortTest {


    public static void main(String[] args) {
        int[] data = {2, 4, 7, 5, 8, 1, 3, 6};
        System.out.print("初始化：\t");
        print(data);
        System.out.println("");
        mergeSort(data, 0, data.length - 1);
        System.out.print("\n排序后：\t");
        print(data);
    }


    /**
     * @param data  传入对象数组
     * @param left  数组第一个元素的索引
     * @param right 数组最后一个元素的索引
     */
    public static void mergeSort(int[] data, int left, int right) {
        if (left >= right) return;

        //两路归并找出中间索引
        int center = (left + right) / 2;
        //对左边数组进行递归
        mergeSort(data, left, center);
        //对右边数组进行递归
        mergeSort(data, center + 1, right);

        //合并
        merge(data, left, center, center + 1, right);
        System.out.print("排序中：\t");
        print(data);

    }


    /**
     * 将连个数组进行归并，归并前面2个数组已有序，归并后依次有序
     *
     * @param data       对象数组
     * @param leftStart  左数组的第一个元素的索引
     * @param leftEnd    左数组的最后一个元素的索引
     * @param rightStart 右数组的第一个元素的索引
     * @param rightEnd   右数组的最后一个元素的索引
     */
    public static void merge(int[] data, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int i = leftStart;
        int j = rightStart;
        int k = 0;

        //创建一个临时的数组来存放临时排序的数组
        int[] temp = new int[rightEnd - leftStart + 1];
        //确认分割后的两段数组是否都渠道了最后一个元素
        while (i <= leftEnd && j <= rightEnd) {
            //从两个数组中取出最小的放入临时数组
            if (data[i] > data[j]) {
                temp[k++] = data[j++];
            } else {
                temp[k++] = data[i++];
            }
        }
        //剩余部分一次放入临时数组(实际上两个while只会执行其中一个)
        while (i <= leftEnd) {
            temp[k++] = data[i++];
        }
        while (j <= rightEnd) {
            temp[k++] = data[j++];
        }
        k = leftStart;
        //将临时数组中的内容拷贝回原数组中原(left-right范围的内容被复制回原数组）
        for (int element : temp) {
            data[k++] = element;
        }

    }

    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");

        }
        System.out.println();
    }
}
