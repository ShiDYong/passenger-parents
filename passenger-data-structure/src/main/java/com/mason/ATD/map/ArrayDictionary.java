package com.mason.ATD.map;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Mason
 * @Description A class that implements the ATD dictionary by using
 * a resizable array The dictionary is unsorted and has
 * distinct search keys.Search keys and associated values
 * are not null.
 * @date 2022/4/24 09:38
 */
public class ArrayDictionary<K, V> implements DictionaryInterface<K, V> {
    //Array of unsorted entries
    private Entry<K, V>[] dictionary;

    private int numberOfEntries;
    private boolean integrityOk = false;
    private final static int DEFAULT_CAPACITY = 25;
    private final static int MAX_CAPACITY = 10000;

    public ArrayDictionary() {
        this(DEFAULT_CAPACITY);
    }


    public ArrayDictionary(int initialCapacity) {
        //检查是否超过容量极限
        checkCapacity(initialCapacity);
        @SuppressWarnings("unchecked")
        Entry<K, V>[] tempDictionary = (Entry<K, V>[]) new Entry[initialCapacity];
        dictionary = tempDictionary;
        integrityOk = true;
        numberOfEntries = 0;

    }


    //Throws an exception  if the client requests a capactity that is too large.
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

    //查看当前字典中是否存在某个查找键，存在返回该项的下标，如果不存在返回项的个数
    //字典的查找键是无序的，需要进行顺序查找。顺序查找必须查看数组中的所有项，以推断出一个项目
    //在不在字典中
    private int locateIndex(K key) {
//        boolean found = false;
//        int index = 0;
//        while (!found && (index < numberOfEntries)) {
//            if (key.equals(dictionary[index].getKey()))
//                found = true;
//            else
//                index++;
//        }
//        return index;
        int index = 0;
        while ((index < numberOfEntries) && !key.equals(dictionary[index].getKey()))
            index++;
        return index;


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
        //不允许键或者值为null
        if (key == null || value == null)
            throw new IllegalArgumentException();
        else {
            V result = null;
            //判断字典是否已经存在了查找键，如果存在返回对应的下标，不存在返回字典的项的个数
            int keyIndex = locateIndex(key);
            if (keyIndex < numberOfEntries) {
                //查看字典中是否已经存在如果存在则替换value
                result = dictionary[keyIndex].getValue(); //Get old value
                dictionary[keyIndex].setValue(value); //Sets new value
            } else {
                Entry<K, V> newEntry = new Entry<>(key, value);
                //直接插在尾部
                dictionary[numberOfEntries] = newEntry;
                numberOfEntries++;
                ensureCapacity(); //Ensure enough room for next add.

            }
            return result;
        }
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
            throw new IllegalStateException();
        int keyIndex = locateIndex(key);
        V result = null;
        if (keyIndex < numberOfEntries) {
            result = dictionary[keyIndex].getValue();
            //将数组的最后的一项替代被删除的项
            dictionary[keyIndex] = dictionary[numberOfEntries];
            //将数组最后一项设置为Null
            dictionary[numberOfEntries] = null;
            numberOfEntries--;
            return result;
        } else
            throw new IllegalStateException("Dictionary has not found " + key);

    }


    /**
     * 从字典中获取与给定查找键对应的值
     *
     * @param key 查找键对象
     * @return 如果字典中的一个项有与所给查找键一样的键，则返回真
     */
    @Override
    public V getValue(K key) {
        V result = null;
        // if (key == null)
        //   throw new IllegalStateException();
        int keyIndex = locateIndex(key);
        if (keyIndex < numberOfEntries)
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
        if (keyIndex < numberOfEntries)
            found = true;
        return found;
    }


    /**
     * 任务：创建遍历字典中所有查找键的迭代器
     *
     * @return 返回一个迭代器，能顺序访问字典的查找键
     */
    @Override
    public Iterator<K> getKeyIterator() {
        Iterator<K> myIterator = new KeyIterator<>(this);
        return myIterator;
    }


    /**
     * 任务：遍历字典中所有值的迭代器
     *
     * @return 返回一个迭代器，能顺序访问字典中的值
     */
    @Override
    public Iterator<V> getValueIterator() {
        Iterator<V> myIterator = new ValueIterator<>(this);
        return myIterator;
    }


    /**
     * 查看字典是否为空
     *
     * @return 如果字典为空，则返回真
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


    /**
     * 任务：得到字典的大小
     *
     * @return 返回字典中当前项的个数
     */
    @Override
    public int getSize() {
        return numberOfEntries;
    }


    /**
     * 任务：删除字典中的所有项
     */
    @Override
    public void clear() {
        int count = 0;
        while (!isEmpty()) {
            dictionary[count] = null;
            count++;
            numberOfEntries--;
        }
    }


    private class KeyIterator<K> implements Iterator<K> {

        private int cursor; // current location of the cursor; 0 means begining
        private ArrayDictionary<K, V> arrayDictionary;
        private K nextEntry;

        public KeyIterator(ArrayDictionary<K, V> newDictionary) {
            this.arrayDictionary = newDictionary;
            cursor = 0;
            nextEntry = null;
        }

        /**
         * Returns true if the iteration has more elements.
         * (In other words, returns true if next would return an element
         * rather than throwing an exception.)
         *
         * @Returns: true if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return (!isEmpty() && (cursor < numberOfEntries));
        }

        /**
         * Returns the next element in the iteration.
         * Returns:the next element in the iteration
         * Throws:  NoSuchElementException – if the iteration has no more elements
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
        }

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
                    throw new IllegalStateException("Empty dictionary");
                else
                    throw new IllegalStateException("next() has not been called "
                            + "or remove() was already called after the last"
                            + " call to next()");
            } else {
                K toRemove = arrayDictionary.dictionary[cursor - 1].getKey();
                arrayDictionary.remove(toRemove);
                cursor--;
                nextEntry = null;
            }
        }
    }


    private class ValueIterator<V> implements Iterator<V> {

        private int cursor; // Current location of the cursor; 0 means beginning
        private ArrayDictionary<K, V> arrayDictionary;
        private V nextEntry;

        public ValueIterator(ArrayDictionary<K, V> newDictionary) {
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
        } // e
    }

    private class Entry<K, V> {
        private K key;
        private V value;

        private Entry(K searchKey, V dataValue) {
            key = searchKey;
            value = dataValue;
        }

        public K getKey() {
            return key;
        }
        //内部类没有设置方法setKey去设置或修改查找键，因为不需要修改查找键
        //没有setKey方法，默认构造器方法就没用了，因此也就没有定义。

        public V getValue() {
            return value;
        }

        public void setValue(V newValue) {
            this.value = newValue;
        }
    }
}
