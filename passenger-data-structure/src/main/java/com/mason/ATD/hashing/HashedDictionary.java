package com.mason.ATD.hashing;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * @author Mason
 * @Description A class that implements the ADT dictionary by using hashing
 * a linear probing to resolve collisions.
 * The dictionary is unsorted and has distinct search keys.
 * Search keys and associated values aer not null.
 * @date 2022/4/26 09:55
 */
public class HashedDictionary<K, V> implements DictionaryInterface<K, V> {

    // The dictionary
    private int numberOfEntries;
    private final static int DEFAULT_CAPACITY = 5;  //必须是素数 Must be prime.
    private static final int MAX_CAPACITY = 10000;

    //The hash table
    private Entry<K, V>[] hashTable;
    private int tableSize;  //Must be prime
    private static final int MAX_SIZE = MAX_CAPACITY << 1;
    private boolean integrityOk = false;
    //装填因子：入=字典项数/散列表中的位置数，实现修改将字典的个数替换为占据或可用状态的的表元素数
    //解决冲突方案中开放地址法：线性探查，二次探查和双散列装填因子入<=0.5 性能比较高；
    //拉链法中装填因子入<= 1,性能效果最好
    private static final double MAX_LOAD_FACTOR = 0.5; // Fraction of hash table that can be filled.

    public HashedDictionary() {
        this(DEFAULT_CAPACITY);
    }

    public HashedDictionary(int initialCapacity) {
        checkCapacity(initialCapacity);
        numberOfEntries = 0;
        tableSize = getNextPrime(initialCapacity);
        checkSize(tableSize);//Check for max array size;
        @SuppressWarnings("unchecked")
        Entry<K, V>[] temp = (Entry<K, V>[]) new Entry[tableSize];
        hashTable = temp;
        integrityOk = true;

    }

    private int getNextPrime(int anInteger) {
        int result;
        //因为数组的长度要求是素数，首先先判断是不是偶数
        if (anInteger % 2 == 0)
            anInteger++; //是偶数加1变成奇数
        while (!isPrime(anInteger)) //进一步进行删选成为素数
            anInteger = anInteger + 2;
        result = anInteger;
        return result;

    }

