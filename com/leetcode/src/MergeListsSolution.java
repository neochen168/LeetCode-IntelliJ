package com.leetcode.src;


import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeListsSolution {


    public class ListNodeComparator implements Comparator<ListNode> {
        public int compare(ListNode n1, ListNode n2){
            if(n1.val > n2.val) return 1;
            else if(n1.val < n2.val) return -1;
            return 0;
        }
    }

    public ListNode mergeKLists2(ListNode[] lists){

        if(lists == null || lists.length == 0) return null;
        return mergeRange(lists, 0, lists.length-1);


    }

    public ListNode mergeRange(ListNode[] lists, int start, int end){
        if(start == end){
            return lists[start];
        }

        int middle = (end-start)/2 + start;
        return merge2(mergeRange(lists, start, middle), mergeRange(lists,middle+1, end));
    }

    public ListNode merge2(ListNode n1, ListNode n2){
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        ListNode h1 = n1;
        ListNode h2 = n2;

        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                temp.next= h1;
                h1 = h1.next;
            }else {
                temp.next = h2;
                h2 = h2.next;
            }
            temp = temp.next;
        }

        if(h1 == null) {
            temp.next = h2;
        }else {
            temp.next = h1;
        }

        return head.next;
    }



    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0) return null;

        ListNode temp = new ListNode(-1);
        ListNode staticHead = temp;
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(new ListNodeComparator());

        for(ListNode n : lists){
            if(n != null) {
                heap.add(n);
            }
        }

        while(heap.size() > 1){
            temp.next =  heap.peek();
            heap.remove(temp.next);
            temp = temp.next;
            if(temp.next != null){
                heap.add(temp.next);
            }
        }
        temp.next = heap.peek();

        return staticHead.next;
    }
}