package com.mason.ATD.recursive;

import com.mason.ATD.chapter05.LinkedStack;
import com.mason.ATD.chapter05.StackInterface;

/**
 * 模拟程序栈操作的过程
 * 使用迭代法取代递归方法
 * @author ShiYong
 * @create 2022-04-13 10:33
 **/
public class StackRecursive {


    public void displayArray(int first, int last) {
        boolean done = false;
        StackInterface<Record> programStack = new LinkedStack<>();
        programStack.push(new Record(first, last));

        while (!done && !programStack.isEmpty()) {

            Record topRecord = programStack.pop();
            first = topRecord.getFirst();
            last = topRecord.getLast();
            if (first == last) {
                // System.out.println(array[first] + " ");

            } else {
                int mid = first + (last - first) / 2;
                programStack.push(new Record(mid + 1, last));
                programStack.push(new Record(first, mid));
            }
        }
    }
}
