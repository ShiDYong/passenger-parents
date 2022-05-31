package com.mason.ATD.sortedAlgorithms;

import com.mason.ATD.chapter06.priority.PriorityQueue;

import java.lang.reflect.WildcardType;
import java.security.PublicKey;
import java.util.Arrays;

/**
 * 快速排序的实现
 * 参考文章链接：http://c.biancheng.net/algorithm/quick-sort.html
 * 可以详细查看这个分析和实现过程。
 *
 * @author ShiYong
 * @create 2022-04-20 17:19
 **/
public class QuickSort {
    public static void quick_sort(int[] arr, int p, int q) {

        /**
         * 伪代码：输入 arr[]                              // 输入待排序序列
         * quick_sort(arr[] , p , q):              // [p , q] 用于指定当前要处理的子序列
         *     if q-p <= 0:                        // 如果序列中没有元素或者仅包含 1 个元素，则直接返回
         *         return
         *     else:
         *         par <- partition(arr , p , q)   // partition()函数用于将 [p,q] 区域分割成 [p, par-1] 和 [par+1, q] 区域，[p, par-1] 区域的元素都比 pivot 小，[par+1 , q] 区域的元素都比 pivot 大，函数会返回中间元素 pivot 所在的位置。
         *         quick_sort(arr , p , par-1)     // 将 [p , par-1] 作为待排序序列，重复进行分割
         *         quick_sort(arr , par+1 , q)     // 将 [par+1 , q] 作为待排序序列，重复进行分割
         */
        //如果待排序列不存在，或者仅包含1个元素，则不再进行分割
        if (q - p <= 0) return;
        else {
            //调用partition()函数进行分割，分割[p,q]区域
            int par = partition(arr, p, q);
            //以 [p,par-1]作为新的待排序序列，继续分割
            quick_sort(arr, p, par - 1);
            //以[par+1,q]作为新的待排序序列，继续分割
            quick_sort(arr, par + 1, q);
        }


    }

    /**
     * partition(arr[] , p , q):              // [p , q] 为要分割的区域
     * lo <- p                            // lo、hi 准备遍历 [p , q-1] 区域
     * hi <- q-1
     * pivot <- arr[q]                    // 以 [p , q] 区域中最后一个元素作为中间值
     * while true：                       // 一直循环，直到执行 end while
     * while arr[lo] < pivot:         // lo 从左往右遍历，直至找到一个不小于 pivot 的元素
     * lo <- lo+1
     * while hi>0 and arr[hi] > pivot:   // hi 从右往左遍历，直至找到一个不小于 pivot 的元素
     * hi <- hi-1
     * if lo ≥ hi:                      // 如果 lo 大于等于 hi，退出循环
     * end while
     * else:
     * swap arr[lo] , arr[hi]        // 交换 arr[lo] 和 arr[hi] 的值
     * lo <- lo+1                    // 分别将 lo 和 hi 向前移动一步，准备遍历后续的元素
     * hi <- hi-1
     * swap arr[lo] , arr[q]                 // 跳出循环后，交换 arr[lo] 和 arr[q] 的值
     * return lo                             // 返回 lo 的值，也就是中间值所在序列中的位置
     *
     * @param arr
     * @param p
     * @param q
     * @return
     */
    public static int partition(int[] arr, int p, int q) {
        int temp = 0;
        //lo、hi分别指向首个元素和倒数第二个元素的指针
        int lo = p;
        int hi = q - 1;
        //pivot表示选中的中间值
        int pivot = arr[q];
        while (true) {
            //lo从左到右遍历，直至找到一个不小于priot的元素
            while (arr[lo] < pivot)
                lo++;
            // hi从右往左遍历，直至找到一个不大于 pivot 的元素
            while (hi > 0 && arr[hi] > pivot)
                hi--;
            //如果lo>=hi,退出循环
            if (lo >= hi)
                break;
            else {
                //交换arr[lo]和arr[hi]的值
                temp = arr[lo];
                arr[lo] = arr[hi];
                arr[hi] = temp;
                //lo和hi都向前移动一个位置，准备继续遍历
                lo++;
                hi--;

            }
        }
        //交换arr[lo]和arr[q]的值
        temp = arr[lo];
        arr[lo] = pivot;
        arr[q] = temp;
        //返回中间值所在序列中的位置
        return lo;
    }

    /**
     * 递归实现
     * 参考文章：https://zhuanlan.zhihu.com/p/123416868
     *
     * @param start
     * @param end
     */
    public static void quick_sort_recursive(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int mid = arr[end];
        int left = start, right = end - 1;
        while (left < right) {
            while (arr[left] <= mid && left < right)
                left++;
            while (arr[right] >= mid && left < right)
                right--;
            swap(arr, left, right);
        }
        if (arr[left] >= arr[end])
            swap(arr, left, end);
        else
            left++;
        quick_sort_recursive(arr, start, left - 1);
        quick_sort_recursive(arr, left + 1, end);

    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{35, 33, 42, 10, 14, 19, 27, 44, 26, 31};
        // 对于 arr 数组中所有元素进行快速排序
        // quick_sort(arr, 0, 9);
        quick_sort_recursive(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
}
