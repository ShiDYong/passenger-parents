package com.mason.fp.recursive;

/**
 * @author Mason
 * @Description 斐波那契数列的实现
 * @date 2022/5/10 16:26
 */
public class RecursiveFibonacci {
    IntCall fib;

    //通过构造器
    RecursiveFibonacci() {
        //注意使用三元if-else
        fib = n -> n == 0 ? 0 : n == 1 ? 1 : fib.call(n - 1) + fib.call(n - 2);
    }

    int fibonacci(int n) {
        return fib.call(n);
    }

    public static void main(String[] args) {
         RecursiveFibonacci rf = new RecursiveFibonacci();
        for (int i = 0; i < 10; i++) {
            System.out.println(rf.fibonacci(i));

        }

    }

}
