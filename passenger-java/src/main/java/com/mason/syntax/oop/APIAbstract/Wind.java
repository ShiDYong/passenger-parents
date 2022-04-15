package com.mason.syntax.oop.APIAbstract;

import com.mason.syntax.oop.polymorphism.Note;

/**
 * 继承类
 *
 * @author ShiYong
 * @create 2022-04-15 11:07
 **/
public class Wind extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Wind.play()" + n);
    }

    @Override
    public String what() {
        return "Wind";
    }

    @Override
    public void adjust() {
        System.out.println("Wind.adjust()");
    }
}
