package com.mason.ATD.tree.AVL;

import javax.swing.plaf.metal.MetalCheckBoxIcon;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author Mason
 * @Description A class that implements the ATD AVl
 * tree by extending BinarySearchTree.
 * @date 2022/5/3 15:15
 */
public class AVLTree<T extends Comparable<? super T>> extends BinarySearchTree<T> implements SearchTreeInterface<T> {
    public AVLTree() {
        super();
    }



    public AVLTree(T rootEntry) {
        super(rootEntry);
    }

    /**
     * Adds a new entry to this tree, if it does not match an existing
     * object in the tree. Otherwise, replaces the existing object with
     * the new entry.
     *
     * @param newEntry An object to be added to the tree.
     * @return Either null if anEntry was not in the tree but has been added, or
     * the existing entry that matched the parameter anEntry
     * and has been replaced in the tree.
     */
    @Override
    public T add(T newEntry) {

        T result = null;
        if (isEmpty())
            setRootNode(new BinaryNode<>(newEntry));

        else {
            BinaryNode<T> rootNode = getRootNode();
            result = addEntry(rootNode, newEntry);
            setRootNode(rebalance(rootNode));
        }
        return result;
    }

    private T addEntry(BinaryNode<T> rootNode, T newEntry) {
        assert rootNode != null;
        T result = null;
        int comparison = newEntry.compareTo(rootNode.getData());
        if (comparison == 0) {
            result = rootNode.getData();
            rootNode.setData(newEntry);
        } else if (comparison < 0) {
            if (rootNode.hasLeafChild()) {
                BinaryNode<T> leftChild = rootNode.getLeftChild();
                result = addEntry(leftChild, newEntry);
                rootNode.setLeftChild(rebalance(leftChild));
            } else
                rootNode.setLeftChild(new BinaryNode<>(newEntry));

        } else {
            assert comparison > 0;
            if (rootNode.hasRightChild()) {
                BinaryNode<T> rightChild = rootNode.getRightChild();
                result = addEntry(rightChild, newEntry);
                rootNode.setRightChild(rebalance(rightChild));
            } else
                rootNode.setRightChild(new BinaryNode<>(newEntry));
        }
        return result;
    }

    private BinaryNode<T> rebalance(BinaryNode<T> nodeN) {
        int heightDifference = getHeightDifference(nodeN);
        //判断是左子树还是右子树高，高度多少,如果结点N的两棵树的高度相等或只差1则不需要再平衡。
        if (heightDifference > 1) {
            //Left subtree is taller by more than 1
            // so addition was left subtree
            if (getHeightDifference(nodeN.getLeftChild()) > 0)
                rotateRight(nodeN);// Addition was in left's left
            else
                //Addition was in right subtree of left tree
                rotateLeftRight(nodeN);

        } else if (heightDifference < -1) {
            //Right subtree is taller by more than 1
            // so Addition was in right subtree
            if (getHeightDifference(nodeN.getRightChild()) < 0)
                //Addition was iin right subtree of right child
                nodeN = rotateLeft(nodeN);
            else
                //Addition was in left subtree of right child
                nodeN = rotateRightLeft(nodeN);
        }
        return nodeN;

    }

    private int getHeightDifference(BinaryNode<T> nodeN) {
        BinaryNode<T> nodeNLeft = nodeN.getLeftChild();
        BinaryNode<T> nodeNRight = nodeN.getRightChild();
        return (nodeNLeft.getHeight() - nodeNRight.getHeight());
    }

    // Corrects an imbalance at the node closest to a structural change in the
    // right subtree of the node's right child.
    // nodeN is a node, closest to the newly added leaf, at which an imbalance
    // occurs and that has a right child.
    private BinaryNode<T> rotateRight(BinaryNode<T> nodeN){
        //nodeC = nodeN的左孩子
        BinaryNode<T> nodeC = nodeN.getRightChild();
        //将nodeC的右孩子赋给nodeN的左孩子
        nodeN.setRightChild(nodeC.getLeftChild());
        //将nodeN赋给nodeC的右孩子
        nodeC.setRightChild(nodeN);
        return nodeC;
    }

    private BinaryNode<T> rotateLeft(BinaryNode<T> nodeN){
        //nodeC= nodeN的右孩子
        BinaryNode<T> nodeC = nodeN.getRightChild();
        //将nodeC的左孩子赋给nodeN的右孩子
        nodeN.setRightChild(nodeC.getLeftChild());
        //将nodeN赋给nodeC的左孩子
        nodeC.setLeftChild(nodeN);
        return nodeC;
    }

    // Corrects an imbalance at the node closest to a structural
    // change in the left subtree of the node's right child.
    // nodeN is a node, closest to the newly added leaf, at which
    // an imbalance occurs and that has a right child.
    private BinaryNode<T> rotateRightLeft(BinaryNode<T> nodeN){
        BinaryNode<T> nodeC = nodeN.getRightChild();
        nodeN.setRightChild(rotateRight(nodeC));
        return rotateLeft(nodeN);
    }

    // Corrects an imbalance at the node closest to a structural
    // change in the right subtree of the node's left child.
    // nodeN is a node, closest to the newly added leaf, at which
    // an imbalance occurs and that has a left child.
    private BinaryNode<T> rotateLeftRight(BinaryNode<T> nodeN){
        BinaryNode<T> nodeC = nodeN.getLeftChild();
        nodeN.setLeftChild(rotateLeft(nodeC));
        return rotateRight(nodeN);
    }

}
