package com.mason.leetcode.linkedlist;


/**
 * 结点
 *
 * @author ShiYong
 * @create 2022-04-01 11:30
 **/
public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
