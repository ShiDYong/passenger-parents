package com.mason.ATD.chapter06.jdkQueue;


import org.skyscreamer.jsonassert.comparator.CustomComparator;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * JDK优先队列的测试学习
 *
 * @author ShiYong
 * @create 2022-04-12 10:31
 **/
public class JDKPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        numbers.add(4);
        numbers.add(2);
        System.out.println("PriorityQueue: " + numbers);
        /**
         * 打印出来的效果：
         * PriorityQueue: [2, 4]
         * 更新后的priorityQueue: [1, 4, 2]
         * 虽然4被插入到2之前，但队列的头是2。这是因为优先级队列的头是队列中最小的元素。
         * 然后，我们将1插入队列。 现在重新排列了队列，以将最小的元素1存储到队列的开头。
         */
        //使用offer()方法
        numbers.offer(1);
        System.out.println("更新后的priorityQueue: " + numbers);
        PriorityQueue<String> numbers02 = new PriorityQueue<>();
        numbers02.add("a");
        numbers02.add("z");
        numbers02.add("A");
        System.out.println("numbers02 = " + numbers02);
        numbers02.add("Z");
        System.out.println("numbers02 = " + numbers02);
        //遍历优先队列
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println(", ");
        }
        /**
         * 优先级队列元素都是按自然顺序（升序）检索的。
         * 但是，我们可以自定义此顺序。
         * 创建自己的comparator类，它实现了Comparator接口.
         */
        PriorityQueue<Integer> numbers03 = new PriorityQueue<>(new CustomerComparator());
        numbers03.add(4);
        numbers03.add(2);
        numbers03.add(1);
        numbers03.add(3);
        System.out.println("PriorityQueue: " + numbers03);
    }


    static class CustomerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            int value = o1.compareTo(o2);
            //元素的相反顺序排序
            if (value > 0)
                return -1;
            else if (value < 0)
                return 1;
            else
                return 0;
        }
    }


}
