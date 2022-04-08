package com.mason.ATD.chapter05;

/**
 * 算法效率演示案例
 * 对任意的正整数n，考虑求和问题1+2+3+。。。。。。+n
 *
 * @author ShiYong
 * @create 2022-04-01 13:42
 **/
public class AlgorithmDemo01 {

    public static void main(String[] args) {
        getSumA(10000);
        getSumB(10000);
        getSumC(10000);

    }

    /**
     * Computing the sum of the consecutive integers from 1 to n.
     *
     * @param n
     */

    public static void getSumA(int n) {
        long start = System.currentTimeMillis();
        int sum = 0;
        for (int index = 1; index <= n; index++) {
            sum += index;
        }
        long end = System.currentTimeMillis();
        System.out.println("A用时为：" + (end - start));
        System.out.println(sum);

    }

    public static void getSumB(int n) {
        long start = System.currentTimeMillis();
        int sum = 0;
        for (int index = 1; index <=n; index++) {
            for (int j = 1; j <=index; j++) {
                sum = sum + 1;



            }


        }
        long end = System.currentTimeMillis();
        System.out.println("B时为：" + (end - start));
        System.out.println(sum);
    }


    public static void getSumC(int n) {
        long start = System.currentTimeMillis();
        int sum = 0;
        sum = n *(n+1) /2;
        long end = System.currentTimeMillis();
        System.out.println("C时为：" + (end - start));
        System.out.println(sum);
    }


}
