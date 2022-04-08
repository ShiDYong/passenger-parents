package com.mason.leetcode.linkedlist;

/**
 * 删除链表中的节点练习
 *
 * @author ShiYong
 * @create 2022-04-01 10:22
 **/
public class DeleteNode {

    /**
     * 对于一般性的链表删除操作而言，我们需要知道待删除节点的前一节点与后一节点，对两者建立联系。
     * 对于本题，由于我们只知道待删除节点本身，
     * 同时该链表为单链表（无法访问前一节点），因此我们只能先将后一节点的值复制到当前节点，
     * 然后将后一节点当作「待删除节点」来进行常规删除。
     * 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list/solution/gong-shui-san-xie-jian-dan-lian-biao-mo-rovcb/
     * 来源：力扣（LeetCode）
     *
     * @param node
     */
    public static void deleteNode(ListNode node){
        //把后一个结点的值复制到当前结点
        node.val = node.next.val;
        //把后一节点当做待删除节点进行常规删除.
        node.next=node.next.next;


    }



    private  class ListNode{
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
