package com.junit.test;

import com.mason.junit.mock.MathApplication;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * 测试类
 *
 * @author ShiYong
 * @create 2022-03-25 14:02
 **/
public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MathApplication.class);
        for (Failure failure:result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());

    }
}
