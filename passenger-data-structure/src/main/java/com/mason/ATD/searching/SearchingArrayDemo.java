package com.mason.ATD.searching;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Mason
 * @Description 有序数组和无序数组的查找和链表查找的常见方法
 * @date 2022/4/23 16:12
 */
public class SearchingArrayDemo {
    public static void main(String[] args) {
        String[] strings = {"o1", "o2", "o3", "o4", "o5"};
        System.out.println(inArray(strings, "o5"));
        System.out.println(inArray02(strings, "o5"));
        System.out.println(inArrayRecursive(strings, "05"));
        System.out.println("《《《《《《《《《《《《《《《测试有序数组种的二分法查找》》》》》》》》》》》》》");
        // Integer[] ints = {2, 4, 5, 7, 8, 10, 12, 15, 18, 21, 24, 26};
        Integer[] ints = {4, 8, 12, 14, 20, 24};

        System.out.println(inArray(ints, 2));
        System.out.println(inArray(ints, 8));
        System.out.println(inArray(ints, 15));

    }


    /**
     * 无序数组种的迭代顺序查找方法的实现
     *
     * @param anArray
     * @param anEntry
     * @param <T>
     * @return
     */
    public static <T> boolean inArray01(T[] anArray, T anEntry) {
        boolean found = false;
        int index = 0;
        while (!found && (index < anArray.length)) {
            if (anEntry.equals(anArray[index]))
                //一旦在数组种找到第一个与所要找的项相等，立即退出循环。
                found = true;
            index++;
        }
        return found;
        //如果要返回数组种第一个等于anEntry的项的下标；修改方法的返回值，然后return index;
    }

    /**
     * 修改第一个方法，让其返回数组种第一个等于amEntry的项的下标。
     * 如果数组不含有这样的项，则返回-1
     *
     * @param anArray
     * @param anEntry
     * @param <T>
     * @return
     */
    public static <T> int inArray02(T[] anArray, T anEntry) {
        boolean found = false;
        int where = -1;
        int index = 0;
        while (!found && (index < anArray.length)) {
            if (anEntry.equals(anArray[index])) {
                found = true;
                where = index;
            } else
                index++;
        }
        return where;
    }

    /**
     * 递归实现无序数组的查找
     *
     * @param anArray
     * @param anEntry
     * @param <T>
     * @return
     */
    public static <T> boolean inArrayRecursive(T[] anArray, T anEntry) {
        return search(anArray, 0, anArray.length - 1, anEntry);
    }

    /**
     * Searches anArray[first] through anArray[last] fro desiredItem.
     *
     * @param anArray
     * @param first
     * @param last
     * @param desiredItem
     * @param <T>
     * @return
     */
    private static <T> boolean search(T[] anArray, int first, int last, T desiredItem) {
        boolean found;
        //终止条件
        if (first > last)
            return false;
        else if (desiredItem.equals(anArray[first]))
            return true;
        else
            found = search(anArray, first + 1, last, desiredItem);
        return found;
    }


    /**
     * 实现有序数组的二分查找的共有方法
     *
     * @param anArray
     * @param anEntry
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> boolean inArray(T[] anArray, T anEntry) {
        return binarySearch(anArray, 0, anArray.length - 1, anEntry);

    }

    /**
     * 通过递归实现对有序数组的二分查找：
     * 有序数组的二分查找不同无序数组的查找，通过equal方法比较两项是否相等
     * 有序数组为了进行必要的比较，我们需要方法compareTo.虽然所有的类从Object类继承了equals并可
     * 重写它，故所有的对象的方法equals.但有CompareTo方法的对象必须属于实现了接口Comparable的类。
     * <p>
     * 查找 8 需要进行 7 次比较，如下所示：
     * 8 = = 10?
     * 8 < 10?
     * 8 < 5?
     * 8 < 7?
     * 8 = = 5?
     * 8 = = 7?
     * 8 = = 8?
     * <p>
     * 查找 16 需要进行 8 次比较，如下所示：
     * 16 = = 10?
     * 16 < 10?
     * 16 < 18?
     * 16 < 12?
     * 16 < 15?
     * 16 = = 18?
     * 16 = = 12?
     * 16 = = 15?
     */
    private static <T extends Comparable<? super T>> boolean binarySearch(T[] anArray, int first, int last, T desiredItem) {
        boolean found = false;
        //注意计算中间的点mid的Java语句是下面的，而不是int mid=(first+last)/2,当数据量比较大时容易益处
        int mid = first + (last - first) / 2;
        if (first > last)
            found = false;
        /**
         *  else if (desiredItem.compareTo(anArray[mid]) = 0)
         *      found = true;
         *      此处可以用这个来替代下面的equals()方法
         */
        else if (desiredItem.equals(anArray[mid]))
            found = true;
        else if (desiredItem.compareTo(anArray[mid]) < 0)
            found = binarySearch(anArray, first, mid - 1, desiredItem);
        else
            found = binarySearch(anArray, mid + 1, last, desiredItem);
        return found;
    }

    /**
     *修改方法让其数组种第一个等于anEntry的下标数组项的下标的方法修改
     */
    private static <T extends Comparable<? super T>> int binarySearch02(T[] anArray, int first, int last, T desiredItem) {
        int result;
        //注意计算中间的点mid的Java语句是下面的，而不是int mid=(first+last)/2,当数据量比较大时容易益处
        int mid = first + (last - first) / 2;
        if (first > last)
            result = -1;
        /**
         *  else if (desiredItem.compareTo(anArray[mid]) = 0)
         *      found = true;
         *      此处可以用这个来替代下面的equals()方法
         */
        else if (desiredItem.equals(anArray[mid]))
            result = mid;
        //要想实现数组的降序可将<改为>.实现从大到小的降序排列
        else if (desiredItem.compareTo(anArray[mid]) < 0)
            result = binarySearch02(anArray, first, mid - 1, desiredItem);
        else
            result = binarySearch02(anArray, mid + 1, last, desiredItem);
        return result;

    }
    /**
     * 数组中的二分查找的时间效率
     * 最优情况：O（1）
     * 最差情况：O(logn)
     * 平均情况：O（logn）
     */

}
