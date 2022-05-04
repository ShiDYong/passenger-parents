package com.mason.ATD.tree.AVL;

import java.util.Iterator;

/**
 * @author Mason
 * @Description TODO
 * @date 2022/5/1 14:32
 */
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        //SearchTreeInterface<String> searchTree = new BinarySearchTree<>();
        //以上是通过递归方法进行添加操作的，下面是通过迭代实现的方法
        BinarySearchTree<String> searchTree = new BinarySearchTree<>();
        System.out.println("二叉查找树的常用方法的测试");
        //测试添加操作
        searchTree.add("Kathy");
        searchTree.add("Brittany");
        searchTree.add("Brett");
        searchTree.add("Doug");
        searchTree.add("Megan");
        searchTree.add("Lance");
        searchTree.add("Whitney");
        searchTree.add("Maria");
        searchTree.add("Derek");
        searchTree.add("Dan");
        searchTree.add("Dirk");
        searchTree.add("Sean");
        searchTree.add("Pat");
        searchTree.add("Reba");
        searchTree.add("Zak");
        searchTree.add("Chad");
        //测试获取操作
        System.out.println("获取树中存在的元素：" + searchTree.getEntry("Zak"));
        System.out.println("获取树中不存在的元素：" + searchTree.getEntry("jim"));
        System.out.println("获取树的高度：" + searchTree.getHeight());
        System.out.println("获取树的结点树量：" + searchTree.getNumberOfNodes());
        System.out.println(searchTree.contains("Doug"));
        //测试二叉查找树的删除操作
        //3.删除根结点的项
        searchTree.remove("Megan");
        //1.删除带有两个结点的项
        searchTree.remove("Chad");
        searchTree.remove("Sean");
        //2.删除最多有一个孩子的结点
        searchTree.remove("Maria");
        //3.删除叶子结点
        searchTree.remove("Zak");



        Iterator<String> inorderIterator = searchTree.getInorderIterator();
        while (inorderIterator.hasNext())
            System.out.print(inorderIterator.next() + " ");

    }
}
