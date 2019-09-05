package com.leetcode.src;

import java.util.HashSet;

public class ListDetectCycleSolution {

    public ListNode DetectCycle(ListNode head)
    {
        ListNode p = head;
        ListNode pp = head;
        int hh = 0;

        while (p != null && pp != null)
        {
            p = p.next; hh++;
            if (pp.next == null) return null;
            pp = pp.next.next;

            if (p == pp) break;
        }

        if (pp == null) return null;

        int ah = hh / 2;
        pp = head;
        while (ah > 0)
        {
            pp = pp.next.next;
            ah--;
        }

        if (hh % 2 != 0) pp = pp.next;
        p = head;

        while (hh >= 0)
        {
            if (p == pp) return p;
            p = p.next;
            pp = pp.next;
            hh--;
        }

        return null;
    }

    public ListNode DetectCycle2(ListNode head){
        ListNode p = head;
        if(p == null) return p;

        HashSet<ListNode> visited = new HashSet<ListNode>();
        visited.add(p);
        while(p != null && !visited.contains(p.next)){
            p = p.next;
            visited.add(p);
        }

        return p == null ? null : p.next;
    }
}
