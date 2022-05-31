package com.mason.ATD.map;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Mason
 * @Description A class that implements a dictionary by using a resizable sorted array.
 * The dictionary is unsorted and has distinct search keys.
 * @date 2022/4/24 16:05
 */
public class SortedArrayDictionary<K extends Comparable<? super K>, V>
        implements DictionaryInterface<K, V> {

    //Array of unsorted entries
    private Entry<K, V>[] dictionary;
    private int numberOfEntries;
    private boolean integrityOk = false;
    private final static int DEFAULT_CAPACITY = 25;
    private final static int MAX_CAPACITY = 10000;

    public SortedArrayDictionary() {
        this(DEFAULT_CAPACITY);
    }


    public SortedArrayDictionary(int initialCapacity) {
        //检查是否超过容量极限
        checkCapacity(initialCapacity);
        @SuppressWarnings("unchecked")
        Entry<K, V>[] tempDictionary = (Entry<K, V>[]) new Entry[initialCapacity];
        dictionary = tempDictionary;
        integrityOk = true;
        numberOfEntries = 0;

    }

    //Throws an exception  if the client requests a capacity that is too large.
    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a bag whose" +
                    "capacity exceeds allowed maximum of" + MAX_CAPACITY);
        }
    }

    // Throws an exception if this object is not initialized.
    private void checkIntegrity() {
        if (!integrityOk)
            throw new SecurityException("ArrayDictionary object is corrupt");
    }

    //Doubles the size of the array of entries if it is full.
    //实现动态数组的扩容
    private void ensureCapacity() {
        if (numberOfEntries >= dictionary.length - 1) {
            int newCapacity = dictionary.length << 1;
            checkCapacity(newCapacity);
            dictionary = Arrays.copyOf(dictionary, newCapacity + 1);
        }

    }


    /**
     * 任务：将(key,value)对添加到字典中
     *
     * @param key   key是查找键对象，value是对应到对象
     * @param value 无
     */
    @Override
    public V add(K key, V value) {
        checkIntegrity();
        V result = null;
        if (key == null || value == null)
            throw new IllegalArgumentException();
        else {
            int keyIndex = locateIndex(key);
            //注意与无序数组的对比
            if ((keyIndex < numberOfEntries) && (key.equals(dictionary[keyIndex].getKey()))) {
                //进行替换掉value
                result = dictionary[keyIndex].getValue();
                dictionary[keyIndex].setValue(value);
            } else {
                //key not found: add new entry to dictionary.
                //从插入点开始移动数据项
                makeRoom(keyIndex);
                dictionary[keyIndex] = new Entry<>(key, value);
                numberOfEntries++;
                ensureCapacity();

            }

        }


        return null;
    }

    //实现插入点后面的项整体向后移动一步的方法.
    private void makeRoom(int newPosition) {
        assert (newPosition >= 0) && (newPosition <= numberOfEntries);
        int newIndex = newPosition;
        int lastIndex = numberOfEntries;
        for (int index = lastIndex; index >= newIndex; index--) {
            dictionary[index + 1] = dictionary[index];
        }


    }

    //Search until you either find an entry containing key or.
    //pass the point where it should be.
