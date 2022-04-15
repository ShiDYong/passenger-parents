package com.mason.syntax.oop.APIAbstract;

import com.mason.syntax.oop.polymorphism.Note;

/**
 * @author ShiYong
 * @create 2022-04-15 11:11
 **/
public class Woodwind extends Wind {
    @Override
    public void play(Note n) {
        System.out.println("Woodwind.play() " + n);
    }

    @Override
    public String what() {
        return "Woodwind";
    }
}
