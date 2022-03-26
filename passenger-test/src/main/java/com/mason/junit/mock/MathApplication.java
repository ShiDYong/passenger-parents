package com.mason.junit.mock;


/**
 * 引用该接口的方法的类
 *
 * @author ShiYong
 * @create 2022-03-25 11:57
 **/
public class MathApplication {
    private CalculatorService calService;

    public void setCalculatorService(CalculatorService calService) {
        this.calService = calService;
    }


    public double add(double input1, double input2) {
        return calService.add(input1, input2);
    }

    public double subtract(double input1, double input2) {
        return calService.subtract(input1, input2);
    }

    public double mutiplay(double input1, double input2) {
        return calService.multiplay(input1, input2);
    }


    public double divide(double input1, double input2) {
        return calService.divide(input1, input2);
    }
}
