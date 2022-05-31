package com.mason.fp.mehtodReferences;

import java.util.function.Function;

/**
 * @author Mason
 * @Description TODO
 * @date 2022/5/11 11:06
 */
public class FunctionalAnnotation {
    public String goodbye(String msg) {
        return "Goodbye" + msg;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        //如果将方法引用或Lambda表达式赋值给函数式接口(类型需要匹配),Java会适配你的赋值到目标接口
        //编译器会在后台把方法引用或Lambda表达式包装进实现目标接口的类的实例中。
        Functional f = fa::goodbye;
        FunctionalNoAnn fna = fa::goodbye;

        Functional f1 = a -> "Goodbye," + a;
        FunctionalNoAnn fnal = a -> "Goodbye," + a;
    }


}
