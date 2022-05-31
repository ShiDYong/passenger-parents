package com.mason.syntax.oop.APIAbstract;

import com.mason.syntax.oop.polymorphism.Note;

import java.util.ArrayList;

/**
 * @author ShiYong
 * @create 2022-04-15 11:11
 **/
public class Brass extends Wind{
    @Override
    public void play(Note n) {
        System.out.println("Brass.play() " + n);
    }
    @Override
    public void adjust() {
        System.out.println("Adjusting Brass");
    }
}
