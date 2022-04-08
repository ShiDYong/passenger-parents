package com.mason.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组的两数之和
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author ShiYong
 * @create 2022-03-23 13:46
 **/
public class TwoSum {
    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        int z = 0;
        z = x/y;
        System.out.println("z = " + z);

        int[] arr = {2, 3, 3, 4};
        int a = 6;
        int[] ints = twoSum02(arr, a);
        System.out.println("[" + ints[0] + "," + ints[1] + "]");


        //补充知识：Java数组的初始化方法分析
        //1.数组的声明方式：
        //方法一：数据类型[]数据名：int[] age :推荐使用此方式创建数组
        //方法二：数组元素的类型 数组名[]: int age[]: 不推荐使用这种方法
        //2.数组的初始化:静态初始化
        //元素数据类型[] 数组名 = new 元素数据类型[]{初始值1, 初始值2, 初始值3,.......};
        int[] nums = new int[]{13, 14, 520};
        // 方式二： 元素数据类型[] 数组名 = {初始值1, 初始值2, 初始值3,.......};
        int[] arrs = {13, 14, 520};


        // 数组静态初始化语法： 由我们（程序员们）来为每一个数组元素设置初始化值，
        // 也就是说知道要在数组中存储哪些数据；此时数组的长度JVM根据设置的初始值来分配，不需要再设置
        //元素数据类型[] 数组名 = new 元素数据类型[ length ];
        //3.数组的动态初始化：由我们（程序员们）来设置数组长度)，而数组中元素的初始值由JVM赋予

        int[] myArray = new int[100];
        // 但是， 不能同时使用静态初始化和动态初始化，比如：
        //int[] nums = new int[3]{13, 14, 520}; // 这种写法是错误的。


        //二维数组的静态初始化：
        // 二维数组的静态初始化
        int[][] b = new int[][]{{1, 2, 3}, {4, 5}, {6}};

        //创建一个长度为3的二维数组,每一个元素(一维数组)的长度为5.
        int[][] c = new int[3][5];
        // 多维数组的取值：
        // int[1][1]; // 表示第2个一维数组的第2个元素

    }


    public static int[] twoSum(int[] nums, int target) {
        //以下方法是自己的做出的方法：
      /*  int[] arr = new int[2];
        if (nums.length < 1) return null;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;*/

        //以上的暴力枚举法方法书写方式进行优化：最容易想到的方法是枚举数组中的每一个数 x，寻找数组中是否存在 target - x。
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    //注意该写法和自己的区别，对数组的初始化基础知识不牢固
                    return new int[]{i, j};
                }

            }

        }
        return new int[0];

    }


    /**
     * 使用hash表：
     * 这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，
     * 然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum02(int[] nums, int target) {
        Map<Integer, Integer> hashTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashTable.containsKey(target - nums[i])) {
                //利用hashMap的key是唯一不重复的特性:熟练使用hashmap数据结构的特点来使用：要加强这点
                return new int[]{hashTable.get(target - nums[i]), i};
            }
            hashTable.put(nums[i],i);

        }
        return new int[0];
    }


}


