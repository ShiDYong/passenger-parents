package com.mason.ATD.tree.treePackage;

/**
 * @author Mason
 * @Description 因为二叉树有不同的类。如表达式树和决策树，每个都具有二叉树基本操作
 *              之外的一些操作。我们将二叉树类定义像表达式树类这样的类父类。
 *              Java中类是不可以多继承，但是接口可以是多继承
 * @date 2022/4/27 14:42
 */
public interface BinaryTreeInterface<T> extends TreeInterface<T>,TreeIteratorInterface<T> {
    public void setRootData(T rootData);
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,BinaryTreeInterface<T> rightTree);
}
