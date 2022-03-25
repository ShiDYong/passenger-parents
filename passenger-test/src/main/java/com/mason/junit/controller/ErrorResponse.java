package com.mason.junit.controller;

import com.mason.junit.service.Request;
import com.mason.junit.service.Response;

/**
 * 异常处理类
 *
 * @author ShiYong
 * @create 2022-03-25 9:22
 **/
public class ErrorResponse implements Response {
    private Request originalRequest;
    private Exception originalException;

    public ErrorResponse(Request request, Exception exception) {
        this.originalRequest = request;
        this.originalException = exception;
    }

    public Request getOriginalRequest() {
        return originalRequest;
    }

    public Exception getOriginalException() {
        return originalException;
    }
}
