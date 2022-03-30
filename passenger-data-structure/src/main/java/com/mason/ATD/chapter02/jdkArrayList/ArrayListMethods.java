package com.mason.ATD.chapter02.jdkArrayList;

import java.util.ArrayList;

/**
 * ArrayList的常用方法集合
 *
 * @author ShiYong
 * @create 2022-03-30 17:59
 **/
public class ArrayListMethods {
    public static void main(String[] args) {
        ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        System.out.println(sites.get(1));  // 访问第二个元素
        //修改元素
        sites.set(2,"WIKI");
        System.out.println(sites);

    }
}
