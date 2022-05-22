package com.mason.junit.controller;

import java.util.ArrayList;

/**
 * @author Mason
 * @Description TODO
 * @date 2022/5/21 21:43
 */
public class CountedList extends ArrayList<String> {
    private static int counter = 0;
    private  int id = counter++;
    public CountedList(){
        System.out.println("CountedList #" + id);
    }
    public int getId(){
        return id;
    }

}
