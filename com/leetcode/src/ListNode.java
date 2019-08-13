package com.leetcode.src;

import java.util.Comparator;

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

    public static Comparator<ListNode> listNodeComparator = new Comparator<ListNode>(){
        public int compare(ListNode n1, ListNode n2){
            if(n1.val > n2.val) return 1;
            else if(n1.val < n2.val) return -1;
            return 0;
        }
    };
}
