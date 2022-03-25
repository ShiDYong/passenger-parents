package com.junit.test;


import com.mason.junit.mock.CalculatorService;
import com.mason.junit.mock.MathApplication;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 测试类
 *
 * @author ShiYong
 * @create 2022-03-25 13:45
 **/
//@RunWith attaches a runner with the test calss to initailize the test data
@RunWith(EasyMockRunner.class)
public class MathApplicationTester {
    //@TestSubject annotation is used to identify class which is going to use the
    //mock object
    @TestSubject
    MathApplication mathApplication = new MathApplication();

    //Mock annotation is used to create the mock object to be injected
    @Mock
    CalculatorService calService;

    @Test(expected = RuntimeException.class)
    public void testAdd(){
        //add the behavior to throw execption:模拟实现调用CalculatorService接口调用add()方法
        EasyMock.expect(calService.add(10.0,20.0)).andThrow(new RuntimeException("Add operation not " +
                "implemented"));
        //active the mock ,EasyMock准备模拟帝乡，以便它可以被用于测试目的
        EasyMock.replay(calService);

        //test the add functionality
        Assert.assertEquals(mathApplication.add(10.0,20.0),30.0);

        //verify call to calService is mde or not
        EasyMock.verify(calService);

    }

}
