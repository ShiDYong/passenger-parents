package com.mason.ATD.sortedList;

/**
 * 有序表的接口
 * 备注：有序表不允许按位置添加或者指定位置替换元素，否则会导致有序表的混乱
 * @author shiyong
 */
public interface SortedListInterface<T> {


    /**
     * 任务：将newEntry添加到有序表中，且有序表任然保持有序
     *
     * @param newEntry 是要添加的对象
     *                 输出：无
     */
    public void add(T newEntry);

    /**
     * 任务：从有序表中删除anEntry第一次或唯一一次的出现
     *
     * @param anEntry 是要删除的对象
     * @return 如果在有序表找到anEntry并删除则返回真，否则返回假。后一种情况下，有序表维持不变
     */
    public boolean remove(T anEntry);

    /**
     * 任务：得到anEntry第一次或唯一一次出现的位置
     *
     * @param anEntry 是要找的对象
     * @return 如果有序表中找到anEntry，则返回它的位置。否则返回anEntry应该在有序表
     * 的位置，但以负整数表示.
     */
    public int getPosition(T anEntry);

    /**
     * Removes the entry at a given position from this list.
     * Entries originally at positions higher than the given.
     * position are at the next lower position within the list
     * and the list's size is decreased by 1.
     *
     * @param givenPosition An integer that indicates the position of the entry to be removed.
     * @return A reference to the removed entry.
     * @throws IndexOutOfBoundsException if either givenPosition < 1 or givenPosition> getlength().</>
     */
    public T remove(int givenPosition);

    /**
     * Retrieves the entry at a given position in this list
     *
     * @param givenPosition An integer that indecates the position of the desired entry.
     * @return A reference to the indicated entry
     * * @throws IndexOutOfBoundsException if either givenPostion < 1 or givenPosition> getlength().</>
     */
    public T getEntry(int givenPosition);

    /**
     * Retrieves all entries that are in this list in the order in which they occur in the list
     *
     * @return A newly allocated array of all the entries in the list .If the list if empty,
     * the returned array is empty.
     */
    public T[] toArray();

    /**
     * Sees whether this list contains a given entry.
     *
     * @param anEntry The object that is the desired entry.
     * @return True if the list conatins anEntry, or false if not.
     */
    public boolean contain(T anEntry);


    /**
     * Gets the length of this list.
     *
     * @return The integer number of entries currenctly in the list.
     */
    public int getLength();


    /**
     * Sees whether this list is empty
     *
     * @return True if the list is empty, or false if not.
     */
    public boolean isEmpty();

    /**
     * Removes all entries from this list.
     */
    public void clear();


}
