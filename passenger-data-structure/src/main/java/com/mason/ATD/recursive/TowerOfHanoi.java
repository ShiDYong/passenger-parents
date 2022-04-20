package com.mason.ATD.recursive;

import com.mason.ATD.List.EmptyArrayException;

import java.security.KeyStore;

/**
 * 汉诺塔递归问题的解决
 *
 * @author ShiYong
 * @create 2022-04-18 9:34
 **/
public class TowerOfHanoi {
    public static void main(String[] args) {

        int disks = 2;
        //获取当前JVM所剩的内存
        long m1 = Runtime.getRuntime().freeMemory();
        //获取当前执行的时间
        long startTime = System.currentTimeMillis();
        solveTowers(disks, 'A', 'B', 'C');
        //获取当前JVM所剩的内存
        long m2 = Runtime.getRuntime().freeMemory();
        //获取当前执行的时间
        long endTime = System.currentTimeMillis();
        System.out.println("所用的内存：" + (m1 - m2));
        System.out.println("所花费的时间：" + (endTime - startTime));
        System.out.println(">>>>>>>>>>>>>>>>>>>>以下是方法二<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        //获取当前执行的时间
        long start1Time = System.currentTimeMillis();
        //获取当前JVM所剩的内存
        long m3 = Runtime.getRuntime().freeMemory();
        //获取当前JVM所剩的内存
        solveTowers02(disks, 'A', 'B', 'C');
        //获取当前JVM所剩的内存
        long m4 = Runtime.getRuntime().freeMemory();
        //获取当前执行的时间
        long end2Time = System.currentTimeMillis();
        System.out.println("所用的内存：" + (m3 - m4));
        System.out.println("所花费的时间：" + (end2Time - start1Time));

    }

    private static void solveTowers(int numberOfDisks, char startPole, char tempPole, char endPole) {
        /**
         * 问题的详解过程：
         * https://www.zhihu.com/question/24385418-
         */
        //基础情形，终止条件
        if (numberOfDisks == 1)
            //一个盘子，直接打印出移动动作
            System.out.println("Disk 1 from " + startPole + " to " + endPole);
        else {
            //盘子数，开始柱，中转柱，目标柱
            //step1,把除了最大的盘子之外的盘子从A移到B
            solveTowers(numberOfDisks - 1, startPole, endPole, tempPole);
            //step2,把最大的盘子从A移走到C盘
            System.out.println("Disk " + numberOfDisks + " from " + startPole + " to " + endPole);
            //step3,把除了最大的盘子之外的盘子从B移到C
            solveTowers(numberOfDisks - 1, tempPole, startPole, endPole);
        }
    }

    private static void solveTowers02(int numberOfDisks, char startPole, char tempPole, char endPole) {
        if (numberOfDisks > 0) {
            solveTowers02(numberOfDisks - 1, startPole, endPole, tempPole);
            System.out.println("Disk " + numberOfDisks + " from " + startPole + " to " + endPole);
            solveTowers02(numberOfDisks - 1, tempPole, startPole, endPole);

        }
    }
}
