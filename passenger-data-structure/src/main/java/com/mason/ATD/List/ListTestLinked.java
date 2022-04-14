package com.mason.ATD.List;

/**
 * 测试链表的实现
 *
 * @author ShiYong
 * @create 2022-04-14 10:56
 **/
public class ListTestLinked {
    public static void main(String[] args) {
        System.out.println("Create an empty list: ");
        ListInterface<String> linkedList = new LList<>();
        System.out.println("List should be empty: isEmpty returns " + linkedList.isEmpty() + ".");
        System.out.println("\nTesting add to end: ");
        //测试1：空链表和尾部添加
        linkedList.add("天河");
        linkedList.add("白云");
        linkedList.add("番禺");
        linkedList.add("海珠");
        System.out.println("List should contain 天河 白云 番禺 海珠");
        displayList(linkedList);
        //测试指定位置插入元素
        linkedList.add(2, "荔湾");
        System.out.println("List should contain 天河 荔湾 白云 番禺 海珠");
        displayList(linkedList);
        //测试获取链表结点个数
        System.out.println("链表的结点个数为：" + linkedList.getLength());
        //测试：指定位置的数据替换
        System.out.println("指定位置替换元素 " + linkedList.replace(2, "越秀"));
        displayList(linkedList);
        //测试根据下标获取指定位置元素
        System.out.println("获取指定位置的元素 " + linkedList.getEntry(5));
        //链表是否包含某个元素
        System.out.println("测试线性表是否包含某个元素：" + linkedList.contain("天河"));

        //测试删除：删除头结点
        System.out.println("删除的头结点成功：" + linkedList.remove(1));
        displayList(linkedList);
        //测试删除：尾结点
        System.out.println("测试删除尾结点： " + linkedList.remove(4));
        displayList(linkedList);

        //测试删除：中间结点
        System.out.println("测试删除中间结点: " + linkedList.remove(2));
        displayList(linkedList);

        System.out.println("List should not be empty; isEmpty() returns " + linkedList.isEmpty() + ".");
        System.out.println("\nTesting clear():");
        linkedList.clear();
        boolean empty = linkedList.isEmpty();
        System.out.println("List should be empty:isEmpty returns " + linkedList.isEmpty() + ".");


    }


    /**
     * 显示所有线性表的项
     *
     * @param list
     */
    public static void displayList(ListInterface<String> list) {
        System.out.println("The list contains " + list.getLength() +
                " entries, as follows:");
        Object[] listLinked = list.toArray();
        for (int index = 0; index < listLinked.length; index++) {
            System.out.print(listLinked[index] + " ");
        } // end for
        System.out.println();
    } // end d
}
