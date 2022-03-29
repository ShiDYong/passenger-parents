package com.mason.syntax.oop.polymorphism;

/**
 * 管乐器
 *Wind object are instruments
 * @author ShiYong
 * @create 2022-03-29 10:02
 **/
public class Wind  extends Instrument{
    @Override
    public void play(Note n){
        System.out.println("Wind.paly()"+n);
    }
}
