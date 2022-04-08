package com.mason.ATD.chapter05;

/**
 * 前中后缀表达式的测试类
 *
 * @author ShiYong
 * @create 2022-04-07 15:04
 **/
public class ExpressionTestDemo {
    public static void main(String[] args) {
        String expression = "a {b [c (d + e)/2 -f]+1}";
        boolean isBlanced = BalanceChecker.checkBalance(expression);
        if (isBlanced)
            System.out.println(expression + "is balanced");
        else
            System.out.println(expression + "is not balance");
    }
}
