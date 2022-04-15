package com.mason.ATD.chapter06.stock;

/**
 * 测试类
 *
 * @author ShiYong
 * @create 2022-04-11 16:52
 **/
public class StockSaleDriver {
    public static void main(String[] args) {
//        StockLedger testStock = new StockLedger();
//        testStock.buy(5,5);
//        testStock.buy(5,8);
//        System.out.println(testStock.sell(8, 10));


        StockLedger02 testStock = new StockLedger02();
        testStock.buy(5,5);
        testStock.buy(5,8);
        System.out.println(testStock.sell(8, 10));
    }
}
