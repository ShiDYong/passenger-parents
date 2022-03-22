package com.mason.syntax.basic;

/**
 * 将字符串反转和字符串常见的操作
 *
 * @author ShiYong
 * @create 2022-02-15 10:53
 **/
public class ReversalString {

  //方法一：使用StringBuilder的reverse()方法实现字符串的反转
    static String reverse(String originalStr){
        StringBuilder stringBuilder = new StringBuilder(originalStr);
        return  stringBuilder.reverse().toString();

    }

    //方法二：使用遞歸方法實現字符串的反轉
    static String recursion(String originalStr){
        if (originalStr == null || originalStr.length() <= 1){
            return originalStr;
        }
        return reverse(originalStr.substring(1))+originalStr.charAt(0);

    }


    public static void main(String[] args) {
        System.out.println(recursion("123456"));
        System.out.println(recursion("abcdefg"));
    }
}