//    private int locateIndex(K key) {
//        int index = 0;
//        //注意这个的实现与无序数组时比较方法不一样
//        while ((index < numberOfEntries) && (key.compareTo(dictionary[index].getKey()) > 0))
//            index++;
//        return index;
//    }
    //因为数组是有序的，数据量很大时可以使用二分法实现查找
    private int locateIndex(K key) {
        return binarySearch(0, numberOfEntries - 1, key);

    }

    /**
     * Binary search on a sorted array for key, recursively.
     * Implement with the ADt sorted list array.
     *
     * @return An integer indicating either the location of the entry if exist,
     * or the location that should contain key otherwise.
     */
    private int binarySearch(int first, int last, K key) {
        int result;
        if (first > last)
            result = first;
        else {
            int mid = first + (last - first) / 2;
            K midKey = dictionary[mid].getKey();
            if (key.equals(midKey))
                result = mid;
            else if (midKey.compareTo(key) > 0)
                result = binarySearch(first, mid - 1, key);
            else
                result = binarySearch(first, mid + 1, key);
        }
        return result;
    }

    /**
     * 任务：从字典中删除对应于给定查找键到项
     *
     * @param key 是查找键对象
     * @return 返回对应于查找键到值；或者，如果这样到对象不存在，则返回null。
     */
    @Override
    public V remove(K key) {
        checkIntegrity();
        if (key == null)
            throw new IllegalArgumentException();
        int keyIndex = locateIndex(key);
        V result = null;
        if ((keyIndex < numberOfEntries) && (key.equals(dictionary[keyIndex].getKey()))) {
            result = dictionary[keyIndex].getValue();
            //将找到的项后面的所有项移向数组中的一个较低位置
            removeGap(keyIndex);
            //将含有最后一项的数组元素置为null
            dictionary[numberOfEntries] = null;
            numberOfEntries--;

        }
        return result;
    }

    private void removeGap(int givePosition) {
        assert (givePosition >= 0) && (givePosition < numberOfEntries);
        int removeIndex = givePosition;
        int lastIndex = numberOfEntries;
        for (int index = removeIndex; index < lastIndex; index++) {
            dictionary[index - 1] = dictionary[index];
        }

    }

    /**
     * 从字典中获取与给定查找键对应的值
     *
     * @param key 查找键对象
     * @return 如果字典中的一个项有与所给查找键一样的键，则返回真
     */
    @Override
    public V getValue(K key) {
        int keyIndex = locateIndex(key);
        V result = null;
        if ((keyIndex < numberOfEntries) && key.equals(dictionary[keyIndex].getKey()))
            result = dictionary[keyIndex].getValue();
        return result;
    }


    /**
     * 任务：查看字典是否存在有给定查找键的项
     *
     * @param key 是查找键对象
     * @return 如果字典中的一个项有与所给查找键一样的键，则返回真
     */
    @Override
    public boolean contains(K key) {
        boolean found = false;
        int keyIndex = locateIndex(key);
        if ((keyIndex < numberOfEntries) && (key.equals(dictionary[keyIndex].getKey())))
            found = true;
        return found;
    }

    @Override
    public Iterator<K> getKeyIterator() {
        Iterator<K> myIterator = new KeyIterator(this);
        return myIterator;
    }

    @Override
    public Iterator<V> getValueIterator() {
        Iterator<V> myIterator = new ValueIterator(this);
        return myIterator;

    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public int getSize() {
        return numberOfEntries;
    }

    @Override
    public void clear() {
        int count = 0;
        while (!isEmpty()) {
            dictionary[count] = null;
            count++;
            numberOfEntries--;

        }

    }


    private class KeyIterator implements Iterator<K> {
        private int cursor; // Current location of the cursor; 0 means beginning
        private SortedArrayDictionary<K, V> arrayDictionary;
        private K nextEntry;

        public KeyIterator(SortedArrayDictionary<K, V> newDictionary) {
            arrayDictionary = newDictionary;
            cursor = 0;
            nextEntry = null;
        } // end constructor

        /**
         * Detects whether this iterator has completed its traversal
         * and gone beyond the last entry in the collection of data.
         *
         * @return True if the iterator has another entry to return.
         */
        @Override
        public boolean hasNext() {
            return (!isEmpty() && (cursor < numberOfEntries));
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
            if (hasNext()) {
                K currentEntry = arrayDictionary.dictionary[cursor].getKey();
                cursor++;
                nextEntry = currentEntry;
                return currentEntry;
            } else
                throw new NoSuchElementException();
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
            if (nextEntry == null) {
                if (cursor == 0)
                    throw new IllegalStateException("Empty dictionary.");
                else
                    throw new IllegalStateException("next() has not been called "
                            + "or remove() was already called after the last"
                            + " call to next()");
            } else {
                K toRemove = arrayDictionary.dictionary[cursor - 1].getKey();
                arrayDictionary.remove(toRemove);
                cursor--;
                nextEntry = null;
            } // end if
        } // end remove
    } // end KeyIterator

    private class ValueIterator implements Iterator<V> {
        private int cursor; // Current location of the cursor; 0 means beginning
        private SortedArrayDictionary<K, V> arrayDictionary;
        private V nextEntry;

        public ValueIterator(SortedArrayDictionary<K, V> newDictionary) {
            arrayDictionary = newDictionary;
            cursor = 0;
            nextEntry = null;
        } // end constructor

        /**
         * Detects whether this iterator has completed its traversal
         * and gone beyond the last entry in the collection of data.
         *
         * @return True if the iterator has another entry to return.
         */
        @Override
        public boolean hasNext() {
            return (!isEmpty() && (cursor < numberOfEntries));
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
            if (hasNext()) {
                V currentEntry = arrayDictionary.dictionary[cursor].getValue();
                cursor++;
                nextEntry = currentEntry;
                return currentEntry;
            } else
                throw new NoSuchElementException();
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
            throw new UnsupportedOperationException("remove() method is not " +
                    "supported for ValueIterator().");
        } // end remove
    } // end ValueIterator

    private class Entry<K, V> {
        private K key;
        private V value;

        private Entry(K searchKey, V dataValue) {
            key = searchKey;
            value = dataValue;
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
    } // end E
}
