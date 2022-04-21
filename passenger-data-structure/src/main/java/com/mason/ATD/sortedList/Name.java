package com.mason.ATD.sortedList;

/**
 * 可变类
 *
 * @author ShiYong
 * @create 2022-04-21 9:51
 **/
public class Name {
    private String first;
    private String last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public Name(ImmutableName aName) {
        first = aName.getFirst();
        last = aName.getLast();
    }

    public ImmutableName getImmutable() {
        return new ImmutableName(first, last);
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

    public Name getName() {
        return new Name(first, last);
    }

}

