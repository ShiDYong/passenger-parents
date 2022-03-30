package com.mason.ATD.chapter01;

/**
 * 测试类
 *
 * @author ShiYong
 * @create 2022-03-30 13:43
 **/
public class Coin {
    private int name;
    private int price;

    public Coin(int name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getCoinName() {
        return name;
    }

    public int getValue() {
        return price;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "name=" + name +
                ", price=" + price +
                '}';
    }
}
