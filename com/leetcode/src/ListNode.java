package com.leetcode.src;

/**
 * Definition for singly-linked list.
 **/
public class ListNode {
    public int val;
    public  ListNode next;
    public ListNode(int x) { val = x; }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
