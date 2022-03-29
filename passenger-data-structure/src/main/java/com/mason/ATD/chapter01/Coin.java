package com.mason.ATD.chapter01;

/**
 * 实体类
 *
 * @author ShiYong
 * @create 2022-03-28 15:46
 **/
public class Coin {
    private int price;
    private int year;

    public int getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public Coin(int price, int year) {

        this.price = price;
        this.year = year;
    }
}
