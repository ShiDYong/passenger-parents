package com.mason.leetcode.sorting;

/**
 * 希尔排序的实现
 *
 * @author ShiYong
 * @create 2022-02-28 11:42
 **/
public class ShellSort {
    public static void main(String[] args) {
        testShellSort();

    }


    private int[] array;

    public ShellSort(int[] array) {
        this.array = array;
    }

    public void sort() {
        int temp = 0;
        for (int k = array.length / 2; k > 0; k /= 2) {

            for (int i = k; i < array.length; i++) {
                for (int j = i; j >= k; j -= k) {
                    if (array[j - k] > array[j]) {
                        array[j - k] = array[j];
                        array[j] = temp;
                    }
                }

            }
        }

    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);

        }
    }

    private static void testShellSort(){
        int[] array = {5, 9, 1, 9, 5, 3, 7, 6, 1};
        ShellSort shellSort = new ShellSort(array);
        shellSort.sort();
        shellSort.print();
    }
}
