package com.mason.fp.baseLambda;

/**
 * @author Mason
 * @Description 函数式接口是一种单一抽象方法的接口
 *              类通过为接口中的所有方法提供实现来实现任何接口，
 *              这可以通过顶级类、内部类、甚至匿名内部类完成
 * @date 2022/5/10 15:29
 */
public interface Body {
    String detailed(String head);
}
