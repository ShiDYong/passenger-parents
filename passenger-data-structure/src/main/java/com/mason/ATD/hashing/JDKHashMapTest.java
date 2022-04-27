package com.mason.ATD.hashing;

import java.util.HashMap;

/**
 * @author Mason
 * @Description 练习和熟悉JDK中HashMap的用法
 * @date 2022/4/26 17:34
 */
public class JDKHashMapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Tom", 100);
        map.put("Tom",200);
        map.put(null,200);
        map.put(null,null);
        System.out.println("Tom的分数是：" + map.get(null));

    }
}
