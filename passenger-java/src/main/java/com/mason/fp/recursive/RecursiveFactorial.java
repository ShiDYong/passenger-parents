package com.mason.fp.recursive;

import com.mason.fp.recursive.IntCall;

/**
 * @author Mason
 * @Description 通过Lambda表达式的递归使用，实现n的阶乘
 * 注意： 递归方法必须是实例变量或者静态变量，否则会出现编译错误
 * @date 2022/5/10 16:17
 */
public class RecursiveFactorial {
    static IntCall fact;

    public static void main(String[] args) {
        fact = n -> n == 0 ? 1 : n * fact.call(n - 1);
        for (int i = 0; i < 10; i++) {
            System.out.println(fact.call(i));

        }

    }
}
