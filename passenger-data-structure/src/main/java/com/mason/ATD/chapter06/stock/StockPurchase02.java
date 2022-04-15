package com.mason.ATD.chapter06.stock;

/**
 * 改進方法
 *
 * @author ShiYong
 * @create 2022-04-11 17:24
 **/
public class StockPurchase02 {

    private int share;
    private double cost;

    public StockPurchase02(int share, double cost) {
        this.share = share;
        this.cost = cost;
    }

    public int getShare() {
        return share;
    }

    public double getCost() {
        return cost;
    }
}
