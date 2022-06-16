package com.mason.junit.controller;

import com.google.common.base.Preconditions.*;

import static com.google.common.base.Preconditions.*;
//要静态导入

/**
 * @author Mason
 * @Description 在构造函数中使用Guaua来防止包含NUll值的对象构造
 * @date 2022/5/26 22:04
 */
public class NonNullConstruction {
    private Integer n;
    private String s;

    public NonNullConstruction(Integer n, String s) {
        this.n = checkNotNull(n);
        this.s = checkNotNull(s);
    }

    public static void main(String[] args) {
        NonNullConstruction nnc = new NonNullConstruction(3, "Trust");
    }
}
