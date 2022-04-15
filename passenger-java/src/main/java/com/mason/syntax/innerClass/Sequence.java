package com.mason.syntax.innerClass;

/**
 * 内部类的使用
 * 迭代器设计模式的一种：内部类迭代器
 * @author ShiYong
 * @create 2022-04-15 9:46
 **/
public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];

    }

    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length)
                i++;
        }

    }

    public Selector selector() {
        return new SequenceSelector();
    }


    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int index = 0; index < 10; index++) {
            sequence.add(Integer.toString(index));

        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current() + " ");
            selector.next();
        }

        /**
         * 然而内部类可以访问其外部类的方法和字段，就像自己拥有它们似的
         * 当某个外部类的对象创建了一个内部类对象时，此内部类对象必定会秘密地捕获一个指向那个外部类对象的引用。
         * 然后，在你访问此外部类的成员时，就是用那个引用来选择外部类的成员。幸运的是，编译器会帮你处理所有的细节，但你现在可以看到：
         * 内部类的对象只能在与其外部类的对象相关联的情况下才能被创建（就像你应该看到的，内部类是非 **static** 类时）。
         * 构建内部类对象时，需要一个指向其外部类对象的引用，如果编译器访问不到这个引用就会报错。不过绝大多数时候这都无需程序员操心。
         */
    }
}
