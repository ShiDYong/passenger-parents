package com.mason.ATD.sorting;

/**
 * 选择排序
 * Class for sorting an array of Comparable object from smallest to largest.
 *
 * @author ShiYong
 * @create 2022-04-18 13:54
 **/
public class SortArray {


    /**
     * Sorts the first n objects in an array into ascending order.
     *
     * @param n   An array of Comparable objects.
     * @param <T> An integer >0
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] a, int n) {
        for (int index = 0; index < n - 1; index++) {
            //查询最小索引值
            int indexOfSmallest = getIndexOfSmallest(a, index, n);
            //调动交换的方法
            swap(a, index, indexOfSmallest);

        }

    }

    /**
     * Finds the index of the smallest value in a portion of an array a.
     *
     * @param a     An array of Comparable objects
     * @param first
     * @param last
     * @param <T>
     * @return the index of the smallest value among
     */
    private static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last) {
        T min = a[first];
        int indexOfMin = first;
        for (int index = first + 1; index <= last; index++) {
            if (a[index].compareTo(min) < 0) {
                min = a[index];
                indexOfMin = index;
            }

        }
        return indexOfMin;
    }

    /**
     * Swaps the array entries a[i] and a[j]
     *
     * @param a
     * @param i
     * @param j
     */
    private static void swap(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }
}
