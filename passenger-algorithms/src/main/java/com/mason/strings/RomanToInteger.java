package com.mason.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * leetocode
 * https://leetcode-cn.com/problems/roman-to-integer/solution/luo-ma-shu-zi-zhuan-zheng-shu-by-leetcod-w55p/
 *
 * @author ShiYong
 * @create 2022-02-22 14:41
 **/
public class RomanToInteger {


    //使用HashMap数据结构来存储罗马字符和对应的数值
    Map<Character, Integer> symbolValue = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);

    }};

    public  int romanInt(String s) {
        int asn = 0;
        int n = s.length();
        if (n < 1) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            //循环遍历获取字符串中对应的数值
            int value = symbolValue.get(s.charAt(i));
            //判断是否存在左边值小于右边值的特殊情况
            if (i < n - 1 && value < symbolValue.get(s.charAt(i + 1))) {
                //右边的值减去左边的值
                asn -= value;

            } else {
                asn += value;
            }


        }
        return asn;


    }
    public static void main(String[] args) {
        String str = "MCMXCIV";
        RomanToInteger roman = new RomanToInteger();
        int romanInt = roman.romanInt(str);
        System.out.println("romanInt = " + romanInt);

    }

}
