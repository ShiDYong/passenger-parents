package com.mason.syntax.basic;


import com.mason.syntax.oop.Cat;

/**
 * ==和equals比较
 *
 * == ：基本数据类型：比较的是值是否相同   引用类型：比较的是引用是否相同
 * equals解读本质上就是==，只不过String和Interge等重写了equals方法，把它变成了值比较。
 *
 * 总结：== 对于基本类型来说是值比较，对于引用类型来说是比较的是引用；
 * 而 equals 默认情况下是引用比较，只是很多类重新了 equals 方法，
 * 比如 String、Integer 等把它变成了值比较，所以一般情况下 equals 比较的是值是否相等
 *
 * @author ShiYong
 * @create 2022-02-14 16:06
 **/
public class TestEquals {
    private Cat cat1;

    public static void main(String[] args) {
        String x = "string";
        String y = "string";
        String z = new String("string");
        System.out.println(x == y);
        System.out.println(x == z);
        System.out.println(x.equals(y));
        System.out.println(x.equals(z));


        Cat cat1= new Cat("Mason");
        Cat cat2= new Cat("Mason");

        System.out.println(cat1.equals(cat2));



    }
}
