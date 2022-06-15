package com.mason.fp.function;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Mason
 * @Description 该接口主要用于流的筛选
 * @date 2022/6/15 22:31
 */
public class Predicate {

    //public static final Predicate<String> LENGTH_FIVE = s ->s.length() == 5;
    public static void main(String[] args) {
         String nameOfLength = getNameOfLength(3, "Mason", "jdk", "jvm");
        System.out.println("nameOfLength = " + nameOfLength);

    }

    //单一抽象方法，查找给定长度的字符串
    public static String getNameOfLength(int length,String... names){
        return Arrays.stream(names).filter(s ->s.length() == length)
                .collect(Collectors.joining(", "));
    }
    //满足给定长度字符串的谓词
    public static String getNamesStartingWith(String s, String...names){
        return Arrays.stream(names).filter(str ->str.startsWith("j"))
                .collect(Collectors.joining(", "));
    }

    //查找满足任意谓词的字符串
//    public static   String getNamesSatisfyingCondition(Predicate<String> condition, String...names){
//        return Arrays.stream(names).filter(condition).collect(Collectors.joining(", "));
//
//    }
}
