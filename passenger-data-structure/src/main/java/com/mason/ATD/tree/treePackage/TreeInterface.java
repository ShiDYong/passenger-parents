package com.mason.ATD.tree.treePackage;

/**
 * @author Mason
 * @Description 所有树通用方法的接口类
 * @date 2022/4/27 14:35
 */
public interface TreeInterface<T> {
    public T getRootData();
    public int getHeight();
    public int getNumberOfNodes();
    public boolean isEmpty();
    public void clear();
}
