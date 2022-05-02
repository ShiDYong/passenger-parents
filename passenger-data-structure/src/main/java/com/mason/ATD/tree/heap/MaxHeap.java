package com.mason.ATD.tree.heap;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Mason
 * @Description 最大堆
 * @date 2022/5/2 10:34
 */
public class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T> {
    private T[] heap; //Array of heap entries
    private int lastIndex; //Index of last entry
    private boolean isIntegrity;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public MaxHeap() {
        this(DEFAULT_CAPACITY);
    }

    public MaxHeap(int initialCapacity) {
        if (initialCapacity < DEFAULT_CAPACITY)
            initialCapacity = MAX_CAPACITY;
        else
            checkCapacity(initialCapacity);
        @SuppressWarnings("unchecked")
        T[] tempHeap = (T[]) new Comparable[initialCapacity + 1];
        heap = tempHeap;
        lastIndex = 0;
        isIntegrity = true;
    }

    //创建最大堆的高效方法
    public MaxHeap(T[] entries) {
        this(entries.length);  //Call other constructor
        lastIndex = entries.length;
        //Assertion: intergrityOk == true
        //Copy given array to data field
        for (int index = 0; index < entries.length; index++)
            heap[index + 1] = entries[index];
        //Create heap
        for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
            reheap(rootIndex);
    }

    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY)
            throw new IllegalArgumentException("Attempt to create a bag whose " +
                    "exceeds allowed maximum");
    }

    @Override
    public void add(T newEntry) {
        checkIntegrity();
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;
        while ((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0) {
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;

        }
        heap[newIndex] = newEntry;
        lastIndex++;
        ensureCapacity();


    }

    //将一个哨兵值放在数组未用的下标0处，就可以省略while语句中关于parentIndex的测试
    public void add02(T newEntry) {
        checkIntegrity();
        heap[0] = newEntry; //Sentinel
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;
        while (newEntry.compareTo(heap[parentIndex]) > 0) {
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
        }
        heap[newIndex] = newEntry;
        lastIndex++;
        ensureCapacity();
    }

    //数组的扩容
    private void ensureCapacity() {
        if (lastIndex >= heap.length - 1) {
            int newCapacity = (heap.length - 1) << 1;
            checkCapacity(newCapacity);
            heap = Arrays.copyOf(heap, newCapacity);
        }
    }


    //为删除根，先要用堆中的最后的叶结点替换根，这个步骤得到一个半堆
    //，因为使用方法reheap将半堆转换为堆
    @Override
    public T removeMax() {
        checkIntegrity();
        T root = null;
        if (!isEmpty()) {
            root = heap[1];          // Return value
            heap[1] = heap[lastIndex];  //Form a semiheap
            lastIndex--;               //Decrease size
            reheap(1);                  // Transform to a heap
        }
        return root;
    }

    //将半堆转换为堆的方法
    private void reheap(int rootIndex) {
        boolean done = false;
        T orphan = heap[rootIndex];
        //如果从数组下标为1处开始存储树，则对于数组下标i处的结点
        //其父结点在下标为i/2处，除非结点是根(i是1)
        //如果存在，孩子结点在下标2i和2i+1处
        int leftChildIndex = 2 * rootIndex;
        while (!done && (leftChildIndex <= lastIndex)) {
            int largerChildIndex = leftChildIndex;  //Assume large
            int rightChildIndex = leftChildIndex + 1;
            if ((rightChildIndex <= lastIndex) && (heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)) {
                largerChildIndex = rightChildIndex;
            }
            if (orphan.compareTo(heap[largerChildIndex]) < 0) {
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
            } else
                done = true;
        }
        heap[rootIndex] = orphan;
    }

    /**
     * Revised reheap method.
     *
     * @param <T>       Data type of the entry
     * @param heap      The array containing the heap entries
     * @param rootIndex The index of the root of semiheap
     * @param lastIndex The last index that the array heap ranges.
     */
    private static <T extends Comparable<? super T>> void reheap(T[] heap, int rootIndex, int lastIndex) {
        boolean done = false;
        T orghan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex + 1;
        while (!done && (leftChildIndex <= lastIndex)) {
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;
            if ((rightChildIndex <= lastIndex) && (heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0))
                largerChildIndex = rightChildIndex;
            if (orghan.compareTo(heap[largerChildIndex]) < 0) {
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex + 1;
            } else
                done = true;
        }
        heap[rootIndex] = orghan;
    }

    public static <T extends Comparable<? super T>> void heapSort(T[] array, int n) {
        // Create first heap
        for (int rootIndex = n / 2 - 1; rootIndex >= 0; rootIndex--)
            reheap(array, 0, n - 1);
        swap(array, 0, n - 1);
        for (int lastIndex = n - 2; lastIndex > 0; lastIndex--) {
            reheap(array, 0, lastIndex);
            swap(array, 0, lastIndex);

        }

    }

    private static <T extends Comparable<? super T>> void swap(T[] array, int firstIndex, int secondIndex) {
        T temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    @Override
    public T getMax() {
        checkIntegrity();
        T root = null;
        if (!isEmpty())
            root = heap[1];
        return root;
    }

    @Override
    public boolean isEmpty() {
        return lastIndex < 1;
    }

    @Override
    public int getSize() {
        return lastIndex;
    }

    @Override
    public void clear() {
        checkIntegrity();
        while (lastIndex > -1) {
            heap[lastIndex] = null;
            lastIndex--;
        }
        lastIndex = 0;
    }

    private void checkIntegrity() {
        if (!isIntegrity)
            throw new SecurityException();
    }
}
