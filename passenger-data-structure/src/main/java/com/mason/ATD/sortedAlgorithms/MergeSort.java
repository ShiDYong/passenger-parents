package com.mason.ATD.sortedAlgorithms;

import javax.management.relation.RelationSupport;
import java.lang.reflect.Array;
import java.lang.reflect.WildcardType;
import java.security.interfaces.RSAKey;
import java.util.Arrays;

/**
 * 归并算法的实现
 * 参考链接：
 * https://zhuanlan.zhihu.com/p/124356219
 * http://c.biancheng.net/algorithm/merge-sort.html
 * 数据结构与抽象Java版第五版
 * JDK1.8以上的源码中Arrays.sort方法就是使用归并排序
 *
 * @author ShiYong
 * @create 2022-04-20 15:42
 **/
public class MergeSort {

    /**
     * 归并算法的伪代码如下：
     * 输入 arr[n]                                // 输入要排序的序列
     * merge_sort(arr[n] , p , q):                // [p , q] 表示对第 p ~ q 区域内的元素进行归并排序
     * if p < q :                             // 对 [p , q] 区域不断采用对半分割的方式，最终将整个区域划分为多个仅包含 1 个元素（p==q）的序列
     * mid = ⌊(p+q)/2⌋
     * merge_sort(arr , p , mid)
     * merge_sort(arr , mid+1 , q)
     * merge(arr , p , mid , q)          // 调用实现归并过程的代码模块
     * <p>
     * merge(arr[n] , p , mid , q):                          // 该算法表示将 [p , mid] 和 [mid+1 , q] 做归并操作
     * leftnum <- mid - p + 1                            // 统计 [p , mid] 区域内的元素个数
     * rightnum <- q - mid                               // 统计 [mid+1 , q] 区域内的元素个数
     * leftarr[leftnum] <- arr[p ... mid]                // 分别将两个区域内的元素各自拷贝到另外两个数组中
     * rightarr[rightnum] <- arr[mid+1 ... q]
     * i <- 1 , j <- 1
     * for k <- p to q :             // 从 leftarr 和 rightarr 数组中第 1 个元素开始，比较它们的大小，将较小的元素拷贝到 arr 数组的 [p , q] 区域
     * if leftarr[i] ≤ rightarr[j] :
     * arr[k] = leftarr[i]
     * i <- i+1
     * else :
     * arr[k] = right[j]
     * j <- j+1
     */

    //实现对归并排序算法的分割操作
    public static void merge_sort(int[] arr, int first, int end) {
        //如果数组不存在或者[first,end]区域不合理
        if (arr == null || first >= end) return;
        //对[first,end]进行分割
        int mid = (first + end) / 2;
        merge_sort(arr, first, mid);
        merge_sort(arr, mid + 1, end);
        //进行合并[first,mid]和[mid+1,end]区域进行归并
        merge(arr, first, mid, end);

    }

    //进行归并排序算法的归并操作
    public static void merge(int[] arr, int first, int mid, int end) {
        int numL = mid - first + 1;
        int numR = end - mid;
        //创建两个数组，分别存储[first,mid]和[mid+1,end]区域内的元素
        int[] leftArr = new int[numL + 1];
        int[] rightArr = new int[numR + 1];
        int i;
        //进行数组的拷贝
        for (i = 0; i < numL; i++) {
            leftArr[i] = arr[first - 1 + i];
        }
        //将 leftarr 数组中最后一个元素设置为足够大的数。
        leftArr[i] = 2147483647;
        for (i = 0; i < numR; i++) {
            rightArr[i] = arr[mid + i];

        }

        //将 rightarr 数组中最后一个元素设置为足够大的数。
        rightArr[i] = 2147483647;
        int j = 0;
        i = 0;
        //对leftArr和rightArr数组中存储的2个区域的元素做归并操作
        for (int k = first; k <= end; k++) {
            //进行两个数组元素的比较
            if (leftArr[i] <= rightArr[j]) {
                arr[k - 1] = leftArr[i];
                i++;
            } else {
                arr[k - 1] = rightArr[j];
                j++;
            }

        }


    }

    /**
     * 递归实现归并算法的整合
     *
     * @param arr
     * @param result
     * @param start
     * @param end
     */
    public static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end) return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);

        int k = start;
        while (start1 <= end1 && start2 <= end2)
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= end1)
            result[k++] = arr[start1++];
        while (start2 <= end2)
            result[k++] = arr[start2++];
        for (k = start; k <= end; k++) {
            arr[k] = result[k];

        }
    }



    public static void merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        merge_sort_recursive(arr, result, 0, len - 1);
    }


    // 归并排序（Java-迭代版）
    public static void merge_sort_iterator(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        int block, start;

        // 原版代码的迭代次数少了一次，没有考虑到奇数列数组的情况
        for (block = 1; block < len * 2; block *= 2) {
            for (start = 0; start < len; start += 2 * block) {
                int low = start;
                int mid = (start + block) < len ? (start + block) : len;
                int high = (start + 2 * block) < len ? (start + 2 * block) : len;
                //两个块的起始下标及结束下标
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;
                //开始对两个block进行归并排序
                while (start1 < end1 && start2 < end2) {
                    result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
                }
                while (start1 < end1) {
                    result[low++] = arr[start1++];
                }
                while (start2 < end2) {
                    result[low++] = arr[start2++];
                }
            }
            int[] temp = arr;
            arr = result;
            result = temp;
        }
        result = arr;
    }

    public static void main(String[] args) {
        int[] arr = {7, 5, 2, 4, 1, 6, 3, 0};
        //merge_sort(arr, 1, 8);
        merge_sort_iterator(arr);
        System.out.println(Arrays.toString(arr));
    }

}
