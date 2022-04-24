package com.mason.ATD.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Mason
 * @Description A class that implements a dictionary by using a
 * a resizable sorted array.
 * The dictionary is unsorted and has distinct search keys.
 * @date 2022/4/24 21:50
 */
public class SortedLinkedDictionary<K extends Comparable<? super K>, V>
        implements DictionaryInterface<K, V> {
    private Node firstNode;
    private int numberOfEntries;

    public SortedLinkedDictionary() {
        initializeDataFields();
    }

    //初始化的方法.
    private void initializeDataFields() {
        firstNode = null;
        numberOfEntries = 0;
    }

    /**
     * Adds a new entry to this dictionary. If the given search key already
     * exists in the dictionary, replaces the corresponding value.
     *
     * @param key   An object search key of the new entry.
     * @param value An object associated with the search key.
     * @return Either null if the new entry was added to the dictionary
     * or the value that was associated with key if that value
     * was replaced.
     */
    @Override
    public V add(K key, V value) {
        V result = null;
        if (key == null || value == null)
            throw new IllegalArgumentException("Cannot add null to dictionary.");
        Node beforeNode = getBeforeNode(key);
        Node currentNode = firstNode;
        if ((currentNode != null) && key.equals(currentNode.getKey())) {
            //当前结点中已经存在对应的key,进行替换值操作
            result = currentNode.getValue();
            currentNode.setValue(value);
        } else {
            Node newNode = new Node(key, value);
            //当前处于空链表或者插入链表头部
            if (beforeNode == null) {
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            } else {//Adds elsewhere in non-empty chain
                Node nodeAfter = beforeNode.getNextNode();
                newNode.setNextNode(nodeAfter);
                beforeNode.setNextNode(newNode);
            }
            numberOfEntries++;
        }
        return result;
    }

    //查找key出现的下标
    private Node getBeforeNode(K key) {
        Node currentNode = firstNode;
        Node nodeBeforeNode = null;
        while ((nodeBeforeNode != null) && key.compareTo(currentNode.getKey()) > 0) {
            nodeBeforeNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        return nodeBeforeNode;
    }


    /**
     * Removes a specific entry from this dictionary.
     *
     * @param key An object search key of the entry to be removed.
     * @return Either the value that was associated with the search key
     * or null if no such object exists.
     */
    @Override
    public V remove(K key) {
        V result = null;
        if (key == null)
            throw new IllegalArgumentException("Cannot remove null dictionary.");
        Node beforeNode = getBeforeNode(key);
        Node currentNode = firstNode;
        if (beforeNode != null)
            currentNode = beforeNode.getNextNode();
        if ((currentNode != null) && key.equals(currentNode.getKey())) {
            result = currentNode.getValue();
            Node nodeAfter = currentNode.getNextNode();
            nodeAfter.setNextNode(nodeAfter);
        }
        numberOfEntries--;
        return result;
    }

    /**
     * Retrieves from this dictionary the value associated with a given
     * search key.
     *
     * @param key An object search key of the entry to be retrieved.
     * @return Either the value that is associated with the search key
     * or null if no such object exists.
     */
    @Override
    public V getValue(K key) {
        V result = null;
        Node beforeNode = getBeforeNode(key);
        Node currentNode = firstNode;
        if (beforeNode != null)
            currentNode = beforeNode.getNextNode();
        if ((currentNode != null) && key.equals(currentNode.getKey()))
            result = currentNode.getValue();
        return result;
    }

    @Override
    public boolean contains(K key) {
        boolean find = false;
        Node beforeNode = getBeforeNode(key);
        Node currentNode = firstNode;
        if (beforeNode != null)
            currentNode = beforeNode.getNextNode();
        if ((currentNode != null) && key.equals(currentNode.getKey()))
            find = true;
        return find;
    }

    @Override
    public Iterator<K> getKeyIterator() {
        Iterator<K> myIterator = new KeyIterator();
        return myIterator;
    }

    @Override
    public Iterator<V> getValueIterator() {
        Iterator<V> myIterator = new ValueIterator();
        return myIterator;
    }

    @Override
    public boolean isEmpty() {
        boolean result;
        if (numberOfEntries == 0) {
            assert firstNode == null;
            result = true;
        } else {
            assert firstNode != null : "numberOfEntries is not 0 but firstNode is null";
            result = false;
        }
        return result;
    }

    @Override
    public int getSize() {
        return numberOfEntries;
    }

    @Override
    public void clear() {
        initializeDataFields();

    }


    private class KeyIterator implements Iterator<K> {
        private Node nextNode; // Node containing next entry in iteration

        public KeyIterator() {
            nextNode = firstNode;
        } // end default constructor

        /**
         * Detects whether this iterator has completed its traversal
         * and gone beyond the last entry in the collection of data.
         *
         * @return True if the iterator has another entry to return.
         */
        @Override
        public boolean hasNext() {
            return nextNode != null;
        } // end hasNext

        /**
         * Retrieves the next entry in the collection and
         * advances this iterator by one position.
         *
         * @return A reference to the next entry in the iteration,
         * if one exists.
         * @throws NoSuchElementException if the iterator had reached the
         *                                end already, that is, if hasNext() is false.
         */
        @Override
        public K next() {
            K result;
            if (hasNext()) {
                result = nextNode.getKey();
                nextNode = nextNode.getNextNode();
                return result;
            } else
                throw new NoSuchElementException("Illegal call to next(); " +
                        "iterator is after end of list.");
            // end if
        } // end next

        /**
         * Removes from the collection of data the last entry that
         * next() returned. A subsequent call to next() will behave
         * as it would have before the removal.
         * Precondition: next() has been called, and remove() has not
         * been called since then. The collection has not been altered
         * during the iteration except by calls to this method.
         *
         * @throws IllegalStateException         if next() has not been called, or
         *                                       if remove() was called already after the last call to next().
         * @throws UnsupportedOperationException if the iterator does
         *                                       not permit a remove operation.
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported "
                    + "by this iterator");
        } // end remove
    } // end KeyIterator

    private class ValueIterator implements Iterator<V> {
        private Node nextNode; // Node containing next entry in iteration

        public ValueIterator() {
            nextNode = firstNode;
        } // end default constructor

        /**
         * Detects whether this iterator has completed its traversal
         * and gone beyond the last entry in the collection of data.
         *
         * @return True if the iterator has another entry to return.
         */
        @Override
        public boolean hasNext() {
            return nextNode != null;
        } // end hasNext

        /**
         * Retrieves the next entry in the collection and
         * advances this iterator by one position.
         *
         * @return A reference to the next entry in the iteration,
         * if one exists.
         * @throws NoSuchElementException if the iterator had reached the
         *                                end already, that is, if hasNext() is false.
         */
        @Override
        public V next() {
            V result;
            if (hasNext()) {
                result = nextNode.getValue();
                nextNode = nextNode.getNextNode();
                return result;
            } else {
                throw new NoSuchElementException("Illegal call to next(); " +
                        "iterator is after end of list.");
            }
            // end if
        } // end next

        /**
         * Removes from the collection of data the last entry that
         * next() returned. A subsequent call to next() will behave
         * as it would have before the removal.
         * Precondition: next() has been called, and remove() has not
         * been called since then. The collection has not been altered
         * during the iteration except by calls to this method.
         *
         * @throws IllegalStateException         if next() has not been called, or
         *                                       if remove() was called already after the last call to next().
         * @throws UnsupportedOperationException if the iterator does
         *                                       not permit a remove operation.
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported "
                    + "by this iterator");
        } // end remove
    } // end ValueIterator


    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0 */
    private class Node {
        private K key;  // Search key in the dictionary
        private V value; // Associated value
        private Node next;  // Link to next node

        private Node(K keyData, V valueData) {
            this(keyData, valueData, null);
        } // end constructor

        private Node(K keyData, V valueData, Node nextNode) {
            key = keyData;
            value = valueData;
            next = nextNode;
        } // end constructor

        private K getKey() {
            return key;
        } // end getKey

        private V getValue() {
            return value;
        } // end getValue

        private void setValue(V newValue) {
            value = newValue;
        } // end setValue

        private Node getNextNode() {
            return next;
        } // end getNextNode

        private void setNextNode(Node nextNode) {
            next = nextNode;
        } // end setNextNode
    } // end Node
} // e

