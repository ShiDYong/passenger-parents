package com.mason.junit.mock;

/**
 * @author shiyong
 */
public interface CalculatorService {
    /**
     * 加法的接口
     *
     * @param input1
     * @param input2
     * @return
     */
    double add(double input1, double input2);

    /**
     * 减法的接口
     * @param input1
     * @param input2
     * @return
     */
    double subtract(double input1, double input2);

    /**
     * 乘法的接口
     * @param input1
     * @param input2
     * @return
     */
    double multiplay(double input1, double input2);


    /**
     * 除法的接口
     * @param input1
     * @param input2
     * @return
     */
    double divide(double input1, double input2);
}
