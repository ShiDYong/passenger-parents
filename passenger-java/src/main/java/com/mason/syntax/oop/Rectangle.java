package com.mason.syntax.oop;

/**
 * 类的构造器
 *
 * @author ShiYong
 * @create 2022-02-21 11:13
 **/
public class Rectangle {
    private int x, y;
    private int width,height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle(){
        this(0,0,1,1);
    }
    public Rectangle(int width, int height) {
        this(0, 0, width, height);
    }

}
