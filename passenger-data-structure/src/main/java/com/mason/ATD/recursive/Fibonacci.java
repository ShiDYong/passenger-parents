package com.mason.ATD.recursive;

/**
 * 斐波那契数列递归实现
 *
 * @author ShiYong
 * @create 2022-04-18 10:52
 **/
public class Fibonacci {
    public static void main(String[] args) {
        int n = 20;
        //获取当前JVM所剩的内存
        long m1 = Runtime.getRuntime().freeMemory();
        //获取当前执行的时间
        long startTime = System.currentTimeMillis();
        System.out.println(fibonacci(n));
        //获取当前JVM所剩的内存
        long m2 = Runtime.getRuntime().freeMemory();
        //获取当前执行的时间
        long endTime = System.currentTimeMillis();
        System.out.println("所用的内存：" + (m1 - m2));
        System.out.println("所花费的时间：" + (endTime - startTime));
    }


    /**
     * 使用递归实现斐波那契数列
     *
     * @param n 传入参数n
     * @return
     */
    public static int fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * 通过迭代方法实现的
     * @param n
     * @return
     */
    public static int fibonacci02(int n) {
        int[] res = {0, 1};
        if (n < 2) {
            return res[n];
        }
        int first = 0;
        int second = 1;
        int fibn = 0;
        for (int i = 2; i <= n; i++) {
            fibn = first + second;
            first = second;
            second = fibn;
        }
        return fibn;


    }
}
