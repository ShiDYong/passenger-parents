package com.mason.ATD.tree.treePackage;

/**
 * @author Mason
 * @Description TODO
 * @date 2022/4/27 16:45
 */
public interface ExpressionTreeInterface extends BinaryTreeInterface<String> {

    /**
     * Computes the values of the expression in this tree.
     * @return  The value of the expression.
     */
    public double evaluate();
}
