package com.leetcode.src;

public class DeleteNodeSolution {
    public void deleteNode(ListNode node) {

        if(node.getNext() == null) {
            node = null;
            return;
        }

        node.val = node.getNext().val;
        node.setNext(node.getNext().getNext());
    }
}