package com.mason.ATD.tree.AVL;

import java.util.Iterator;

/**
 * @author Mason
 * @Description 二叉查找树实现的字典的测试
 * @date 2022/5/1 19:20
 */
public class BstDictionaryTest {
    public static void main(String[] args) {
        DictionaryInterface<String,String> dic= new BstDictionary<>();
        dic.add("Jim","13100317878");
        dic.add("Jared","18898980101");
        dic.add("Bret","17789890909");
        dic.add("Doug","010-87887");
        dic.add("Brittany","012-356765");
        dic.add("Megan","012-123456");
        dic.add("Whitney","012-234789");
        System.out.println("size的长度："+dic.getSize());
        dic.remove("Megan");

        Iterator<String> keyIterator = dic.getKeyIterator();
        Iterator<String> valueIterator = dic.getValueIterator();
        while (keyIterator.hasNext())
            System.out.println(keyIterator.next()+":"+valueIterator.next());
    }

}
