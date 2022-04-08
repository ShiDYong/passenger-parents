package com.mason.ATD.chapter02;

import com.mason.ATD.chapter01.ArrayBag;

/**
 * ArrayBag类的测试
 * A test of the methods isEmpty,getCurrentSize,getFrequencyOf,and contains
 * for the class ArrayBag
 *
 * @author ShiYong
 * @create 2022-03-29 17:30
 **/
public class ArrayBagTest02 {
    public static void main(String[] args) {
        // A bag that is not full
        BagInterface<String> aBag = new ArrayBag02<>();

        // Tests on an empty bag
        testIsEmpty(aBag, true);
        String[] testStrings1 = {"A"};
        testFrequency(aBag, testStrings1);
        testContains(aBag, testStrings1);

        // Adding strings
        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        testAdd(aBag, contentsOfBag1);

        // Tests on a bag that is not empty
        testIsEmpty(aBag, false);
        String[] testStrings2 = {"A", "B", "C", "D", "Z"};
        testFrequency(aBag, testStrings2);
        testContains(aBag, testStrings2);

        //----------------------------------------------------------------------

        // A bag that will be full
        aBag = new ArrayBag02<>(7);
        System.out.println("\nA new empty bag:");

        // Tests on an empty bag
        testIsEmpty(aBag, true);
        testFrequency(aBag, testStrings1);
        testContains(aBag, testStrings1);

        // Adding strings
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D"};
        testAdd(aBag, contentsOfBag2);

        // Tests on a bag that is full
        testIsEmpty(aBag, false);
        testFrequency(aBag, testStrings2);
        testContains(aBag, testStrings2);
    }

    //-------------------------------------------------------------------------------------------------

    /**
     * Tests the method isEmpty.
     *
     * @param aBag
     * @param correctResult
     */
    public static void testIsEmpty(BagInterface<String> aBag, boolean correctResult) {
        System.out.print("\nTesting the method isEmpty with ");
        if (correctResult)
            System.out.println("an empty bag:");
        else
            System.out.println("a bag that is not empty:");
        System.out.print("isEmpty finds the bag: ");
        if (correctResult && aBag.isEmpty())
            System.out.println("empty: OK.");
        else if (correctResult)
            System.out.println("not empty, but it is empty:ERROR.");
        else if (!correctResult && aBag.isEmpty())
            System.out.println("empty, but ti is not empty: ERROR.");
        else
            System.out.println("not empty: OK");

    }

    //Test the method getFrequencyOf
    public static void testFrequency(BagInterface<String> aBag, String[] tests) {
        System.out.println("\n Testing the method getFrequencyOf:");
        for (int index = 0; index < tests.length; index++) {
            System.out.println("In this bag, the count of " + tests[index] + "is"
                    + aBag.getFrequencyOf(tests[index]));

        }

    }

    //Test the method contains
    public static void testContains(BagInterface<String> aBag, String[] tests) {
        System.out.println("\nTesting the method contains: ");
        for (int index = 0; index < tests.length; index++) {
            System.out.println("The bag contains: " + aBag.getCurrentSize() + "strings,as follows:");
            System.out.println("Does this bag contain " + tests[index] +
                    "? " + aBag.contains(tests[index]));

        }
    }


    /**
     * Tests the method add
     *
     * @param aBag
     * @param content
     */
    public static void testAdd(BagInterface<String> aBag, String[] content) {
        System.out.print("Adding the following strings to the bag:");
        for (int index = 0; index < content.length; index++) {
            if (aBag.add(content[index])) {
                System.out.print(content[index] + "");
            } else {
                System.out.print("\nUnable to add " + content[index] +
                        "to the bag.");
            }
            System.out.println();
        }
        displayBag(aBag);
    }


    private static void displayBag(BagInterface<String> aBag) {
        System.out.println("The bag contains the following stirng(s):");
        Object[] bagArray = aBag.toArray();
        for (int index = 0; index < bagArray.length; index++) {
            System.out.print(bagArray[index] + " ");

        }
        System.out.println();
    }
}
