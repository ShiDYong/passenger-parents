package com.mason.orders;

import java.util.ArrayList;

/**
 * 冒泡算法的实现
 *
 * @author ShiYong
 * @create 2022-02-25 14:04
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {2,3,5,1,8,5};
        bubbleSort2(a);
    }

    //从小到大的排序方法
    public static void bubbleSort(int[] n) {
        int length = n.length;
        if (n.length < 1) return;
        for (int i = 0; i < length; i++) {
            //退出冒泡循环标志位
            boolean flag = false;
            //循环进行数据的比较
            for (int j = 0; j < length - i - 1; j++) {

                //判断数据 大小
                if (n[j] > n[j + 1]) {
                    //进行数据交换
                    int temp = n[j];
                    n[j] = n[j + 1];
                    n[j + 1] = temp;
                    flag = true;
                }
            }
            //没有数据交换退出
            if (!flag) break;


        }

    }

    //从大到小排序方法
    public static void bubbleSort2(int[] a) {
        int length = a.length;
        if (length > 0) {
            for (int i = length - 1; i > 0; i--) {
                //退出冒泡循环标志位
                boolean flag = false;
                //从右到左开始循环遍历对比
                for (int j = length - 1; j > length - 1 - i; j--) {
                    if (a[j] > a[j - 1]) {
                        int temp = a[j];
                        a[j] = a[j - 1];
                        a[j - 1] = temp;
                        flag = true;
                    }

                }
                //没有数据交换退出
                if (!flag) break;
            }

        }


    }

    //打印出数组的元素
//    public void print() {
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
//    }

}

