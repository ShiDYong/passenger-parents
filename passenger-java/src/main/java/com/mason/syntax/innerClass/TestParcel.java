package com.mason.syntax.innerClass;

/**
 * 测试类
 *
 * @author ShiYong
 * @create 2022-04-15 10:25
 **/
public class TestParcel {
    public static void main(String[] args) {
        /**
         * 在 **Parcel4** 中，内部类 **PContents** 是 **private**，所以除了 **Parcel4**，
         * 没有人能访问它。普通（非内部）类的访问权限不能被设为 **private** 或者 **protected**；
         * 他们只能设置为 **public** 或 **package** 访问权限。
         */
        Parce14 p = new Parce14();
        Contents c = p.contents();
        Destination d = p.destination("Tasmania");
        // Illegal -- can't access private class:
        //- Parcel4.PContents pc = p.new PContents();

        /**
         * **private** 内部类给类的设计者提供了一种途径，
         * 通过这种方式可以完全阻止任何依赖于类型的编码，并且完全隐藏了实现的细节。
         * 此外，从客户端程序员的角度来看，由于不能访问任何新增加的、
         * 原本不属于公共接口的方法，所以扩展接口是没有价值的。这也给 Java 编译器提供了生成高效代码的机会
         * 每个内部类都能独立地继承自一个（接口的）实现，所以无论外部类是否已经继承了某个（接口的）实现，对于内部类都没有影响。
         * 如果没有内部类提供的、可以继承多个具体的或抽象的类的能力，一些设计与编程问题就很难解决。
         * 从这个角度看，内部类使得多重继承的解决方案变得完整。
         * 接口解决了部分问题，而内部类有效地实现了“多重继承”。也就是说，内部类允许继承多个非接口类型（译注：类或抽象类）
         * 为了看到更多的细节，让我们考虑这样一种情形：即必须在一个类中以某种方式实现两个接口。
         * 由于接口的灵活性，你有两种选择；使用单一类，或者使用内部类：
         */
    }
}
