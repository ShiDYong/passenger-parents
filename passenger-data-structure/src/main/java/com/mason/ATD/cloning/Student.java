package com.mason.ATD.cloning;

import java.util.stream.Stream;

/**
 * @author Mason
 * @Description TODO
 * @date 2022/4/29 10:57
 */
public class Student implements Cloneable {

    private Name fullName;
    private String id;

    public Student() {
        fullName = new Name();
        id = "";

    }

    public Student(Name fullName, String id) {
        this.fullName = fullName;
        this.id = id;
    }

    public Name getFullName() {
        return fullName;
    }

    public void setFullName(Name fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return id + " " + fullName.toString();
    }


    @Override
    public Object clone(){
        Student theCopy = null;
        try {
           theCopy = (Student)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e.toString());
        }
        //以下这句是克隆数据域fullName,如果没有这语句学生的全名会被原实例及其克隆一起共享。
        //所以这个是深拷贝的。
        theCopy.fullName = (Name) fullName.clone();
        return theCopy;
    }

}