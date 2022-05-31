package com.mason.ATD.searching;

import java.sql.Struct;

/**
 * @author Mason
 * @Description 链表中的查找案例
 * @date 2022/4/23 21:43
 */
public class SearchingLinkedDemo {

    /**
     * 迭代方式实现的顺序查找方法
     */
//    public boolean contain(T anEntry) {
//        boolean found = false;
//        Node currentNode = firstNode;
//        while (!found && (currentNode != null)){
//            if (anEntry.equals(currentNode.getData()))
//                foudn = true;
//            else
//                currentNode = currentNode.getNextNode();
//        }
//        return found;
//    }

    //无序链表中的递归顺序查找
//    public boolean contains(T anEntry) {
//        return search(firstNode, anEntry);
//    }

    //私有递归方法
//    private boolean search(Node currentNode, T desiredItem) {
//        boolean found;
//        if (currentNode == null)
//            found = false;
//        else if (desiredItem.equals(currentNode.getData()))
//            found = true;
//        else
//            found = search(currentNode.getNextNode(), desiredItem);
//        return found;
//    }
    /**
     * 结点链表中的顺序查找的时间效率
     * 最优情况：O(1)
     * 最差情况：O(n)
     * 平均情况：O(n)
     */

    ////////////////////////////有序链表中的顺序查找/////////////////////////////
    //有序链表中的顺序查找
//    public boolean contain(T anEntry){
//        Node currentNode = firstNode;
//        while (currentNode != null &&(anEntry.compareTo(currentNode.getData())>0))
//            currentNode = currentNode.getNextNode();
//        return ((currentNode!=null) && (anEntry.equals(currentNode.getData())));
//    }

    /***
     * 有序链表中的二分查找：一般情况下，必须从第一个结点开始遍历链表，直到中间结点时
     * 为止。你如何直到合适到达哪里？结点链表中的二分查找比顺序查找更难实现而且效率更低。
     * 所以：结点链表中的二分查找是不现实的。
     *
     * 查找方法的选择：
     *              1.数据结构是结点链表用顺序查找；
     *              2。数据结构是对象数组。对象有equals方法，用它来确定两个对象在某种意义上是否相等。因为所有对象都从Object类
     *              继承类equals方法，所以你必须保证要查找的对象与重写的合适的equals版本；
     *              3。对象数组执行二分查找，对象必须有comparaeTo()方法，且数组必须是有序的。如果这些条件不满足，则必须
     *              使用顺序查找；
     *              4。一般数组很小的话用顺序查好啊。数组很大的话用二分查找要快很多
     *              5。选择迭代查找还是选择递归查找。递归查找是为递归。所以使用迭代查找时可以节省一些时间和空间。
     *              二分查找很快，所以递归实现时不需要很多额外的递归调用空间。另外，编写递归实现的二分查找的代码比编写实现
     *              迭代实现的代码更容易些。
     */
}
