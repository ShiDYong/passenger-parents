package com.mason.ATD.iterator;

/**
 * 测试接口中的default
 *
 * @author ShiYong
 * @create 2022-04-15 13:55
 **/
public class Implementation implements InterfaceWithDefault{
    @Override
    public void firstMethod() {
        System.out.println("firstMethod");
    }

    @Override
    public void secondMethod() {
        System.out.println("secondMethod");
    }

    /**
     * 如果我们使用关键字 default为 `newMethod()` 方法提供默认的实现，
     * 那么所有与接口有关的代码能正常工作，不受影响，而且这些代码还可以调用新的方法 `newMethod()`：
     * 增加默认方法的极具说服力的理由是它允许在不破坏已使用接口的代码的情况下，在接口中增加新的方法。
     * 默认方法有时也被称为*守卫方法*或*虚拟扩展方法*。
     * @param args
     */
    public static void main(String[] args) {
        InterfaceWithDefault i = new Implementation();
        i.firstMethod();
        i.secondMethod();
        i.newMethod();
    }
}
