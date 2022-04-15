package com.mason.ATD.iterator;

import com.mason.ATD.List.ListInterface;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * 链表组合实现的迭代器的测试类
 *
 * @author ShiYong
 * @create 2022-04-15 9:07
 **/
public class LinkedIteratorTest {
    public static void main(String[] args) {
//        LinkedListWithIterator<String> myList = new LinkedListWithIterator<>();
//        Iterator<String> bookIterator = myList.getIterator();
//        myList.add("三国演义");
//        myList.add("水浒传");
//        myList.add("西游记");
//        myList.add("红楼梦");
//        displayListQ5(myList);
//
//        System.out.println("hasnext()   " + bookIterator.hasNext());
//        System.out.println("next()    " + bookIterator.next());
//        bookIterator.remove();
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>测试ArrayListWithIterator>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        ListWithIteratorInterface<String> arrayList = new ArrayListWithIterator<>();
//        Iterator<String> iterator = arrayList.getIterator();
//        arrayList.add("三国演义");
//        arrayList.add("红楼梦");
//        arrayList.add("水浒传");
//        arrayList.add("西游记");
//        displayListQ5(arrayList);
//        System.out.println("hasnext()   " + iterator.hasNext());
//        System.out.println("next()   " + iterator.next());
//        for (int index = 0; index < arrayList.getLength(); index++) {
//            iterator.hasNext();
//            iterator.next();
//            iterator.remove();
//        }
//        displayListQ5(arrayList);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>测试ArrayListWithLisIterator<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        ArrayListWithLisIteratInterface<String> myList = new ArrayListWithLisIterator<>();
        ListIterator listIterator = myList.getIterator();
        listIterator.add("美国");
        listIterator.add("英国");
        listIterator.add("法国");
        listIterator.add("德国");
        listIterator.add("日本");

        System.out.println("hasnext()   " + listIterator.hasNext());
        System.out.println("hasnext()   " + listIterator.next());
        listIterator.remove();
        displayListQ5(myList);
        System.out.println("hasnext()   " + listIterator.hasPrevious());
        System.out.println("hasnext()   " + listIterator.previous());
        System.out.println("hasnext()   " + listIterator.previousIndex());



    }

    public static void displayListQ5(ArrayListWithLisIteratInterface<String> list) {
        int numberOfEntries = list.getLength();
        System.out.println("The list contains " + numberOfEntries +
                " entries, as follows:");
        Iterator<String> traverser = list.getIterator(); // Or list.iterator()
        int position = 0;
        while (traverser.hasNext()) {
            position++;
            System.out.println(traverser.next() + " is entry " + position);
        } // end while
        System.out.println();
    } // en

}
