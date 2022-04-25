package com.mason.ATD.map.demo;

import com.mason.ATD.map.DictionaryInterface;
import com.mason.ATD.map.SortedLinkedDictionary;

import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Mason
 * @Description TODO
 * @date 2022/4/25 09:17
 */
public class TelephoneDirectory {
    private DictionaryInterface<Name, String> phoneBook;


    public TelephoneDirectory() {
        phoneBook = new SortedLinkedDictionary<>();
    }

    public void readFile(Scanner data) {
        data.useDelimiter("[\n ,]");
        while (data.hasNext()) {
            String firstName = data.next();
            String lastName = data.next();
            String phoneNumber = data.next();
            Name fullName = new Name(firstName, lastName);
            phoneBook.add(fullName, phoneNumber);
        }

    }

    public String getPhoneNumber(Name personName) {
        return phoneBook.getValue(personName);
    }

    public String getPhoneNumber(String firstName, String lastName) {
        Name fullName = new Name(firstName, lastName);
        return phoneBook.getValue(fullName);
    }

    public String changerPhoneNumber(Name personName, String newPhoneNumber) {
        return phoneBook.add(personName, newPhoneNumber);
    }

    public String remove(Name personName) {
        return phoneBook.remove(personName);
    }

    public void display() {
        Iterator<Name> keyIterator = phoneBook.getKeyIterator();
        Iterator<String> valueIterator = phoneBook.getValueIterator();

        System.out.println("-------------------------------------");
        int index = 0;
        while (keyIterator.hasNext()) {
            System.out.println(index + " " + keyIterator.next() + "\t"
                    + valueIterator.next());
            index++;
        }
        System.out.println("-------------------------------------");
        System.out.println();
    } // end display

    public void test(Name name) {
        Iterator<Name> keyIterator = phoneBook.getKeyIterator();
        boolean found = false;
        while (!found && keyIterator.hasNext()) {
            Name nextKey = keyIterator.next();
            found = name.equals(nextKey);
            System.out.println(nextKey.getName() + " == " +
                    name + ": " + found);
        }
    }
}






















