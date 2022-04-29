package com.mason.ATD.tree.treePackage;

/**
 * @author Mason
 * @Description
 * @date 2022/4/29 11:43
 */
public interface Copyable extends Cloneable {

    /**
     * 声明一个共有方法clone来重写Object中的保护方法
     * @return
     */
    public Object clone();
}
