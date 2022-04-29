package com.mason.ATD.tree.treePackage;

/**
 * @author Mason
 * @Description 树结点的定义类并没有设置为为二叉树的内部类，因为派生于基础二叉树类的任何类
 * 都可能需要对结点进行操作，所以将树结点的类定义在二叉树类外。但是没有设置成为公共有类
 * 而是在包含不同的树类和它们的接口的包内，给它包的访问权限。这样结点的实现细节依然对树
 * 的客户隐藏。
 * @date 2022/4/27 14:04
 */
class BinaryNode02<T extends Copyable> implements Cloneable {
    private T data;
    private BinaryNode02<T> leftChild;
    private BinaryNode02<T> rightChild;

    public BinaryNode02() {
        this(null);

    }

    public BinaryNode02(T data) {
        this(data, null, null);
    }

    public BinaryNode02(T data, BinaryNode02<T> newLeftChild, BinaryNode02<T> newRightChild) {
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
    public BinaryNode02<T> getLeftChild() {
        return leftChild;
    }

    /**
     * Sets this node's left child to given node.
     *
     * @param leftChild A  node that will be the left child.
     */
    public void setLeftChild(BinaryNode02<T> leftChild) {
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

    public BinaryNode02<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryNode02<T> rightChild) {
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
    private int getHeight(BinaryNode02<T> node) {
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
    public BinaryNode02<T> copy() {
        BinaryNode02<T> newRoot = new BinaryNode02<>(data);
        if (leftChild != null)
            newRoot.setLeftChild(leftChild.copy());//执行子树的前序遍历
        if (rightChild != null)
            newRoot.setRightChild(rightChild.copy());
        return newRoot;
    }

    @Override
    public Object clone() {

        BinaryNode02<T> theCopy = null;

        try {
            @SuppressWarnings("unchecked")
            BinaryNode02<T> temp = (BinaryNode02<T>) super.clone();
            theCopy = temp;
        } catch (CloneNotSupportedException e) {
            throw new Error("BinaryNode cannot clone: " + e.toString());
        }
        // Clone the data
        theCopy.data = (T) data.clone();
        // Clone the node's two children
        if (leftChild != null)
            theCopy.leftChild = (BinaryNode02<T>) leftChild.clone();
        if (rightChild != null)
            theCopy.rightChild = (BinaryNode02<T>) rightChild.clone();

        return theCopy;
    }
}
