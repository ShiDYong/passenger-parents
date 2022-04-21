package com.mason.ATD.sortedList;

/**
 * 只读类的实现
 *
 * @author ShiYong
 * @create 2022-04-21 9:44
 **/
public final class ImmutableName {
    private String first;
    private String last;

    public ImmutableName(String firstName, String lastName) {
        this.first = firstName;
        this.last = lastName;
    }
    public ImmutableName(Name aName){
        first = aName.getFirst();
        last = aName.getLast();
    }
    public Name getMutable(){
        return new Name(first,last);
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getName() {
        return toString();
    }


    @Override
    public String toString() {
        return first + " " + last;
    }

}
