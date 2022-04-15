package com.mason.ATD.recursive;

/**
 * 递归方法的入门使用
 *
 * @author ShiYong
 * @create 2022-04-12 13:46
 **/
public class RecursiveStartDemo {

    public static void main(String[] args) {
        System.out.println(sumOf(3));
    }

    /**
     * Counts down from a given positive integer.
     *
     * @param integer
     */
    public static void countDown(int integer) {
        int count = 0;
        System.out.println("显示：" + integer);

        if (integer > 1)
            countDown(integer - 1);
        System.out.println("调用次数：" + count++);


    }

    public static int sumOf(int n) {
        int sum;
        if (n == 1)
            sum = 1;
        else
            sum = sumOf(n - 1) + n;
        return sum;
    }
}
