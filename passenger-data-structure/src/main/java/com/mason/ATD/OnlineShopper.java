package com.mason.ATD;

/**
 * 在线购物车袋的维护类
 * A class that maintains a shopping cart for
 * online store.
 *
 * @author ShiYong
 * @create 2022-03-28 14:50
 **/
public class OnlineShopper {
    public static void main(String[] args) {
        Item[] items = {new Item("Bird feeder", 2050),
                new Item("Squirrel guard", 1457),
                new Item("Bird bath", 4499),
                new Item("Sunflower seeds", 1295)

        };
        BagInterface<Item> shoppingCart = new Bag();
        int totalCost = 0;
        //Statements that add selected item to the shopping cart;
        for (int index = 0; index < items.length; index++) {
            Item nextItem = items[index];
            shoppingCart.add(nextItem);
            totalCost =  (totalCost + nextItem.getPrice());

        }
        //Simulate checkout
        while (!shoppingCart.isEmpty()) {
            System.out.println(shoppingCart.remove());
        }
        System.out.println("Total cost: " + "\t$" + totalCost / 100 + "." + totalCost % 100);

    }
}
