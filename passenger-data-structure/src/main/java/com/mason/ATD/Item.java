package com.mason.ATD;

/**
 * 商品详情信息类
 * A class of items for sale.
 *
 * @author ShiYong
 * @create 2022-03-28 14:41
 **/
public class Item {
    private String description;
    private int price;

    public Item(String description, int price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }


    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return description + "\t$" + price / 100 + "." + price % 100;
    }
}
