package com.mason.syntax.oop.polymorphism;

/**
 * 音乐类
 *
 * @author ShiYong
 * @create 2022-03-29 10:05
 **/
public class Music {
    public static void tune(Instrument i){
        i.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute);
    }
}
