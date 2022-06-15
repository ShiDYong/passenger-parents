package com.mason.fp.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Mason
 * @Description Consumer接口常用的一些方法
 * @date 2022/6/15 22:05
 */
public class ConsumerInterface {

    public static void main(String[] args) {
         List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");
         strings.forEach(new Consumer<String>() {  //匿名内部类的实现
             @Override
             public void accept(String s) {
                 System.out.println(s);
             }
         });

        strings.forEach(s-> System.out.println(s));  //lambda表达式
        strings.forEach(System.out::println);  //方法引用
    }


}
