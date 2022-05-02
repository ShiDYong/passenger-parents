package com.mason.ATD.tree.bst;

import java.util.Iterator;

/**
 * @author Mason
 * @Description 使用二叉查找树实现ATD字典的类框架
 * @date 2022/5/1 16:42
 */
public class BstDictionary<K extends Comparable<? super K>, V>
        implements DictionaryInterface<K, V> {

    private SearchTreeInterface<Entry<K, V>> bst;

    public BstDictionary() {
        bst = new BinarySearchTree<>();
    }

    /* Methods that implement dictionary operations are here. */

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
        Entry<K, V> anEntry = new Entry<>(key, value);
        Entry<K, V> returnedEntry = bst.add(anEntry);
        V result = null;
        if (returnedEntry != null)
            result = returnedEntry.getValue();
        return result;
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
        Entry<K, V> findEntry = new Entry<>(key, null);
        Entry<K, V> removeEntry = bst.remove(findEntry);
        V result = null;
        if (removeEntry != null)
            result = removeEntry.getValue();
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
        Entry<K, V> findEntry = new Entry(key, null);
        Entry<K, V> foundEntry = bst.getEntry(findEntry);
        V result = null;
        if (foundEntry != null)
            result = foundEntry.getValue();
        return result;
    }

    /**
     * Sees whether a specific entry is in this dictionary.
     *
     * @param key An object search key of the desired entry.
     */
    @Override
    public boolean contains(K key) {
        Entry<K, V> findEntry = new Entry<>(key, null);
        return bst.contains(findEntry);
    }

    /**
     * Creates an iterator that traverses all search keys in this dictionary.
     *
     * @return An iterator that provides sequential access to the search
     * keys in the dictionary.
     */
    @Override
    public Iterator<K> getKeyIterator() {
        return new KeyIterator();
    }

    private class KeyIterator implements Iterator<K> {
        Iterator<Entry<K, V>> localIterator;

        public KeyIterator() {
            localIterator = bst.getInorderIterator();
        } // end default constructor

        @Override
        public boolean hasNext() {
            return localIterator.hasNext();
        } // end hasNext

        @Override
        public K next() {
            Entry<K, V> nextEntry = localIterator.next();
            return nextEntry.getKey();
        } // end next

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        } // end remove
    } // end KeyIterator

    private class ValueIterator implements Iterator<V> {
        Iterator<Entry<K, V>> localIterator;

        public ValueIterator() {
            localIterator = bst.getInorderIterator();
        } // end default constructor

        @Override
        public boolean hasNext() {
            return localIterator.hasNext();
        } // end hasNext

        @Override
        public V next() {
            Entry<K, V> nextEntry = localIterator.next();
            return nextEntry.getValue();
        } // end next

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        } // end remove
    } // end ValueIterator

    /**
     * Creates an iterator that traverses all values in this dictionary.
     *
     * @return An iterator that provides sequential access to the values
     * in this dictionary.
     */
    @Override
    public Iterator<V> getValueIterator() {
        return new ValueIterator();
    }

    /**
     * Sees whether this dictionary is empty.
     *
     * @return True if the dictionary is empty.
     */
    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public int getSize() {
        return bst.getNumberOfNodes();
    }

    @Override
    public void clear() {
        bst.clear();
    }

    private class Entry<S extends Comparable<? super S>, T>
            implements Comparable<Entry<S, T>> {
        private S key;
        private T value;

        public Entry(S key, T value) {
            //注意这里要加上this.key或者参数名写成 S searchKey,不然无法构造生成对象
            this.key = key;
            this.value = value;
           // key = key;
           // value = value;
        }

        @Override
        public int compareTo(Entry<S, T> other) {
            return key.compareTo(other.key);
        }

        public S getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

//        public boolean equals(Entry<S, T> other) {
//            return key.equals(other.getKey());
//        }
//
//        @Override
//        public String toString() {
//            return key + "\t" + value;
//        }
    }
}
