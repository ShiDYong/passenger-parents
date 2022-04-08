package com.mason.leetcode.orders;

/**
 * 求最大子序列和问题的求解
 *
 * @author ShiYong
 * @create 2022-03-25 15:56
 **/
public class MaxSubSum {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 4, -5, 6};
        int result = maxSubSum(arr);
        System.out.println("result = " + result);

    }


    /**
     * 使用暴力算法尝试所有可能
     *
     * @param nums
     * @return
     */
    public static int maxSubSum(int[] nums) {
        int n = nums.length;
        int maxSum = 0;

        if (nums == null || n == 0) return 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int thisSum = 0;

                for (int k = i; k <= j; k++) {
                    thisSum += nums[k];

                }
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }

            }
        }
        return maxSum;

    }

    /**
     * 算法一的一种改进
     *
     * @param nums
     * @return
     */
    public static int maxSubSum2(int[] nums) {
        int n = nums.length;
        int maxSum = 0;

        if (nums == null || nums.length == 0) return 0;

        for (int i = 0; i < n; i++) {
            int thisSum = 0;
            for (int j = i; j < n; j++) {
                thisSum += nums[j];

                if (maxSum < thisSum) {
                    maxSum = thisSum;
                }
            }

        }

        return maxSum;
    }

}
