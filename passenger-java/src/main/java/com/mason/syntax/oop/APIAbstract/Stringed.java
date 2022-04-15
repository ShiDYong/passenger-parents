package com.mason.syntax.oop.APIAbstract;

import com.mason.syntax.oop.polymorphism.Note;

/**
 * 继承类
 *
 * @author ShiYong
 * @create 2022-04-15 11:10
 **/
public class Stringed extends Instrument{
    @Override
    public void play(Note n) {
        System.out.println("Stringed.play() " + n);
    }

    @Override
    public String what() {
        return "Stringed";
    }

    @Override
    public void adjust() {
        System.out.println("Adjusting Stringed");
    }
}