    //测试该整数是不是素数，虽然2和3都是素数，但1及偶整数都不是。
    private boolean isPrime(int anInteger) {
        boolean result = false;
        if ((anInteger == 2) || (anInteger == 3))
            result = true;
        else {
            //大于等于5的奇整数，如果不能被其最大到其平方根的每个奇数整除，则是素数
            if ((anInteger % 2 == 1) && (anInteger >= 5)) {
                result = true;
                for (int i = 3; i <= Math.sqrt(anInteger); i = i + 2) {
                    result = result && (anInteger % i != 0);
                }
            }
        }
        return result;
    }

    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed" +
                    "maximum of " + MAX_CAPACITY);
    }

    private void checkSize(int number) {
        checkCapacity(number);
    }

    //根据查找键获取散列码,再通过散列码获取数组的下标
    private int getHashIndex(K key) {
        int hashIndex = key.hashCode() % hashTable.length;
        if (hashIndex < 0)
            hashIndex = hashIndex + hashTable.length;
        return hashIndex;
    }

    //查看数组是否初始化
    private void isInitialed() {
        if (!integrityOk)
            throw new SecurityException("Array object is corrupt.");
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
        isInitialed();
        if (key == null || value == null)
            throw new IllegalArgumentException();
        else {
            V oldValue;
            int index = getHashIndex(key);
            //当出现冲突时，通过调用该方法可以利用线性探查法寻找可用元素
            index = linerProbe(index, key);
            assert (index >= 0) && (index < hashTable.length);
            if ((hashTable[index] == null) || hashTable[index].isRemove()) {
                // Key not found; add new entry dictionary
                hashTable[index] = new Entry<>(key, value);
                numberOfEntries++;
                oldValue = null;
            } else {
                //Key found; get old Value for return and then replace it.
                oldValue = hashTable[index].getValue();
                hashTable[index].setValue(value);
            }
            if (isHashTableTooFull())
                enlargeHashTable();              //进行散列表的扩容


            return oldValue;
        }


    }

    // Returns true if the hash table’s load factor is greater than or equal to
    // MAX_LOAD_FACTOR. Here we define the load factor as the ratio of
    // locationsUsed to hashTable.length.
    private boolean isHashTableTooFull() {
        double locationUsed = numberOfEntries;
        boolean result = false;
        //计算出当前的装载因子
        double loadFactor = locationUsed / hashTable.length;
        //查看是不是已经超过最大装载因子
        if (loadFactor >= MAX_LOAD_FACTOR)
            result = true;
        return result;

    }

    // Expands the hash table to a size that is both prime and at least double its
    // current size, and then adds the current entries in the dictionary to the
    // new hash table. In doing so, this method must rehash the table entries.
    private void enlargeHashTable() {
        Entry<K, V>[] oldTable = hashTable;
        int oldSize = hashTable.length;
        int newSize = getNextPrime(oldSize + oldSize);
        checkSize(newSize);
        @SuppressWarnings("unchecked")
        Entry<K, V>[] temp = (Entry<K, V>[]) new Entry[newSize];
        hashTable = temp;
        numberOfEntries = 0; //Reset number of dictionary entries,since it
        //will be incremented by add during rehash.
        for (int index = 0; index < oldSize; index++) {
            if ((oldTable[index] != null) && oldTable[index].isIn())
                add(oldTable[index].getKey(), oldTable[index].getValue());

        }


    }

    // Searches the probe sequence that begins at index.
    // Returns either the index of the entry containing key or
    //  the index of an available location in the hash table.
    // This index is always legal, since the probe sequence stays within the hash table.
    //使用线性探查法
    private int linerProbe(int index, K key) {
        boolean found = false;
        int removedStateIndex = -1;
        while (!found && hashTable[index] != null) {
            if (hashTable[index].isIn()) {
                if (key.equals(hashTable[index].getKey()))
                    found = true; //退出循环
                else    //下一个探查下标
                    index = (index + 1) % hashTable.length; //Liner probing(circular);
            } else {//下标是是可用的元素
                if (removedStateIndex == -1)
                    removedStateIndex = index;
                index = (index + 1) % hashTable.length;
            }
        }
        if (found || removedStateIndex == -1) //找到key或者没有遇到一个可用元素
            return index;
        else
            return removedStateIndex;
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
        isInitialed();
        V removeValue = null;
        int index = getHashIndex(key);
        if ((hashTable[index] != null) && (hashTable[index].isIn())) {
            removeValue = hashTable[index].getValue();
            //将散列表的该项元素设置为可用状态，散列表的元素状态总共有三种：可用，占用，null
            hashTable[index].setToRemove();
            numberOfEntries--;
        }
        return removeValue;
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
        isInitialed();
        V result = null;
        int index = getHashIndex(key);
        //查找能否找到key
        if ((hashTable[index] != null) && (hashTable[index].isIn()))
            result = hashTable[index].getValue(); //Key found; getvalue
        // Key not found ; return null
        return result;
    }

    @Override
    public boolean contains(K key) {
        boolean result = false;
        int index = getHashIndex(key);
        index = linerProbe(index, key);
        if ((hashTable[index] != null) && hashTable[index].isIn())
            result = true;
        return result;
    }

    @Override
    public Iterator<K> getKeyIterator() {
        Iterator<K> keyIterator = new KeyIterator(this);
        return keyIterator;
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
            hashTable[count] = null;
            count++;
            numberOfEntries--;
        }
    }

    private class KeyIterator implements Iterator<K> {
        private int currentIndex; // Current position in hash table
        private int numberLeft;   ///Number of entries left in iterator

        public KeyIterator(HashedDictionary<K, V> newDictionary) {
            currentIndex = 0;
            numberLeft = numberOfEntries;
        }

        @Override
        public boolean hasNext() {
            return numberLeft > 0;
        }

        @Override
        public K next() {
            K result = null;
            if (hasNext()) {
                while ((hashTable[currentIndex] == null) || hashTable[currentIndex].isRemove())
                    currentIndex++;
                result = hashTable[currentIndex].getKey();
                numberLeft--;
                currentIndex++;

            } else
                throw new NoSuchElementException();
            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    private class ValueIterator implements Iterator<V> {
        private int currentIndex; // Current position in hash table
        private int numberLeft; // Number of entries left in iteration

        public ValueIterator(HashedDictionary<K, V> newDictionary) {
            currentIndex = 0;
            numberLeft = numberOfEntries;
        } // end constructor

        /**
         * Detects whether this iterator has completed its traversal
         * and gone beyond the last entry in the collection of data.
         *
         * @return True if the iterator has another entry to return.
         */
        @Override
        public boolean hasNext() {
            return numberLeft > 0;
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
            V result = null;
            if (hasNext()) {
                while (hashTable[currentIndex] == null ||
                        (hashTable[currentIndex].isRemove()))
                    currentIndex++;
                // end while

                result = hashTable[currentIndex].getValue();
                numberLeft--;
                currentIndex++;
            } else
                throw new NoSuchElementException();
            // end if
            return result;
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
                    "supported.");
        } // end remove
    } // end ValueIterator


    protected final class Entry<K, V> {
        private K key;
        private V value;
        private States state;  //Flags whether this entry is in this hash table

        private enum States {CURRENT, REMOVE}  //Possible values of state

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.state = States.CURRENT;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        private boolean isIn() {
            return state == States.CURRENT;
        }

        private void setToIn() {
            state = States.CURRENT;
        }

        private boolean isRemove() {
            return state == States.REMOVE;
        }

        private void setToRemove() {
            state = States.REMOVE;
        }

    }
}
