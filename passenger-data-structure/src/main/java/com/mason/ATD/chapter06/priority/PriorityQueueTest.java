package com.mason.ATD.chapter06.priority;

import java.sql.Date;
import java.util.PriorityQueue;

/**
 * 测试类
 *
 * @author ShiYong
 * @create 2022-04-12 10:04
 **/
public class PriorityQueueTest {
    public static void main(String[] args) {
        AssignmentLog myHomework = new AssignmentLog();
        myHomework.addProject("CSC211", "Pg 50, Ex 2", Date.valueOf("2019-11-20"));
        Assignment pg75Ex8 = new Assignment("CSC215", "Pg 75, Ex 8", Date.valueOf("2019-3-14"));
        myHomework.addProject(pg75Ex8);
        System.out.println("The following assignment is due next:");
        System.out.println(myHomework.getNextProject());

    }
}
