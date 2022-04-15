package com.mason.syntax.innerClass;

/**
 * 内部类的语法
 *
 * @author ShiYong
 * @create 2022-04-15 9:33
 **/
public class Parcell {
    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents contents() {
        return new Contents();
    }

    public void ship(String dest) {
        Contents c = contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        /**
         * 如果想从外部类的非静态方法之外的任意位置创建某个内部类的对象，
         * 那么必须像在 `main()` 方法中那样，具体地指明这个对象的类型：*OuterClassName.InnerClassName*。
         * (译者注：在外部类的静态方法中也可以直接指明类型 *InnerClassName*，
         * 在其他类中需要指明 *OuterClassName.InnerClassName*
         */
        Parcell p = new Parcell();
        p.ship("Tasmania");
        Parcell q = new Parcell();
        // Defining references to inner classes:
        Parcell.Contents c = q.contents();
        Parcell.Destination d = q.to("Borneo");
    }
}
