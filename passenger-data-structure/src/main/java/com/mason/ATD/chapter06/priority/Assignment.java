package com.mason.ATD.chapter06.priority;


import java.sql.Date;

/**
 * 安排类
 *
 * @author ShiYong
 * @create 2022-04-12 9:42
 **/
public class Assignment implements Comparable<Assignment> {

    //课程代码
    private String courseCode;
    //指派描述
    private String task;
    //截止日期
    private Date date;

    public Assignment() {
    }

    public Assignment(String courseCode, String task, Date date) {
        this.courseCode = courseCode;
        this.task = task;
        this.date = date;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTask() {
        return task;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public int compareTo(Assignment other) {
        return date.compareTo(other.date);
    }

    @Override
    public String toString()
    {
        String result = "Course Number: " + courseCode;
        result += "\t Due date: " + date;
        result += "\t Task: " + task;

        return result;
    } // end toSt
}
