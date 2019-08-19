package com.leetcode.src;

import java.util.List;

public class HighestIntervalSolution {
    /// <summary>
    /// Given a set of entries, each containing a time index and a int count value,
    //class Entry
    //{
    //time:int
    //count:int
    //}

    //write a function that will give the time interval with the highest count together,

    //ie,
    //if we had entries
    //100, 2
    //100, 1
    //110, 10
    //200, 4
    //1000, 3
    //1200, 8

    //and we ran something like
    //int highestInterval(int interval_range)
    //highestInterval( 50 )
    //it would return 100, because in 100-150, you have counts 2, 1, and 10.
    /// </summary>
    public class Entry {
        public int time;
        public int count;

        public Entry(int t, int c) {
            time = t;
            count = c;
        }
    }

    public static int maxValue = Integer.MIN_VALUE;

    public static int GetHighestInterval(List<Entry> list, int highest) {
        int localMax = list.get(0).count;
        int window = 0;
        int lastTimeIndex = 0;
        int retIndex = 0;
        for (int i = 1; i < list.size(); i++) {
            window += list.get(i).time - list.get(i - 1).time;
            if (window <= highest) {
                localMax += list.get(i).count;
            } else {
                while (window > highest && lastTimeIndex < i) {
                    localMax -= list.get(lastTimeIndex++).count;
                    window -= list.get(lastTimeIndex).time - list.get(lastTimeIndex - 1).time;
                }

                localMax += list.get(i).count;
            }

            if (maxValue < localMax) {
                maxValue = localMax;
                retIndex = lastTimeIndex;
            }
        }

        return list.get(retIndex).time;
    }
}