package com.mason.ATD.chapter06;

/**
 * 队列的异常类
 * A class of runtime exceptions thrown when an attempt is made to access
 * or remove the front of a queue
 *
 * @author ShiYong
 * @create 2022-04-11 11:17
 **/
public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        this(null);

    }

    public EmptyQueueException(String message) {
        super(message);
    }
}
