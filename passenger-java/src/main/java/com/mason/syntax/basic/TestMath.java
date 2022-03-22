package com.mason.syntax.basic;

/**
 * 测试
 *
 * @author ShiYong
 * @create 2022-02-15 10:39
 **/
public class TestMath {
    public static void main(String[] args) {
        long round = Math.round(-1.5);
        long r2 = Math.round(1.5);
        long r3 = Math.round(0.5);
        System.out.println("r3 = " + r3);
        System.out.println("r2 = " + r2);
        System.out.println("round = " + round);
    }
}
