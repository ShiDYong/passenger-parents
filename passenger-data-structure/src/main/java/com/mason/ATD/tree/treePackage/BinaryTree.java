package com.mason.ATD.tree.treePackage;

import com.mason.ATD.chapter01.BagInterface;

import java.util.Iterator;

/**
 * @author Mason
 * @Description A class that implements the ATD binary tree.
 * @date 2022/4/27 14:49
 */
public class BinaryTree<T> implements BinaryTreeInterface<T> {
    private BinaryNode<T> root;


    public BinaryTree() {
        root = null;
    }

    public BinaryTree(T rootData) {
        root = new BinaryNode<>(rootData);
    }

    public BinaryTree(T root, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
        initializeTree(root, leftTree, rightTree);
    }

    @Override
    public void setRootData(T rootData) {
        root.setData(rootData);

    }

    private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
        root = new BinaryNode<>(rootData);
        //if ((leftTree != null) && !leftTree.isEmpty())
        //    root.setLeftChild(leftTree.root.copy());
        // if ((rightTree !=null) &&!rightTree.isEmpty())
        //     root.setRightChild(rightTree.root.copy());
        //以上使用拷贝的方法，会消耗比较多的内存
        //以下是第二种方法
        if ((leftTree != null) && !(leftTree.isEmpty()))
            root.setLeftChild(leftTree.root);
        if ((rightTree != null) && !(rightTree.isEmpty())) {
            if (rightTree != leftTree)
                root.setRightChild(rightTree.root);
            else
                root.setRightChild(rightTree.root);
        }
        if ((leftTree != null) && (leftTree != this))
            leftTree.clear();
        if ((rightTree != null) && (rightTree != this))
            rightTree.clear();

    }

    @Override
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
        initializeTree(rootData, (BinaryTree<T>) leftTree, (BinaryTree<T>) rightTree);
    }

    @Override
    public T getRootData() {
        if (isEmpty())
            throw new EmptyTreeException();
        else
            return root.getData();
    }

    @Override
    public int getHeight() {
        int height = 0;
        if (root != null)
            height = root.getHeight(); //调用BinaryNode类中的方法
        return height;
    }

    @Override
    public int getNumberOfNodes() {
        int numberOfNodes = 0;
        if (root != null)
            numberOfNodes = root.getNumberOfNodes();
        return numberOfNodes;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        root = null;
    }

    protected void setRootNode(BinaryNode<T> rootNode) {
        root = rootNode;
    }

    protected BinaryNode<T> getRootNode() {
        return root;
    }

    @Override
    public Iterator<T> getPreorderIterator() {
        return null;
    }

    @Override
    public Iterator<T> getPostorderIterator() {
        return null;
    }

    @Override
    public Iterator<T> getInorderIterator() {
        return null;
    }

    @Override
    public Iterator<T> getLevelOrderIterator() {
        return null;
    }
}
