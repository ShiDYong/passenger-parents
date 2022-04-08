package com.mason.leetcode.linkedlist;

/**
 * 反转单链表
 *
 * @author ShiYong
 * @create 2022-04-01 11:26
 **/
public class ReverseLinedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(12);
        ListNode node = reverseList(head);
        System.out.println(node.val);
    }


    /**
     * 基于双指针迭代方法实现
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode previousNode = null;
        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode next = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = next;
        }
        return previousNode;
    }


}
