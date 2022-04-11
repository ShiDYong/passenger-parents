package com.mason.ATD.chapter06.waitLine;

import com.mason.ATD.chapter06.waitLine.WaitLine;

/**
 * 测试类
 *  Tests the waitline
 * @author ShiYong
 * @create 2022-04-11 14:51
 **/
public class QueueDriver {
    public static void main(String[] args) {
        WaitLine waitLine = new WaitLine();
        waitLine.simulate(10,0.5,5);
        waitLine.displayResults();
    }

}
