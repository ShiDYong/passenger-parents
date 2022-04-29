package com.mason.ATD.cloning;

import com.mason.ATD.listsAndInheritance.ListInterface;

/**
 * @author Mason
 * @Description 测试Java中克隆的使用
 * @date 2022/4/29 10:40
 */
public class CloneTest {
    public static void main(String[] args) {
        /**
         * Java中的两种克隆方法：当克隆方法clone一个对象时，它拷贝对象的数据域。当数据域本身又是一个对象时，可以用
         * 下列两种方法之一进行拷贝：
         * *      1。浅克隆：可以拷贝指向数据对象的引用，并与克隆共享对象。称为浅克隆shallow clone
         *        2.深克隆：可以拷贝对象本身。当一个被克隆对象又有原始组建对西那个的克隆时，称为深克隆deep clone.
         *        Object类的clone()方法返回的是一个浅克隆。
         */
        Name april = new Name("April", "Jones");
        //克隆twin是浅克隆，因为没有拷贝姓氏和名字中的字符串
        //浅克隆对类Name已经足够好了。String的实例是不可变的。让Name的实例和其克隆共享一个相同的字符串
        //不会有问题，因为没有人能改变字符串。
        Name twin = (Name) april.clone();
        //当要改变克隆的姓氏需要写语句
        twin.setLast("Smith");
        System.out.println("april中的姓氏是：" + april.getLast());
        System.out.println("twin中的姓氏是：" + twin.getLast());
        //发现twin的姓氏变成了Smith,但april的任然是Jones.即setLast改变的是twin的数据域last,故它指向
        //另一个字符串Smith.

        /////////////////////////////演示深拷贝/////////////////////////////////
        Student x = new Student(april, "01");
        Student y = (Student) x.clone();
        Name xFullName = x.getFullName();
        xFullName.setLast("Smith");
        //当Student中clone方法内有克隆fullName时，修改x的姓氏不会改变y的姓氏
        //因为克隆 y 有一个 Name 对象，它不同于 x 的 Name 对象，因为进行的是深拷贝
        System.out.println("y的姓氏： " + y.getFullName().getLast());
        System.out.println("x的姓氏： " + x.getFullName().getLast());
        //相反当Student的clone方法内没有克隆fullName，则修改x的姓氏也会改变y的姓氏
        //两个对象共享同一个Name对象，这是浅拷贝。

        CollegeStudent c = new CollegeStudent(xFullName, "01", 2020, "undergraduate");
        CollegeStudent d = (CollegeStudent) c.clone();

        System.out.println("《《《《《《《《《《《《《《测试数组的克隆》》》》》》》》》》》》");

    }
}
