package com.mason.syntax.oop;


import java.sql.Statement;

/**
 * 类的基本用法
 *
 * @author ShiYong
 * @create 2022-02-21 9:24
 **/
public class Bicycle {
    //the Bicycle class has
    //three fields

    public int cadence;
    public int gear;
    public int speed;

//    public Bicycle(int cadence, int gear, int speed) {
//        this.cadence = cadence;
//        this.gear = gear;
//        this.speed = speed;
//    }

    public Bicycle(int startCadence, int startGear,int startSpeed){
        cadence = startCadence;
        gear = startGear;
        speed = startSpeed;


    }

    public void setCadence(int newValue){
        cadence = newValue;
    }

    public void setCadence(short secondValue){
        cadence = secondValue;
    }

    public void setGear(int newValue){
        gear = newValue;

    }
    public void applyBrake(int decrement){
        speed -= decrement;


    }

    public void speedUp(int increment){
        speed += increment;
    }












}
