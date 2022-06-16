package com.mason.fp.function;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mason
 * @Description Function接口包含单一抽象方法为apply, 它可以将T类型的范型输入参数转换为R类
 * 型的范型输出值，常用的用法是作为Stream.map方法的一个参数
 * @date 2022/6/15 22:51
 */
public class Function<S, I extends Number> {
    public static void main(String[] args) {
        //将字符串映射到它们的长度
        List<String> names = Arrays.asList("Mal", "Wash", "Kaylee", "Lnara", "Zoe", "Jayne",
                "Simon", "River", "Shepherd Book");
//        List<Integer> nameLengths = names.stream()
//                .map(new Function<String,Integer>(){
//                    @Override
//                    public Integer apply(String s){
//                        return s.length();
//                    }
//                }).collect(Collectors.toList());

        //lambda表达式
        List<Integer> nameLengths = names.stream().map(s -> s.length()).collect(Collectors.toList());
        //方法引用
        nameLengths = names.stream().map(String::length)
                .collect(Collectors.toList());
    }


}
