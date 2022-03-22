package com.mason.syntax.basic;

/**
 * 牛客网测试题
 *
 * @author ShiYong
 * @create 2022-02-22 13:53
 **/
public class NowCodeTest {
    private int z;
    private Integer h;

    public static void main(String[] args) {
//        String x = "7";
//        int y = 2;
//        int z = 2 ;
//        System.out.println(x+y+z);
//        System.out.println(y+z+x);
//        System.out.println(y+x+z);


        //基本型和基本型封装型进行“==”运算符的比较，基本型封装型将会自动拆箱变为基本型后再进行比较，
        // 因此Integer(0)会自动拆箱为int类型再进行比较，显然返回true；
//        int a = 220;
//        Integer b = 220;
//        System.out.println(a==b);

        //两个Integer类型进行“==”比较， 如果其值在-128至127  ，那么返回true，
        // 否则返回false, 这跟Integer.valueOf()的缓冲对象有关，这里不进行赘述
        Integer c=3;
        Integer h= 3;
        Integer e=321;
        Integer f=321;
        System.out.println(c == h);
        System.out.println(e==f);


    }

}
