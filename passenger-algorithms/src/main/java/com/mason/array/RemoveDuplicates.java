package com.mason.array;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 删除有序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author ShiYong
 * @create 2022-03-24 14:22
 **/
public class RemoveDuplicates {
    public static void main(String[] args) {
//        Map<Integer,Integer> treeMap = new TreeMap<>();
//        treeMap.put(1,3);
//        treeMap.put(4,4);
//        treeMap.put(3,5);
//        treeMap.put(2,null);
//        //treeMap.put(null,null);
//        System.out.println("treeMap = " + treeMap);
//
//        Map<Integer,Integer> hashMap = new HashMap<>();
//        hashMap.put(4,2);
//        hashMap.put(2,30);
//        hashMap.put(1,30);
//        hashMap.put(5,90);
//        hashMap.put(null,0);
//        hashMap.put(null,null);
//        //System.out.println("hashMap = " + hashMap);

        int[] arr = {1, 2, 2, 3, 4};
        int i = removeDuplicates03(arr);
        System.out.println("i = " + i);

    }

    public static int removeDuplicates(int[] nums) {
        //刚开始看到题目想到是用hashmap的key值不重复，而且是自动排序的特点
        //但是无法做到，没有仔细阅读和分析题目
//        Map<Integer,Integer> mapMy = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            mapMy.put(nums[i],i);
//        }

        /**
         * 双指针：
         * 这道题目的要求是：对给定的有序数组 \textit{nums}nums 删除重复元素，在删除重复元素之后，每个元素只出现一次，并返回新的长度，上述操作必须通过原地修改数组的方法，使用 O(1)O(1) 的空间复杂度完成。
         * 由于给定的数组 \textit{nums}nums 是有序的，因此对于任意 i<ji<j，如果 \textit{nums}[i]=\textit{nums}[j]nums[i]=nums[j]，则对任意 i \le k \le ji≤k≤j，必有 \textit{nums}[i]=\textit{nums}[k]=\textit{nums}[j]nums[i]=nums[k]=nums[j]，即相等的元素在数组中的下标一定是连续的。利用数组有序的特点，可以通过双指针的方法删除重复元素。
         * 如果数组 \textit{nums}nums 的长度为 00，则数组不包含任何元素，因此返回 00。
         * 当数组 \textit{nums}nums 的长度大于 00 时，数组中至少包含一个元素，在删除重复元素之后也至少剩下一个元素，因此 \textit{nums}[0]nums[0] 保持原状即可，从下标 11 开始删除重复元素。
         * 定义两个指针 \textit{fast}fast 和 \textit{slow}slow 分别为快指针和慢指针，快指针表示遍历数组到达的下标位置，慢指针表示下一个不同元素要填入的下标位置，初始时两个指针都指向下标 11。
         * 假设数组 \textit{nums}nums 的长度为 nn。将快指针 \textit{fast}fast 依次遍历从 11 到 n-1n−1 的每个位置，对于每个位置，如果 \textit{nums}[\textit{fast}] \ne \textit{nums}[\textit{fast}-1]nums[fast]
         *  =nums[fast−1]，说明 \textit{nums}[\textit{fast}]nums[fast] 和之前的元素都不同，因此将 \textit{nums}[\textit{fast}]nums[fast] 的值复制到 \textit{nums}[\textit{slow}]nums[slow]，然后将 \textit{slow}slow 的值加 11，即指向下一个位置。
         * 遍历结束之后，从 \textit{nums}[0]nums[0] 到 \textit{nums}[\textit{slow}-1]nums[slow−1] 的每个元素都不相同且包含原数组中的每个不同的元素，因此新的长度即为 \textit{slow}slow，返回 \textit{slow}slow 即可
         */
        int n = nums.length;
        if (n == 0) {
            //数组的长度为0
            return 0;
        }
        //定义快指针和慢指针
        int fast = 1, slow = 1;

        while (fast < n) {
            //相邻元素不相等
            if (nums[fast] != nums[fast - 1]) {
                // 将num[fast]的复制到nums[low]
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    public static int removeDuplicates02(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                //如果数组中是没有重复元素就不用复制一遍
                if (q - p > 1) {
                    nums[p + 1] = nums[q];
                }
                p++;

            }
            q++;
        }
        return p + 1;

    }


    public static int removeDuplicates03(int[] nums) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }

        }
        return j + 1;


    }


    /**
     * 通用写法
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates04(int[] nums) {

        int n = nums.length;
        if (n <= 1) return n;
        return process(nums, 1, nums[n - 1]);


    }

    public static int process(int[] nums, int k, int max) {
        int idx = 0;
        for (int x : nums) {
            if (idx < k || nums[idx - k] != x) nums[idx++] = x;
            if (idx - k >= 0 && nums[idx - k] == max) break;
        }
        return idx;
    }


}
