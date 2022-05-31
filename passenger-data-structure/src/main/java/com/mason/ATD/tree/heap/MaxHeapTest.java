package com.mason.ATD.tree.heap;

/**
 * @author Mason
 * @Description 最大堆方法功能的测试
 * @date 2022/5/2 15:33
 */
public class MaxHeapTest {
    public static void main(String[] args) {
        MaxHeap<Integer> myHeap = new MaxHeap<>();
        //测试单个添加操作
        myHeap.add(20);
        myHeap.add(40);
        myHeap.add(30);
        myHeap.add(10);
        myHeap.add(90);
        myHeap.add(70);
        //测试删除操作
        myHeap.removeMax();
        //批量高效创建最大堆堆方法
        //1.首先创建一个数组
        Integer[] arr={20,40,30,10,90,10};
        MaxHeap<Integer> maxHeap = new MaxHeap<>(arr);
        System.out.println(maxHeap.isEmpty());
        System.out.println(maxHeap.getSize());
        //测试堆排序,无法调用里面堆排序堆方法
        MaxHeap.heapSort(arr,arr.length);





    }
}
