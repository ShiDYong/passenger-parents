package com.mason.ATD.tree.AVL;

/**
 * @author Mason
 * @Description TODO
 * @date 2022/5/3 16:07
 */
public class AVLTreeTest {
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.add(70);
        avlTree.add(80);
        avlTree.add(90);
        avlTree.add(20);
        avlTree.add(10);
        avlTree.add(50);
        avlTree.add(60);
        avlTree.add(40);
        avlTree.add(30);
    }
}
