package com.mason.ATD.cloning;


/**
 * @author Mason
 * @Description A class that represents a name
 *  克隆是对象的拷贝。通常我们仅克隆可变对象，因为一个共享一个不可变对象是安全的
 *  ，克隆常常没有什么必要。类Object含有一个保护方法clone(),返回对象的拷贝。
 * 因为clone方法是保护的，且Object类是所有其它类的超类，所以任意方法的实现中都可以调用
 * super.clone().但是类的客户不能调用，除非类重写了它且将它生命力为公有的。
 * 如果想让你的类含有一个公共的clone方法，类就必须实现Java接口Cloneable来声明这件事。
 * @date 2022/4/29 10:25
 */
public class Name implements Cloneable {
    private String first;
    private String last;

    public Name() {
    }

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }


    public void setName(String first, String last) {
        setFirst(first);
        setLast(last);
    }

    public String getName() {
        return toString();
    }

    @Override
    public String toString() {
        return first + " " + last;
    }

    public void giveLastNameTo(NameInterface aName) {
        aName.setLast(last);
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public Object clone() {
        Name theCopy = null;
        try {
            theCopy = (Name) super.clone();

        } catch (CloneNotSupportedException e) {
            System.err.println("Name cannot clone: " + e.toString());
        }
        return theCopy;
    }
}
