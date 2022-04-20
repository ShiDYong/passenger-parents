package com.mason.ATD.sorting;

import com.mason.ATD.List.EmptyArrayException;

/**
 * 冒泡算法的实现与分析
 *
 * @author ShiYong
 * @create 2022-04-20 9:37
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 4, 7, 2, 1};
        System.out.println("打印出排序前的数组：");
        pritinArr(arr);
        bubleSort(arr);
        System.out.println("\n" + "数组从小到大的排列：");
        pritinArr(arr);
    }


    /**
     * 冒泡排序：相邻的两个元素进行比较，如果符合条件就交换位置
     * 第一圈：最值出现在了最后的位置
     * 简介：冒泡排序（Bubble Sort），是一种计算机科学领域的较简单的排序算法。
     * 这个算法的名字由来是因为越大的元素会经由交换慢慢“浮”到数列的顶端，故名
     * 原理：（升序排列为例）
     * 1.比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 3.针对所有的元素重复以上的步骤，除了最后一个。
     * 4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
     * 原理过程图：画图很重要的，可以更加立体直观好理解
     * 时间复杂度：
     * 1.若文件的初始状态是正序的，一趟扫描即可完成排序。所需的关键字比较次数 C和记录移动次数M均达到最小值： Cmin = n-1, Mmin = 0
     * 所以冒泡排序的最好时间复杂度为：O(n)
     * 2.若初始文件是反序的，需要进行 n-1趟排序。每趟排序要进行 n-i次关键字的比较(1≤i≤n-1)，
     * 且每次比较都必须移动记录三次来达到交换记录位置。在这种情况下，比较和移动次数均达到最大值
     * Cmax= n(n-1)/2 = O(n2);
     * Mmax= 3n(n-1)/2 = O(n2);
     * 冒泡排序的最坏时间复杂度为O（n2）
     * 综上，冒泡排序总的时间复杂度为(n2);
     *
     * 性能分析：稳定性
     * 冒泡排序就是把小的元素往前调或者把大的元素往后调。比较是相邻的两个元素比较
     * 交换也发生在这两个元素之间。所以，如果两个元素相等，不会交换；
     * 如果两个相等的元素没有相邻，那么即使通过前面的两两交换把两个相邻起来，
     * 这时候也不会交换，所以相同元素的前后顺序并没有改变，所以冒泡排序是一种稳定排序算法。
     * @param arr
     */
    public static void bubleSort(int[] arr) {
        int length = arr.length;
        if (length < 1) throw new EmptyArrayException();
        for (int index = 0; index < length - 1; index++) {
            boolean flag = false;
            for (int i = 0; i < length - index - 1; i++) {
                //i代表数组的下标0，-index让每一次比较的元素减少，-1：避免下标越界
                if (arr[i] > arr[i + 1]) {
                    //改变这里的符号大小就可以完成从大到小的排序
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    flag = true;

                }

            }
            //没有数据交换退出
            if (!flag)
                break;

        }

    }

    public static void pritinArr(int[] arr) {
        //打印数组
        System.out.print("[");
        for (int index = 0; index < arr.length; index++) {
            if (index != arr.length - 1)
                System.out.print(arr[index] + "、");
            else
                System.out.print(arr[index] + "]");

        }
    }


}
