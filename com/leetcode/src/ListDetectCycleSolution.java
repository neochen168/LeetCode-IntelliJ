package com.leetcode.src;

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
}
