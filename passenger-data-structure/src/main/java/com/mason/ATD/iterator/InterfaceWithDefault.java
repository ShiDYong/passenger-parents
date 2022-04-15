package com.mason.ATD.iterator;

/**
 * @author shiyong
 */
public interface InterfaceWithDefault {
    void firstMethod();
    void secondMethod();

    /**
     * Java 8 为关键字 default增加了一个新的用途（之前只用于 switch语句和注解中）。
     * 当在接口中使用它时，任何实现接口却没有定义方法的时候可以使用 default创建的方法体。
     * 默认方法比抽象类中的方法受到更多的限制，但是非常有用
     * @return
     */
    default void newMethod() {
        System.out.println("newMethod");
    }
}
