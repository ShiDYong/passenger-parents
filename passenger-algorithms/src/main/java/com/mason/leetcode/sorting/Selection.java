package com.mason.leetcode.sorting;

import java.io.*;
import java.nio.CharBuffer;
import java.util.Comparator;

/**
 * @author Mason
 * @Description 选择排序的实现
 * @date 2022/5/7 09:30
 */
public class Selection {

    private Selection() {
    }


    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void selectionSort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exchange(a, i, min);
            assert isSorted(a, 0, i);

        }
        assert isSorted(a);
    }

    /**
     * Rearranges the array in ascending order, using a comparator.
     *
     * @param a          the array
     * @param comparator the comparator specifying the order
     */
    private static void selectionSort(Object[] a, Comparator comparator) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(comparator, a[j], a[min])) min = j;
            }
            exchange(a, i, min);
            assert isSorted(a, comparator, 0, i);

        }
        assert isSorted(a, comparator);

    }


    private static boolean less(Comparable v, Comparable w) {
        //比较两个数的方法
        return v.compareTo(w) < 0;
    }

    private static boolean less(Comparator comparator, Object v, Object w) {
        return comparator.compare(v, w) < 0;
    }

    private static void exchange(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        //检查数组是否有序的
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;


    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, comparator, 0, a.length - 1);
    }

    private static boolean isSorted(Object[] a, Comparator comparator, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(comparator, a[i], a[i - 1])) return false;
        return true;

    }


    private static void show(Comparable[] a) {
        //在单行中打印数组
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i]+" ");

        }
    }

    public static void main(String[] args) {
        //    String[] a = StdIn.readAllStrings();
        Integer[] a = {4, 3, 1, 8, 6};
        Selection.selectionSort(a);
        show(a);
    }

}
