package com.mason.junit.controller;

import com.mason.junit.service.Controller;
import com.mason.junit.service.Request;
import com.mason.junit.service.RequestHandler;
import com.mason.junit.service.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * Cotroller的实现类
 *
 * @author ShiYong
 * @create 2022-03-25 9:01
 **/
public class DefaultController implements Controller {
    //声明一个HashMap来充当请求处理器的出册表
    private Map<String, RequestHandler> requestHandlers = new HashMap<>();

    /**
     * 为接收请求获取RequestHandler
     *
     * @return
     */
    protected RequestHandler getHandler(Request request) {
        //判断注册表中是否存在这样的
        if (!requestHandlers.containsKey(request.getName())) {

            //没有被注册就抛异常
            String message = "Cannot find Handler for request name" + "" +
                    "[" + request.getName() + "]";
            throw new RuntimeException(message);

        }
        //向调用者返回相应的处理器
        return this.requestHandlers.get(request.getName());
    }

    /**
     * 把请求分派给相应的处理器并且传回处理器的respose
     *
     * @param request
     * @return
     */
    @Override
    public Response processRequest(Request request) {
        Response response;
        try {
            response = getHandler(request).process(request);
        } catch (Exception exception) {
            response = new ErrorResponse(request, exception);
        }
        return response;

    }

    @Override
    public void addHandler(Request request, RequestHandler requestHandler) {
        if (this.requestHandlers.containsKey(request.getName())) {
            throw new RuntimeException("A request handler has" + "" +
                    "already been registered for request name" + "" +
                    "[" + request.getName() + "]");
        } else {
            this.requestHandlers.put(request.getName(), requestHandler);
        }
    }
}
