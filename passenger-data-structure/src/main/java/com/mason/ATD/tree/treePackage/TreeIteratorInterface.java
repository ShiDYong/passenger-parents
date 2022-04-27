package com.mason.ATD.tree.treePackage;

import java.util.Iterator;

/**
 * @author Mason
 * @Description 树的遍历方法的接口
 * @date 2022/4/27 14:37
 */
public interface TreeIteratorInterface<T> {
    public Iterator<T> getPreorderIterator();
    public Iterator<T> getPostorderIterator();
    public Iterator<T> getInorderIterator();
    public Iterator<T> getLevelOrderIterator();
}
