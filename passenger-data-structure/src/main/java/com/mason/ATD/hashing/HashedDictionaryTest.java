package com.mason.ATD.hashing;

import java.util.Iterator;

/**
 * @author Mason
 * @Description TODO
 * @date 2022/4/26 15:48
 */
public class HashedDictionaryTest {
    public static void main(String[] args) {
        DictionaryInterface<String, String> hashDic = new HashedDictionary<>();
        hashDic.add("Json", "boy");
        hashDic.add("Mason", "boy");
        hashDic.add("Merry", "girl");
        //测试getValue()方法
        System.out.println(hashDic.getValue("Merry"));
        //测试删除方法
        //  hashDic.remove("Mason");
        //  hashDic.getValue("Mason");
        //测试迭代方法
        Iterator<String> keyIterator = hashDic.getKeyIterator();
        Iterator<String> valueIterator = hashDic.getValueIterator();
        while (keyIterator.hasNext()) {
            System.out.println(keyIterator.next()+"," + valueIterator.next());
        }


    }
}
