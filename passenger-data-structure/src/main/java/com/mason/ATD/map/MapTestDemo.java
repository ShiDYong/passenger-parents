package com.mason.ATD.map;

import java.util.Iterator;

/**
 * @author Mason
 * @Description 字典的测试类
 * @date 2022/4/24 14:09
 */
public class MapTestDemo {
    public static void main(String[] args) {
        System.out.println("<<<<<<<<<<<<<<<<<<<测试无序数组实现的字典》》》》》》》》》》》》》》》》》》》");
        DictionaryInterface<String, String> mapArray = new ArrayDictionary<>();
        //测试添加操作
        mapArray.add("mason", "boy");
        mapArray.add("Merry", "girl");
        // mapArray.add(null,"boy");
        mapArray.add("Tina", "girl");
        // mapArray.add("Merry",null);
        mapArray.add("Merry", "woman");
        mapArray.add("Gson", "Java");
        //测试getValue()
        System.out.println(mapArray.getValue("Tina"));
        System.out.println(mapArray.getValue("Mason"));
        System.out.println(mapArray.contains("Tina"));
        //测试遍历获取Key和value
        Iterator<String> keyIterator = mapArray.getKeyIterator();
        Iterator<String> valueIterator2 = mapArray.getValueIterator();
        while (keyIterator.hasNext())
            System.out.println(keyIterator.next()+"," + valueIterator2.next());
        //   keyIterator.remove();


        ////Iterator<String> ValueIterator = mapArray.getValueIterator();
        //System.out.println("测试遍历获取value "+ValueIterator.hasNext());
        //System.out.println("测试获取遍历value "+ValueIterator.next());
        //ValueIterator.remove();

        System.out.println("<<<<<<<<<<<<<<<<<<测试数组实现的有序的字典>>>>>>>>>>>>>>>>>>>>>");
        DictionaryInterface<Integer, String> orderDit = new SortedArrayDictionary<>();
        orderDit.add(4, "hello");
        orderDit.add(3, "Java");
        orderDit.add(2, "C/C++");
        orderDit.add(1, "Python");
        Iterator<Integer> keyIterator2 = orderDit.getKeyIterator();
        Iterator<String> valueIterator1 = orderDit.getValueIterator();
        while (keyIterator2.hasNext())
            System.out.println(keyIterator2.next() + ","+ valueIterator1.next());
//
//        System.out.println(orderDit.remove(2));
//        Iterator<Integer> keyIterator1 = orderDit.getKeyIterator();
//        while (keyIterator1.hasNext()){
//            System.out.println(keyIterator1.next());
//        }
        System.out.println("《《《《《《《《《《《《《《《《测试有序链表实现的字典》》》》》》》》》》》》");
        DictionaryInterface<String, String> linkedMap = new SortedLinkedDictionary<>();
        linkedMap.add("c","Apple");
        linkedMap.add("a","Amazon");
        linkedMap.add("b","Micsoft");
        linkedMap.add("d","Google");
        Iterator<String> keyIterator1 = linkedMap.getKeyIterator();
        Iterator<String> valueIterator = linkedMap.getValueIterator();
        //循环按键-值对对形式显示字典中对每一页
        while (keyIterator1.hasNext())
            System.out.println(keyIterator1.next()+"," + valueIterator.next());


        // System.out.println(linkedMap.remove(1));

        //测试删除的项
        // System.out.println(mapArray.remove("Tina"));
        //System.out.println(mapArray.remove(null));
        //System.out.println(mapArray.remove("Mason"));
    }
}
