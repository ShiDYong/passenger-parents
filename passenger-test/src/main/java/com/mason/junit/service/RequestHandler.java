package com.mason.junit.service;

/**
 * @author shiyong
 */
public interface RequestHandler {
    /**
     * 处理request并返回response的requestHandler
     * 这是一个辅助组件，被设计用来处理大部分的脏活累活，可以调用各种
     * 类，这些类可能抛出任意类型的异常
     * @param request
     * @return
     * @throws Exception
     */
    Response process(Request request) throws Exception;
}
