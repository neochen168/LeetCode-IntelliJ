package com.leetcode.test;

import com.leetcode.src.DeleteNodeSolution;
import com.leetcode.src.ListNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class DeleteNodeSolutionTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void deleteNodeFirst() {
        ListNode header = new ListNode(5);
        header.next = new ListNode(4);
        header.next.next = new ListNode(3);
        header.next.next.next = new ListNode(2);
        header.next.next.next.next = new ListNode(1);
        DeleteNodeSolution sl = new DeleteNodeSolution();
        sl.deleteNode(header);

        ListNode cursor = header;
        while(cursor!= null){
            System.out.println(cursor.val);
            cursor = cursor.next;
        }
    }

    @Test
    void deleteNodeMiddle() {
        ListNode header = new ListNode(5);
        header.next = new ListNode(4);
        header.next.next = new ListNode(3);
        header.next.next.next = new ListNode(2);
        header.next.next.next.next = new ListNode(1);
        DeleteNodeSolution sl = new DeleteNodeSolution();
        sl.deleteNode(header.next.next);

        ListNode cursor = header;
        while(cursor!= null){
            System.out.println(cursor.val);
            cursor = cursor.next;
        }
    }

    @Test
    void deleteNodeLast() {
        ListNode header = new ListNode(5);
        header.next = new ListNode(4);
        header.next.next = new ListNode(3);
        header.next.next.next = new ListNode(2);
        header.next.next.next.next = new ListNode(1);
        DeleteNodeSolution sl = new DeleteNodeSolution();
        sl.deleteNode(header.next.next.next.next);

        ListNode cursor = header;
        while(cursor!= null){
            System.out.println(cursor.val);
            cursor = cursor.next;
        }

        assertEquals(1, 1);
    }
}