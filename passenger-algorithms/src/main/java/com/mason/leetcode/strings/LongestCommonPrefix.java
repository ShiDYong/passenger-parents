package com.mason.leetcode.strings;

/**
 * 最长公共前缀
 * 网址：https://leetcode-cn.com/problems/longest-common-prefix
 *
 * @author ShiYong
 * @create 2022-02-23 14:11
 **/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flow", "flater", "flag","fly"};
        String prefix = longestCommonPrefix3(strs);
        System.out.println("prefix = " + prefix);


    }

    // 方法一：使用横向扫描算法:依次遍历每个字符串，更新最长公共前缀
    public static String longestComonPrefix(String[] strs) {
        //判断是否为空字符串数组
        if (strs == null || strs.length < 1) {
            return "";
        }

        String prefix = strs[0];
        int count = strs.length;
        //循环遍历字符串数组
        for (int i = 0; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                //没有公共字符串，这是一个空串
                break;
            }
        }
        return prefix;

    }

    private static String longestCommonPrefix(String str1, String str2) {
        //通过Math函数获取传入函数中最小长度的字符串
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        //利用字符串的charAt()比较字符串字符是否相等
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        //截取公共字符串前缀
        return str1.substring(0, index);


    }


    //方法2：纵向扫描算法:从前往后遍历所有字符串的每一列，比较相同列上的字符是否相等，如果相同则继续对下一列进行比较，
    //如果不相同则当前列不再属于公共前缀，当前列之前的部分为最长公共前缀

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length < 0) {

            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            //获取第一个字符串
            char c = strs[0].charAt(i);
            //对字符串数组strs进行遍历
            for (int j = 0; j < count; j++) {
                //判断是否有相同的字符
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }

            }

        }
        return strs[0];

    }

    //方法三：使用分治算法实现
    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length < 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);

        }

    }

    private static String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix(strs, start, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }

    }

    private static String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }

        }
        return lcpLeft.substring(0, minLength);
    }


    //方法四：使用二分法去查找


}
