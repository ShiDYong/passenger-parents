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
        mapArray.add("mason","boy");
        mapArray.add("Merry","girl");
       // mapArray.add(null,"boy");
        mapArray.add("Tina","girl");
       // mapArray.add("Merry",null);
        mapArray.add("Merry","woman");
        mapArray.add("Gson","Java");
        //测试getValue()
        System.out.println(mapArray.getValue("Tina"));
        System.out.println(mapArray.getValue("Mason"));
        System.out.println(mapArray.contains("Tina"));
        //测试遍历获取Key和value
        Iterator<String> keyIterator = mapArray.getKeyIterator();
        System.out.println("测试遍历获取key "+keyIterator.hasNext());
        System.out.println("测试获取遍历的值"+keyIterator.next());
     //   keyIterator.remove();


        Iterator<String> ValueIterator = mapArray.getValueIterator();
        System.out.println("测试遍历获取value "+ValueIterator.hasNext());
        System.out.println("测试获取遍历value "+ValueIterator.next());
        ValueIterator.remove();

        //测试删除的项
       // System.out.println(mapArray.remove("Tina"));
        //System.out.println(mapArray.remove(null));
        //System.out.println(mapArray.remove("Mason"));
    }
}
