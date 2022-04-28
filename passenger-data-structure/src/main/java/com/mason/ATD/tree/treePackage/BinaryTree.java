package com.mason.ATD.tree.treePackage;

import com.mason.ATD.chapter05.LinkedStack;
import com.mason.ATD.chapter05.StackInterface;
import com.mason.ATD.chapter06.LinkedQueue;
import com.mason.ATD.chapter06.QueueInterface;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
                root.setRightChild(rightTree.root.copy());
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


    //递归实现中序遍历
    public void inorderTraverse() {
        inorderTraverse(root);
    }

    //对于递归处理子树的方法，它需要子树的根作为参数，为了让递归方法是私有的
    // 且从一个无参数的共有方法来调用它。
    //为了简单起见，我们只显示数据，尽管ADT的类一般不应执行输入和输出。
    private void inorderTraverse(BinaryNode<T> node) {
        if (node != null) {
            inorderTraverse(node.getLeftChild());
            System.out.println(node.getData());
            inorderTraverse(node.getRightChild());
        }
    }

    /**
     * 实现前序遍历
     */
    public void preorderTraverse() {
        preorderTraverse(root);
    }

    private void preorderTraverse(BinaryNode<T> node) {
        if (node != null) {
            System.out.println(node.getData());
            preorderTraverse(node.getLeftChild());
            preorderTraverse(node.getRightChild());
        }
    }

    @Override
    public Iterator<T> getPreorderIterator() {
        return new PreorderIterator();
    }

    private class PreorderIterator implements Iterator<T> {
        private StackInterface<BinaryNode<T>> nodeStack;
        private BinaryNode<T> currentNode;

        public PreorderIterator() {
            nodeStack = new LinkedStack<>();
            currentNode = root;
        }

        @Override
        public boolean hasNext() {
            return !nodeStack.isEmpty() || currentNode != null;
        }

        @Override
        public T next() {
            BinaryNode<T> nextNode = null;
            if (currentNode != null)
                nodeStack.push(currentNode);
            // Visit leftmost node, then traverse its right subtree
            if (!nodeStack.isEmpty()) {
                nextNode = nodeStack.pop();
                currentNode = nextNode.getRightChild();
                if (currentNode != null)
                    nodeStack.push(currentNode);
                currentNode = nextNode.getLeftChild();
            } // end if
            else
                throw new NoSuchElementException();

            return nextNode.getData();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("BinaryTree iterator don't support this operation.");
        }
    }

    @Override
    public Iterator<T> getPostorderIterator() {
        return new PostorderIterator();
    }

    //实现后序遍历
    public void iteratorPostorderTravers() {
        StackInterface<BinaryNode<T>> nodeStack = new LinkedStack<>();
        BinaryNode<T> currentNode = root;
        BinaryNode<T> nextNode = null;
        BinaryNode<T> prev = null;
        nodeStack.push(currentNode);
        while (!nodeStack.isEmpty() || (currentNode != null)) {
            currentNode = nodeStack.pop();

            //Go up the tree from left node, if the child is right push it onto
            //stack otherwise process parent and pop stack
            if (prev == null || prev.getLeftChild() == currentNode || prev.getRightChild() == currentNode) {
                if (currentNode.getLeftChild() != null)
                    nodeStack.push(currentNode.getLeftChild());
                else if (currentNode.getRightChild() != null)
                    nodeStack.push(currentNode.getRightChild());
                else
                    nextNode = nodeStack.pop();
            } else if (currentNode.getLeftChild() == prev) {
                if (currentNode.getRightChild() != null)
                    nodeStack.push(currentNode.getRightChild());
                else
                    nextNode = nodeStack.pop();

            } else if (currentNode.getRightChild() == prev)
                nextNode = nodeStack.pop();
            prev = currentNode;
        }
    }


    @Override
    public Iterator<T> getInorderIterator() {
        return new InorderIterator();
    }

    //中序遍历的迭代方法,通过迭代器iterator的hasNext(),next()进行逻辑的分解
    public void iteratorInorderTraverse() {
        StackInterface<BinaryNode<T>> nodeStack = new LinkedStack<>();
        BinaryNode<T> currentNode = root;
        while (!nodeStack.isEmpty() || (currentNode != null)) {
            // Find leftmost mode with no left child
            while (currentNode != null) {
                nodeStack.push(currentNode);
                currentNode = currentNode.getLeftChild();
            }//Visit leftmost node, then traverse its right subtree
            if (!nodeStack.isEmpty()) {
                BinaryNode<T> nextNode = nodeStack.pop();
                System.out.println(nextNode.getData());
                currentNode = nextNode.getRightChild();
            }
        }
    }

    public void iteratorPreorderTraverse() {
        StackInterface<BinaryNode<T>> nodeStack = new LinkedStack<>();
        BinaryNode<T> currentNode = root;
        while (!nodeStack.isEmpty() || (currentNode != null)) {
            if (currentNode != null)
                nodeStack.push(currentNode);
            if (!nodeStack.isEmpty()) {
                BinaryNode<T> nextNode = nodeStack.pop();
                assert nextNode != null;
                System.out.println(nextNode.getData());
                currentNode = nextNode.getRightChild();
                if (currentNode != null)
                    nodeStack.push(currentNode);
                currentNode = nextNode.getLeftChild();
            }
        }


    }

    private class PostorderIterator implements Iterator<T> {

        private StackInterface<BinaryNode<T>> nodeStack;
        private BinaryNode<T> currentNode;
        private BinaryNode<T> prev;

        public PostorderIterator() {
            nodeStack = new LinkedStack<>();
            currentNode = root;
            prev = null;
            nodeStack.push(currentNode);
        } // end default constructor

        @Override
        public boolean hasNext() {
            return !nodeStack.isEmpty() || (currentNode != null);
        } // end hasNext

        @Override
        public T next() {
            BinaryNode<T> nextNode = null;

            currentNode = nodeStack.peek();

            // Go down the tree in search of a leaf an if so process it
            // and pop stack otherwise move down
            if (prev == null || prev.getLeftChild() == currentNode ||
                    prev.getRightChild() == currentNode) {
                if (currentNode.getLeftChild() != null)
                    nodeStack.push(currentNode.getLeftChild());
                else if (currentNode.getRightChild() != null)
                    nodeStack.push(currentNode.getRightChild());
                else
                    nextNode = nodeStack.pop();

                // Go up the tree from left node, if the child is right push it onto
                // stack otherwise process parent and pop stack
            } else if (currentNode.getLeftChild() == prev) {
                if (currentNode.getRightChild() != null)
                    nodeStack.push(currentNode.getRightChild());
                else
                    nextNode = nodeStack.pop();

                // go up the tree from right node and after coming back
                // from right node process parent and pop stack
            } else if (currentNode.getRightChild() == prev)
                nextNode = nodeStack.pop();
            prev = currentNode;
            return nextNode.getData();
        } // end next

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        } // end remove void remove() {
    } // end remove
    // end PostorderIterator

    @Override
    public Iterator<T> getLevelOrderIterator() {
        return new LevelOrderIterator();
    }

    public void iterativeLevelOrderTraverse() {
        QueueInterface<BinaryNode<T>> nodeQueue = new LinkedQueue<>();
        BinaryNode<T> currentNode = root;
        BinaryNode<T> prevNode = null;
        while (!nodeQueue.isEmpty() || (currentNode != null)) {
            if (currentNode != null)
                nodeQueue.enqueue(currentNode);
            if (prevNode != null && prevNode.getRightChild() != null)
                nodeQueue.enqueue(prevNode.getRightChild());
            // Visit getLeftChild()most node, then traverse its getRightChild() subtree
            if (!nodeQueue.isEmpty()) {
                BinaryNode<T> nextNode = nodeQueue.dequeue();
                assert nextNode != null; // Since nodeQueue was not empty
                // before the pop
                System.out.println(nextNode.getData());
                prevNode = nextNode;
                currentNode = nextNode.getLeftChild();
            } // end if
        } // end while
    } // end iterative

    private class InorderIterator implements Iterator<T> {
        private StackInterface<BinaryNode<T>> nodeStack;
        private BinaryNode<T> currentNode;

        public InorderIterator() {
            nodeStack = new LinkedStack<>();
            currentNode = root;
        }

        @Override
        public boolean hasNext() {
            return !nodeStack.isEmpty() || (currentNode != null);
        }

        @Override
        public T next() {
            BinaryNode<T> nextNode = null;
            //Find leftmost node with no left child
            while (currentNode != null) {
                nodeStack.push(currentNode);
                currentNode = currentNode.getLeftChild();
            }
            //Get leftmost node, then move to its right subtree
            if (!nodeStack.isEmpty()) {
                nextNode = nodeStack.pop();
                currentNode = nextNode.getRightChild();
            } else
                throw new NoSuchElementException();

            return nextNode.getData();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class LevelOrderIterator implements Iterator<T> {
        private QueueInterface<BinaryNode<T>> nodeQueue;
        private BinaryNode<T> currentNode;
        private BinaryNode<T> prevNode;

        public LevelOrderIterator() {
            nodeQueue = new LinkedQueue<>();
            currentNode = root;
            prevNode = null;
        } // end default constructor

        @Override
        public boolean hasNext() {
            return !nodeQueue.isEmpty() || (currentNode != null);
        } // end hasNext

        @Override
        public T next() {
            BinaryNode<T> nextNode = null;

            if (currentNode != null)
                nodeQueue.enqueue(currentNode);
            if (prevNode != null && prevNode.getRightChild() != null)
                nodeQueue.enqueue(prevNode.getRightChild());
            // Visit getLeftChild()most node, then traverse its getRightChild() subtree
            if (!nodeQueue.isEmpty()) {
                nextNode = nodeQueue.dequeue();
                assert nextNode != null; // Since nodeQueue was not empty
                // before the pop
//                System.out.println(nextNode.getData());
                prevNode = nextNode;
                currentNode = nextNode.getLeftChild();
            } else
                throw new NoSuchElementException();

            return nextNode.getData();
        } // end next

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        } // end remove
    } // end Level
}
