package com.mason.syntax.oop.APIAbstract;

import com.mason.syntax.oop.polymorphism.Note;

/**
 * @author ShiYong
 * @create 2022-04-15 11:12
 **/
public class Music4 {
    // Doesn't care about type, so new types
    // added to system still work right:
    static void tune(Instrument i) {
        // ...
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Instrument[] e) {
        for (Instrument i: e) {
            tune(i);
        }
    }

    public static void main(String[] args) {
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }

    /**
     * 抽象类，一种介于普通类和接口之间的折中手段。
     * 尽管你的第一想法是创建接口，但是对于构建具有属性和未实现方法的类来说，抽象类也是重要且必要的工具
     * Java 提供了一个叫做*抽象方法*的机制，这个方法是不完整的：它只有声明没有方法体。下面是抽象方法的声明语法：
     * abstract void f();
     * 包含抽象方法的类叫做*抽象类*。
     * 如果一个类包含一个或多个抽象方法，那么类本身也必须限定为抽象的，否则，编译器会报错。
     * 如果一个抽象类是不完整的，当试图创建这个类的对象时，Java 会怎么做呢？它不会创建抽象类的对象，所以我们只会得到编译器的错误信息。这样保证了抽象类的纯粹性，我们不用担心误用它。
     * 如果创建一个继承抽象类的新类并为之创建对象，那么就必须为基类的所有抽象方法提供方法定义。如果不这么做（可以选择不做），新类仍然是一个抽象类，编译器会强制我们为新类加上 **abstract** 关键字。
     * 创建抽象类和抽象方法是有帮助的，因为它们使得类的抽象性很明确，并能告知用户和编译器使用意图。
     * 抽象类同时也是一种有用的重构工具，使用它们使得我们很容易地将沿着继承层级结构上移公共方法。
     *
     *
     * |         特性         |                            接口                            |                  抽象类                  |
     * | :------------------: | :--------------------------------------------------------: | :--------------------------------------: |
     * |         组合         |                    新类可以组合多个接口                       |            只能继承单一抽象类            |
     * |         状态         |        不能包含属性（除了静态属性，不支持对象状态）               | 可以包含属性，非抽象方法可能引用这些属性 |
     * | 默认方法 和 抽象方法    | 不需要在子类中实现默认方法。默认方法可以引用其他接口的方法           |         必须在子类中实现抽象方法         |
     * |        构造器        |                         没有构造器                          |               可以有构造器               |
     * |        可见性        |                      隐式 **public**                       |    可以是 **protected** 或 "friendly"    |
     */

}
