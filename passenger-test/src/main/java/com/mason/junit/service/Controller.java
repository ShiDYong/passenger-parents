package com.mason.junit.service;

/**
 * @author shiyong
 */
public interface Controller {
    /**
     * 该顶层方法用来处理收到的请求将请求分发给相应的requestHanddler.
     * @param request
     * @return
     */
    Response processRequest(Request request);
    void addHandler(Request request, RequestHandler requestHandler);
}
