package com.mason.ATD.tree.treePackage;

/**
 * @author Mason
 * @Description 树结点的定义类并没有设置为为二叉树的内部类，因为派生于基础二叉树类的任何类
 * 都可能需要对结点进行操作，所以将树结点的类定义在二叉树类外。但是没有设置成为公共有类
 * 而是在包含不同的树类和它们的接口的包内，给它包的访问权限。这样结点的实现细节依然对树
 * 的客户隐藏。
 * @date 2022/4/27 14:04
 */
class BinaryNode<T> {
    private T data;
    private BinaryNode<T> leftChild;
    private BinaryNode<T> rightChild;

    public BinaryNode() {
        this(null);

    }

    public BinaryNode(T data) {
        this(data, null, null);
    }

    public BinaryNode(T data, BinaryNode<T> newLeftChild, BinaryNode<T> newRightChild) {
        this.data = data;
        this.leftChild = newLeftChild;
        this.rightChild = newRightChild;
    }

    /**
     * Retrieves the data portion of this node
     *
     * @return The object in the data portion of the node.
     */
    public T getData() {
        return data;
    }

    /**
     * Set the data portion of this node
     *
     * @param data the data object.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Retrieves teh left child of this node.
     *
     * @return
     */
    public BinaryNode<T> getLeftChild() {
        return leftChild;
    }

    /**
     * Sets this node's left child to given node.
     *
     * @param leftChild A  node that will be the left child.
     */
    public void setLeftChild(BinaryNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * Detects whether this node is a leaf.
     *
     * @return True if the node is a leaf.
     */
    public boolean isLeaf() {
        return (leftChild == null) && (rightChild == null);
    }


    /**
     * Detects whether this node has a left child
     *
     * @return True if the node has a left node.
     */
    public boolean hasLeafChild() {
        return leftChild != null;
    }

    public BinaryNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public boolean hasRightChild() {
        return rightChild != null;
    }

    /**
     * Counts the nodes in the subtree rooted at this node.
     *
     * @return The number of nodes in the subtree rooted at this node.
     */
    public int getNumberOfNodes() {
        int leftNumber = 0;
        int rightNumber = 0;
        if (leftChild != null)
            leftNumber = leftChild.getNumberOfNodes();
        if (rightChild != null)
            rightNumber = rightChild.getNumberOfNodes();
        return 1 + leftNumber + rightNumber;
    }


    /**
     * Computes the height of the subtree rooted at this node.
     *
     * @return The number of nodes in the subtree rooted at this node.
     */
    public int getHeight() {
        return getHeight(this);

    }

    //以一个结点作为根的树的高度，等于1--结点本身--再加上结点最高子树的高度
    private int getHeight(BinaryNode<T> node) {
        int height = 0;
        if (node != null)
            height = 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
        return height;

    }

    /**
     * Copies the subtree rooted at this node.
     * 拷贝左子树和右子树的结点，不拷贝数据
     *
     * @return
     */
    public BinaryNode<T> copy() {
        BinaryNode<T> newRoot = new BinaryNode<>(data);
        if (leftChild != null)
            newRoot.setLeftChild(leftChild.copy());//执行子树的前序遍历
        if (rightChild != null)
            newRoot.setRightChild(rightChild.copy());
        return newRoot;
    }
}
