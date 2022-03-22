package com.mason.syntax.oop;

/**
 * 山地自行車
 *
 * @author ShiYong
 * @create 2022-02-21 9:37
 **/
public class MountainBike extends Bicycle {
    public int seatHeight;

    public MountainBike(int startCadence, int startGear, int startSpeed,int startHeight) {
        super(startCadence, startGear, startSpeed);
        seatHeight = startHeight;
    }
    public void setHeight(int newValue){
        seatHeight= newValue;
    }

    public static void main(String[] args) {
        MountainBike mBike = new MountainBike(12, 13, 14, 15);

    }
}
