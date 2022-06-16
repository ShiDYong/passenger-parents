package com.mason.junit.exception;

/**
 * @author Mason
 * @Description 实现CircularQueue的自定义异常类
 * @date 2022/5/24 21:30
 */
public class CircularQueueException extends RuntimeException{
    public CircularQueueException(String why){
        super(why);
    }
}
