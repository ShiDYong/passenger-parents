package com.junit;

/**
 * 测试寻找最大的函数
 *
 * @author ShiYong
 * @create 2022-03-25 10:23
 **/
public class Largest {
    public static void main(String[] args) {
        System.out.println("测试下任务分支分别合并到test、release分支");
    }

    public static int largest(int[] list) {
        int index;
        int max = Integer.MAX_VALUE;
        for (index = 0; index < list.length - 1; index++) {
            if (list[index] > max) {
                max = list[index];
            }

        }
        return max;
    }
}
