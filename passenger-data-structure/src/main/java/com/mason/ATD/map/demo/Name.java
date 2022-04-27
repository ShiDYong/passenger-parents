package com.mason.ATD.map.demo;

import com.mason.ATD.sortedList.ImmutableName;

import java.util.Set;

/**
 * @author Mason
 * @Description
 * @date 2022/4/25 09:21
 */
public class Name implements NameInterface, Comparable<Name> {

    private String fullName, first, last;

    public Name() {
        this("", "");
    } // end default constructor

    public Name(String firstName, String lastName) {
        first = firstName;
        last = lastName;
        fullName = first + " " + last;
    } // end constructor

    public Name(ImmutableName aName) {
        this(aName.getFirst(), aName.getLast());
    } // end constructor

    public ImmutableName getImmutable() {
        return new ImmutableName(first, last);
    } // end getImmutable


    /**
     * Sets the first and last names.
     *
     * @param firstName A string that is the desired first name.
     * @param lastName  A string that is the desired last name.
     */
    @Override
    public void setName(String firstName, String lastName) {
        setFirst(firstName);
        setLast(lastName);
        fullName = first + " " + last;
    } // end setname

    /**
     * Gets the full name.
     *
     * @return A string containing the first and last names.
     */
    @Override
    public String getName() {
        return toString();
    } // end getName

    @Override
    public void setFirst(String firstName) {
        first = firstName;
    } // end setFirst

    @Override
    public String getFirst() {
        return first;
    } // end getFirst

    @Override
    public void setLast(String lastName) {
        last = lastName;
    }// end setLast

    @Override
    public String getLast() {
        return last;
    } // end getLast

    @Override
    public void giveLastNameTo(NameInterface aName) {
        aName.setLast(last);
    } // end giveLastNameTo

    @Override
    public String toString() {
        return fullName;
    } // end toString

    @Override
    public int compareTo(Name other) {
        int result = last.compareToIgnoreCase(other.getLast());
        // If last names are equal, check first names
        if (result == 0)
            result = first.compareToIgnoreCase(other.getFirst());
        return result;
    } // end compareTo

    @Override
    public boolean equals(Object o) {
        Name other = (Name) o;
        return (compareTo(other) == 0);
    } // end equals

}
