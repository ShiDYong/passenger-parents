package com.mason.ATD.tree.AVL;

import com.mason.ATD.tree.binaryTree.TreeInterface;

import java.util.Iterator;

/**
 * @author Mason
 * @Description 用于查找树的接口
 * @date 2022/4/29 22:14
 */
public interface SearchTreeInterface<T extends Comparable<? super T>>
                extends TreeInterface<T> {

    /**
     * Searches for an specific entry in this tree.
     * @param anEntry  An object te be found
     * @return   True if the object was found int the tree.
     */
    public boolean contains( T anEntry);


    /**
     * Retrieves a specific entry in this tree
     * @param anEntry  An object to be found
     * @return   Either the object that was found in the tree or null
     *           if no such object exists.
     */
    public T getEntry(T anEntry);


    /**
     * Adds an new entry to this tree. if it does not match an existing object
     * in the tree. Otherwise, replace the existing object with the new entry.
     * @param newEntry An object to be added to the tree.
     * @return  Either null if anEntry was not in the tree but has been added.or the
     *          exiting entry that matched the parameter anEntry and has been replaced in the tree.
     */
    public T add(T newEntry);


    /**
     *  Removes a specific entry from this tree
     * @param anEntry An object to be removed from this tree
     * @return   Either the object that was removed from the tree or null
     *           if no such object exists.
     */
    public T remove(T anEntry);

    /**
     * Creates an iterator that traversals all entries in this tree.
     * @return    An iterator that provides sequential and ordered access th the entries in the tree.
     */
    public Iterator<T> getInorderIterator();
}
