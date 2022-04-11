package com.mason.ATD.chapter06.waitLine;

/**
 * 顾客数
 *
 * @author ShiYong
 * @create 2022-04-11 14:22
 **/
public class Customer {
    private int arrivalTime;
    private int transctionTime;
    private int customerNubmer;

    public Customer() {
    }

    public Customer(int arrivalTime, int transctionTime, int customerNubmer) {
        this.arrivalTime = arrivalTime;
        this.transctionTime = transctionTime;
        this.customerNubmer = customerNubmer;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getTransctionTime() {
        return transctionTime;
    }

    public void setTransctionTime(int transctionTime) {
        this.transctionTime = transctionTime;
    }

    public int getCustomerNubmer() {
        return customerNubmer;
    }

    public void setCustomerNubmer(int customerNubmer) {
        this.customerNubmer = customerNubmer;
    }
}
