package com.mason.ATD.tree.treePackage;

import java.util.Iterator;

/**
 * @author Mason
 * @Description 二叉树的测试类
 * @date 2022/4/27 15:52
 */
public class BinaryTreeTest {
    public static void main(String[] args) {//      BinaryTreeInterface<BinaryNode> binaryTree = new BinaryTree<>();
//        BinaryNode root = new BinaryNode("a");
//        BinaryNode node2 = new BinaryNode("b");
//        BinaryNode node3= new BinaryNode("c");
//        BinaryNode node4= new BinaryNode("d");
//        BinaryNode node5 = new BinaryNode("e");
//        BinaryNode node6 = new BinaryNode("f");
//        BinaryNode node7 = new BinaryNode("g");
//        //设置二叉树的树根结点
//        binaryTree.setRootData(root);
//        binaryTree.setTree(root,node2,node3);
//        //手动创建二叉树
//        root.setLeftChild(node2);
//        root.setLeftChild(node4);
//        root.setLeftChild(node5);
//        root.setRightChild(node3);
//        root.setRightChild(node6);
//        root.setRightChild(node7);
        /**
         * 要构造二叉树，先将每个叶结点表示为以一颗单结点树。注意到树中的每个结点
         * 都保存一个单字符的字符串。从叶结点开始向上。使用setTree建立越来越大的子树
         * 直到得到整棵树
         */
        //将每个叶子结点作为一个单结点树
        BinaryTreeInterface<String> dTree = new BinaryTree<>();
        dTree.setTree("D", null, null);
        BinaryTreeInterface<String> fTree = new BinaryTree<>();
        fTree.setTree("F", null, null);
        BinaryTreeInterface<String> hTree = new BinaryTree<>();
        hTree.setTree("H", null, null);
        BinaryTreeInterface<String> gTree = new BinaryTree<>();
        gTree.setTree("G", null, null);

        BinaryTreeInterface<String> emptyTree = new BinaryTree<>();
        //Form large subtrees
        BinaryTreeInterface<String> eTree = new BinaryTree<>();
        eTree.setTree("E", fTree, gTree);

        BinaryTreeInterface<String> bTree = new BinaryTree<>();
        bTree.setTree("B", dTree, eTree);

        BinaryTreeInterface<String> cTree = new BinaryTree<>();
        cTree.setTree("C", emptyTree, hTree);

        BinaryTreeInterface<String> aTree = new BinaryTree<>();
        aTree.setTree("A", bTree, cTree);

        //获取root,高度 和结点数量测试
        System.out.println("根结点包含的数据是：" + aTree.getRootData());
        System.out.println("树的高度是： " + aTree.getHeight());
        System.out.println("树的结点数是： " + aTree.getNumberOfNodes());

        //Display nodes in preorder
        System.out.println("A preorder traversal visits nodes in this order: ");
        Iterator<String> preorder = aTree.getPreorderIterator();
        while (preorder.hasNext())
            System.out.print(preorder.next() + " ");
        System.out.println();
        System.out.println("该二叉树的中序遍历结果： ");
        Iterator<String> inorder = aTree.getInorderIterator();
        while (inorder.hasNext())
            System.out.print(inorder.next() + " ");
        System.out.println();
//
        System.out.println("该二叉树的后序遍历结果： ");
        Iterator<String> postorder = aTree.getPostorderIterator();
        while (postorder.hasNext())
            System.out.print(postorder.next() + " ");
        System.out.println();

        System.out.println("该二叉树的层序遍历结果： ");
        Iterator<String> levelOrder = aTree.getLevelOrderIterator();
        while (levelOrder.hasNext())
            System.out.print(levelOrder.next() + " ");
        System.out.println();


//        System.out.println("前序遍历：");
//        Iterator<BinaryNode> postorderIterator = binaryTree.getPostorderIterator();
//        while (postorderIterator.hasNext())
//            System.out.println(postorderIterator.next());
    }
}
