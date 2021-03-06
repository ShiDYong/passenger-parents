package com.mason.ATD.sortedList;

/**
 * 只读类的实现
 *
 * @author ShiYong
 * @create 2022-04-21 9:44
 **/
public final class ImmutableName {
    private String first; // First name
    private String last; // Last name

    public ImmutableName(String firstName, String lastName) {
        first = firstName;
        last = lastName;
    } // end constructor

    public ImmutableName(Name aName) {
        first = aName.getFirst();
        last = aName.getLast();
    } // end constructor

    public Name getMutable() {
        return new Name(first, last);
    } // end getMutable

    public String getFirst() {
        return first;
    } // end getFirst

    public String getLast() {
        return last;
    } // end getLast

    public String getName() {
        return toString();
    } // end getName

    @Override
    public String toString() {
        return first + " " + last;
    } // end toS
}
