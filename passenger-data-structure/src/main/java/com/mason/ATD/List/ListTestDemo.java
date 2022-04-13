package com.mason.ATD.List;

/**
 * 线性表的测试类
 *
 * @author ShiYong
 * @create 2022-04-13 15:34
 **/
public class ListTestDemo {
    public static void main(String[] args) {
        System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,居于数组实现的线性表,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
        //默认初始化
        AList<String> arrayList = new AList<>();
        //  ListInterface<String> arrayList02 = new AList<>(30);
        //ListInterface<String> arrayList03 = new AList<>(20);
        arrayList.add("白云区");
        //测试扩容技术
        for (int index = 0; index < 3; index++) {
            arrayList.add("广州市");
        }
        arrayList.add("天河区");
        //3.指定位置添加元素
        arrayList.add(2,"北京市");
        arrayList.add(6,"上海");
        arrayList.add(7,"天津");
        //显示所有的元素
        arrayList.displayList(arrayList);
        //arrayList.clear();
        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList.getLength());
        //测试删除:删除最末尾数组的元素
        System.out.println(arrayList.remove(8));
        //删除测试：删除第一个元素：
        System.out.println(arrayList.remove(1));
        arrayList.displayList(arrayList);
        //删除测试：指定中间的位置
        System.out.println(arrayList.remove(2));
        arrayList.displayList(arrayList);

        //测试获取方法:
        System.out.println(arrayList.getEntry(2));
        System.out.println(arrayList.replace(2, "武汉市"));
        //测试是否包含元素
        System.out.println(arrayList.contain("武汉市"));

        //arrayList.remove(2);

//        ListInterface<Integer> list = new AList<>();
//        list.add(new Integer(1));
//        list.add(new Integer(2));
//        list.add(new Integer(3));
//        list.add(new Integer(4));

//        Integer[] strings = list.toArray();
//        for (int index = 1; index < strings.length; index++) {
//            System.out.println(strings[index]);;
//        }


    }
}
