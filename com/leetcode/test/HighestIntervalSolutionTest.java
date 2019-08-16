package com.leetcode.test;

import com.leetcode.src.HighestIntervalSolution;
import com.leetcode.src.HighestIntervalSolution.Entry;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.leetcode.src.HighestIntervalSolution.GetHighestInterval;

class HighestIntervalSolutionTest {

    @Test
    void getHighestInterval() {
        {
            List<Entry> list = new ArrayList<Entry>();
            HighestIntervalSolution solution = new  HighestIntervalSolution();

            list.add(solution.new Entry(100, 2));
            list.add(solution.new Entry(100, 1));
            list.add(solution.new Entry(110, 10));
            list.add(solution.new Entry(200, 400));
            list.add(solution.new Entry(1000, 3));
            list.add(solution.new Entry(1200, 80));

            System.out.println(GetHighestInterval(list, 50));
        }
    }
}