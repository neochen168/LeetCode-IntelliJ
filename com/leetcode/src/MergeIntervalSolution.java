package com.leetcode.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervalSolution {

    class Interval{
        public int start;
        public int end;
        public Interval(int s, int e){
            start = s;
            end = e;
        }
    }

    class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval l1, Interval l2){
            if(l1.start < l2.start || l1.start == l2.start  && l1.end < l2.end) return -1;
            else if(l1.start > l2.start || l1.start == l2.start && l1.end > l2.end) return 1;
            else return 0;
        }
    }

    public int[][] merge(int[][] intervals) {

        if(intervals.length < 2) return intervals;
        List<Interval> intervalList = new ArrayList<>();
        List<Interval> ret = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        Collections.sort(intervalList, new IntervalComparator());

        int slow = 0;
        int fast = 0;
        int maxEnd = Integer.MIN_VALUE;

        while(slow < intervals.length && fast < intervals.length){
            maxEnd = intervalList.get(slow).end;
            while(fast < intervals.length && intervalList.get(slow).end >= intervalList.get(fast).start){
                maxEnd = Math.max(maxEnd, intervalList.get(fast).end);
                fast++;
            }

            if(ret.size() > 0 && ret.get(ret.size()-1).end >= intervalList.get(slow).start){
                ret.get(ret.size()-1).end = Math.max(
                        ret.get(ret.size()-1).end,
                        maxEnd);
            }
            else {
                ret.add(new Interval(intervalList.get(slow).start, maxEnd));
            }
            slow = fast;
        }

        int index = 0;
        int[][] finalRet = new int[ret.size()][2];
        for(Interval i : ret){
            finalRet[index][0] = i.start;
            finalRet[index][1] = i.end;
            index++;
        }
        return finalRet;
    }

    public int[][] merge2(int[][] intervals) {

        if(intervals.length < 2) return intervals;
        int n = intervals.length;
        List<Interval> intervalList = new ArrayList<>();
        List<Interval> ret = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        Collections.sort(intervalList, new IntervalComparator());

        int slow = 0;
        int fast = 1;
        int maxEnd = intervalList.get(slow).end;
        ret.add(new Interval(intervalList.get(slow).start, maxEnd));

        while(fast < n){
            while(fast < n && maxEnd >= intervalList.get(fast).start){
                maxEnd = Math.max(maxEnd, intervalList.get(fast).end);
                fast++;
            }

            ret.get(slow).end = maxEnd;
            if(fast < n) {
                ret.add(new Interval(intervalList.get(fast).start, intervalList.get(fast).end));
                slow++;
                maxEnd = ret.get(slow).end;
            }
        }

        int index = 0;
        int[][] finalRet = new int[ret.size()][2];
        for(Interval i : ret){
            finalRet[index][0] = i.start;
            finalRet[index][1] = i.end;
            index++;
        }
        return finalRet;
    }
}
