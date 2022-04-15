package com.mason.syntax.innerClass;

/**
 * 使用this和new
 *
 * @author ShiYong
 * @create 2022-04-15 10:06
 **/
public class DotThis {
    void f() {
        System.out.println("DotThis.f()");
    }

    public class Test {
    }

    ;

    public class Inner {
        public DotThis outer() {
            /**
             * 如果你需要生成对外部类对象的引用，可以使用外部类的名字后面紧跟圆点和this。
             * 这样产生的引用自动地具有正确的类型，这一点在编译期就被知晓并受到检查，因此没有任何运行时开销
             */
            return DotThis.this;
            // A plain "this" would be Inner's "this"
        }
    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        //内部类对象调用外部类的方法
        dti.outer().f();
        /**
         * 有时你可能想要告知某些其他对象，去创建其某个内部类的对象。
         * 要实现此目的，你必须在 new 表达式中提供对其他外部类对象的引用
         * 这是需要使用 new语法
         * 在拥有外部类对象之前是不可能创建内部类对象的。
         * 这是因为内部类对象会暗暗地连接到建它的外部类对象上。
         * 但是，如果你创建的是嵌套类（静态内部类），那么它就不需要对外部类对象的引用。
         */
        DotThis.Test dtt = dt.new Test();

    }
}
