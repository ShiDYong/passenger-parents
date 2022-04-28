package com.mason.ATD.tree.treePackage;

/**
 * @author Mason
 * @Description A class of null pointer exceptions thrown when an attempt is made to find data.
 * @date 2022/4/27 16:08
 */
public class EmptyTreeException extends NullPointerException {

public EmptyTreeException(){
    this("The root node is empty");
}

public EmptyTreeException(String message){
    super(message);
}



}
