package com.mason.fp.mehtodReferences;

/**
 * @author Mason
 * @Description TODO
 * @date 2022/5/10 16:46
 */
public class MethodReferences {
    static void hello(String name) {
        System.out.println("Hello," + name);
    }

    static class Description {
        String about;

        Description(String desc) {
            about = desc;
        }

        void help(String msg) {
            System.out.println(about + " " + msg);
        }
    }

    static class Helper {
        static void assist(String msg) {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        //show()的签名(参数类型和返回类型)符合Callable的call()的签名
        Describe d = new Describe();
        /**
         *这里将Describe对象的方法引用赋值给Callable，它没有show()方法，
         * 而是call()方法。但是，Java似乎接受用这个看似奇怪的赋值，因为方法引用
         * 符合Callable的call()方法签名
         */
        Callable c = d::show; //[6]
        c.call("call()"); //[7] 可用通过调用call()来调用show()，因为Java将call映射
        //到show().

        c = MethodReferences::hello;  //[8] 这是一个静态方法引用
        c.call("Bob");

        c = new Description("valueable")::help;  //[9] 对已实例化对象的方法的引用
        //，有时称为绑定方法引用
        c.call("information");

        c = Helper::assist; //[10]
        c.call("Help");

    }

}
