package com.mason.ATD.tree.AVL;

import com.mason.ATD.tree.binaryTree.BinaryTreeInterface;

/**
 * @author Mason
 * @Description 二叉查找树的实现
 * @date 2022/4/29 22:44
 */
public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T>
        implements SearchTreeInterface<T> {

    public BinarySearchTree() {
        super();
    }

    public BinarySearchTree(T rootEntry) {
        super();
        setRootNode(new BinaryNode<T>(rootEntry));
    }

    /**
     * 让setTree方法失效。因为继承来自BinaryTree类的方法，如果客户使用
     * SearchTreeInterface<String> dataSet = new BinarySearchTree<String>()创建的
     * dataSet就没有这个setTree方法，创建的不是一棵二叉查找树。相反，当客户使用的是下面的方式时
     * BinarySearchTree <String> dataSet = new BinarySearchTree<String>()创建的就可以
     * 使用setTree方法，因为它不在SearchTreeInterface中。为避免出现这种情况，我们选择重写
     */
    @Override
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
        throw new UnsupportedOperationException();  //如果被调用则抛出异常。
    }


    @Override
    public boolean contains(T anEntry) {
        //return getEntry(anEntry) == null ? false : true;
        //更简单的方式
        return getEntry(anEntry) != null;
    }

    @Override
    public T getEntry(T anEntry) {
        return findEntry(getRootNode(), anEntry);
        //通过迭代实现
       // return findEntry(anEntry);
    }

    //通过递归的方法实现
    private T findEntry(BinaryNode<T> rootNode, T anEntry) {
        T result = null;
        if (rootNode != null) {
            T rootEntry = rootNode.getData();
            if (rootEntry.equals(anEntry))
                result = rootEntry;
            else if (anEntry.compareTo(rootEntry) < 0)
                result = findEntry(rootNode.getLeftChild(), anEntry); //递归左子树
            else
                result = findEntry(rootNode.getRightChild(), anEntry); //递归右子树
        }
        return result;
    }

    //通过迭代的方法实现
    private T findEntry(T anEntry) {
        T result = null;
        boolean found = false;
        BinaryNode<T> currentNode = getRootNode();
        assert currentNode != null;
        while (!found) {
            T currentEntry = currentNode.getData();
            int comparison = currentEntry.compareTo(anEntry);
            if (comparison == 0) {
                found = true;
                result = currentEntry;

            } else if (comparison < 0) {
                while (currentNode.hasLeafChild()) {
                    currentNode = currentNode.getLeftChild();
                    currentEntry = currentNode.getData();
                    if (anEntry.equals(currentEntry)) {
                        found = true;
                        result = currentEntry;
                    }

                }


            } else {
                while (currentNode.hasRightChild()) {
                    currentNode = currentNode.getRightChild();
                    currentEntry = currentNode.getData();
                    if (anEntry.equals(currentEntry)) {
                        found = true;
                        result = currentEntry;
                    }
                }
            }
        }
        return result;
    }


    // 如果想让指向BinarySearchTree对象的引用能调用TreeIteratorInterface中的其他方法，该如何
    //声明这个引用呢？
    // 这种情况与段 26.6 中描述的 setTree 类 似。BinarySearchTree 从 BinaryTree 继承了
    //在 TreeIteratorInterface 中声明的方法。BinarySearchTree 的客户可以使用静态类
    //型是 BinarySearchTree 的对象来调用这些方法，但它不能使用静态类型是 SearchTreeInterface 的对象来调用


    //二叉查找树的每次添加都是增加了树的一个叶结点。
    @Override
    public T add(T newEntry) {
        T result = null;
        if (isEmpty())
            setRootNode(new BinaryNode<>(newEntry));  //插入时是空树
        else
            result = addEntry(getRootNode(),newEntry);

        return result;
    }

    //以下是通过递归实现的
    private T addEntry(BinaryNode<T> rootNode, T anEntry) {
        T result = null;
        int comparison = anEntry.compareTo(rootNode.getData());
        // 1.等于根结点中的项
        if (comparison == 0) {
            result = rootNode.getData();
            //替换掉根中的项
            rootNode.setData(anEntry);
        } else if (comparison < 0) {
            if (rootNode.hasLeafChild())
                result = addEntry(rootNode.getLeftChild(), anEntry);
            else
                rootNode.setLeftChild(new BinaryNode<>(anEntry));
        } else {
            if (rootNode.hasRightChild())
                result = addEntry(rootNode.getRightChild(), anEntry);
            else
                rootNode.setRightChild(new BinaryNode<>(anEntry));
        }
        return result;

    }

    //以下是通过迭代实现的:将新项添加到一棵非空的二叉查找树中
    private T addEntry02(T anEntry) {
        BinaryNode<T> currentNode = getRootNode();
        assert currentNode != null;
        T result = null;
        boolean found = false;
        while (!found) {
            T currentEntry = currentNode.getData();
            int comparison = anEntry.compareTo(currentEntry);
            if (comparison == 0) {
                found = true;
                result = currentEntry;
                currentNode.setData(anEntry);
            } else if (comparison < 0) {
                if (currentNode.hasLeafChild())
                    currentNode = currentNode.getLeftChild();
                else {
                    found = true;
                    currentNode.setLeftChild(new BinaryNode<>(anEntry));
                }
            } else {
                if (currentNode.hasRightChild())
                    currentNode = currentNode.getRightChild();
                else
                    currentNode.setRightChild(new BinaryNode<>(anEntry));
            }
        }
        return result;
    }


    //以下是通过迭代实现的
    //代码逻辑错误，暂时没有找到地方
    public T remove_loop(T anEntry) {
        T result = null;
        NodePair pair = findNode(anEntry);
        BinaryNode<T> currentNode = pair.getCurNode();
        BinaryNode<T> parentNode = pair.getParNode();
        if (currentNode != null) {
            result = currentNode.getData();
            //Case1: currentNode hast two children;
            if (currentNode.hasLeafChild() && currentNode.hasRightChild()) {
                //Replace entry in currentNode with the entry in another node
                //that has most one chile; that node can be deleted
                //Get node to remove(contains inorder predecessor; hast at
                // most one child) and its parent.
                pair = getNodeToRemove(currentNode);
                BinaryNode<T> nodeToRemove = pair.getCurNode();
                parentNode = pair.getParNode();
                //Copy entry from nodeToRemove to currentNode
                currentNode.setData(nodeToRemove.getData());
                currentNode = nodeToRemove;
                //Assertion: currentNode is the node to be removed;
                //it has at most one child
                //Assertion: Case1 has been transformed to Case.
            }
            //Case 2: currentNode has at most one child; delete it
            removeNode(currentNode, parentNode);
        }
        return result;
    }

    //实现找到N的左子树中的最右结点R
    //即就是结点两个孩子，则remove必须删除另一个最多有一个孩子的结点
    private NodePair getNodeToRemove(BinaryNode<T> currentNode) {
        BinaryNode<T> leftSubtreeRoot = currentNode.getLeftChild();
        BinaryNode<T> rightChild = leftSubtreeRoot;
        BinaryNode<T> priorNode = currentNode;
        while (rightChild.hasRightChild()) {
            priorNode = rightChild;
            rightChild = rightChild.getRightChild();
        }
        return new NodePair(rightChild, priorNode);
    }

    /**
     * 找到含有与给定项相等的结点
     *
     * @param anEntry 给定的项
     * @return 指向所要找的结点及其父结点的一对引用。
     */
    private NodePair findNode(T anEntry) {
        NodePair result = new NodePair();
        boolean found = false;
        BinaryNode<T> currentNode = getRootNode();
        BinaryNode<T> parentNode = null;

        while (!found && (currentNode != null)) {
            T currentEntry = currentNode.getData();
            int comparison = anEntry.compareTo(currentEntry);
            if (comparison < 0) {
                parentNode = currentNode;
                currentNode = currentNode.getLeftChild();
            } else if (comparison > 0) {
                parentNode = currentNode;
                currentNode = currentNode.getRightChild();
            } else
                found = true;
        }
        if (found)
            result = new NodePair(parentNode, currentNode);
        return result;
    }


    //最后一个方法假定，要删除的结点--称为nodeToRemove---最多有一个孩子
    //如果nodeToRemove不是根，则parentNode是其父结点
    private void removeNode(BinaryNode<T> nodeToRemove, BinaryNode<T> parentNode) {
        //将childNode设置为nodeToRemove的孩子，如果存在。
        //如果nodeToRemove是叶子结点，则将childNode设置为null.
        //当结点是树根时，方法根据是否是树根进行判断。
        BinaryNode<T> childNode;
        if (nodeToRemove.hasLeafChild())
            childNode = nodeToRemove.getLeftChild();
        else
            childNode = nodeToRemove.getRightChild();
        //Assertion: If nodeToRemove is a leaf, childNode is null
        if (nodeToRemove == getRootNode())
            setRootNode(childNode);
        else if (parentNode.getLeftChild() == nodeToRemove)
            parentNode.setLeftChild(childNode);
        else
            parentNode.setRightChild(childNode);
    }

    //以下方法是通过递归方法实现的

    @Override
    public T remove(T anEntry) {
        ReturnObject oldEntry = new ReturnObject(null);
        BinaryNode<T> newRoot = removeEntry(getRootNode(), anEntry, oldEntry);
        setRootNode(newRoot);
        return oldEntry.getDataField();
    }


    /**
     * Removes an entry from the tree rooted at a given node.
     *
     * @param rootNode A reference to the root of  a tree
     * @param anEntry  A given node to be removed.
     * @param oldEntry An object whose data field is null.
     * @return The root node of the resulting  tree; if anEntry matches
     * an entry in the tree, oldEntry's data field is the entry
     * that was removed from the tree ;otherwise it is null
     */
    private BinaryNode<T> removeEntry(BinaryNode<T> rootNode, T anEntry, ReturnObject oldEntry) {
        if (rootNode != null) {
            T rootData = rootNode.getData();
            int comparison = anEntry.compareTo(rootData);
            if (comparison == 0) {
                oldEntry.setDataField(rootData);
                rootNode = removeFromRoot(rootNode);
            } else if (comparison < 0) {
                BinaryNode<T> leftChild = rootNode.getLeftChild();
                BinaryNode<T> subtreeRoot = removeEntry(leftChild, anEntry, oldEntry);
                rootNode.setLeftChild(subtreeRoot);
            } else {
                BinaryNode<T> rightChild = rootNode.getRightChild();
                rootNode.setRightChild(removeEntry(rightChild, anEntry, oldEntry));
            }

        }
        return rootNode;

    }

    /**
     * Removes the entry in a given root node of subtree.
     *
     * @param rootNode is the root node of the subtree.
     * @return the root node of revised subtree.
     */
    private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode) {
        //case1: rootNode has two children
        if (rootNode.hasLeafChild() && rootNode.hasRightChild()) {
            //Find node with largest entry in left subtree
            BinaryNode<T> leftSubtreeRoot = rootNode.getLeftChild();
            BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);
            //Replace entry in root
            rootNode.setData(largestNode.getData());
            //remove node with largest entry in left subtree
            rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
        } //Case 2: rootNode has at most one child
        else if (rootNode.hasRightChild())
            rootNode = rootNode.getRightChild();
        else
            rootNode = rootNode.getLeftChild();
        //Assertion: If rootNode was a leaf, it is now null.
        return rootNode;
    }


    /**
     * Finds the node containing the largest entry in a given tree.
     * 有最大项的结点将位于二叉查找树的最有结点。所以只要结点有右孩子，我们就去查找以那个孩子为根的树
     *
     * @param rootNode is the root node of the tree.
     * @return the node containing the largest entry in the tree.
     * 使用删除时的中序前继算法
     */
    private BinaryNode<T> findLargest(BinaryNode<T> rootNode) {
        if (rootNode.hasRightChild())
            rootNode = findLargest(rootNode.getRightChild());
        return rootNode;
    }


    /**
     * Removes the node containing the largest entry in a given tree.
     *
     * @param rootNode rootNode is the root node of the tree
     * @return the root node of the revised tree.
     */
    private BinaryNode<T> removeLargest(BinaryNode<T> rootNode) {
        if (rootNode.hasRightChild()) {
            BinaryNode<T> rightChild = rootNode.getRightChild();
            rightChild = removeLargest(rightChild);
            rootNode.setRightChild(rightChild);
        } else {
            //当树根没有右孩子时，返回左孩子，实际上删除了根。
            rootNode = rootNode.getLeftChild();
        }
        return rootNode;
    }


    private class ReturnObject {
        private T dataField;

        public ReturnObject() {
            this(null);
        }

        public ReturnObject(T dataField) {
            this.dataField = dataField;
        }

        public T getDataField() {
            return dataField;
        }

        public void setDataField(T dataField) {
            this.dataField = dataField;
        }
    }

    private class NodePair {
        BinaryNode<T> curNode;
        BinaryNode<T> parNode;

        public NodePair() {
            this(null, null);
        }

        public NodePair(BinaryNode<T> curNode, BinaryNode<T> parNode) {
            this.curNode = curNode;
            this.parNode = parNode;
        }

        public BinaryNode<T> getCurNode() {
            return curNode;
        }

        public BinaryNode<T> getParNode() {
            return parNode;
        }
    }
}
