package com.mason.ATD.searching;

import java.util.Arrays;

/**
 * @author Mason
 * @Description JDK二分查找的方法
 * @date 2022/4/23 21:21
 */
public class JDKBinarySearch {
    public static void main(String[] args) {
        /**
         * JDK17种没有使用递归的方法实现，相反使用的是迭代的方法
         * 值得很好的去对比和我们Demo种的使用的递归做一个比较
         * 很好的学习两种不同的实现方法的优势和劣势，实现起来非常的
         * 简洁。
         */
        Integer[] ints = {2, 4, 5, 7, 8, 10, 12, 15, 18, 21, 24, 26};
        Arrays.binarySearch(ints,0,ints.length-1,18);
    }

}
