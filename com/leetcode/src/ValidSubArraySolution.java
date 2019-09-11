package com.leetcode.src;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ValidSubArraySolution {
    class MinHeapComparator implements Comparator<Integer> {
        public int compare(Integer i1, Integer i2) {
            return Integer.compare(i1, i2);
        }
    }

    public int validSubarrays(int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int ret = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>(new MinHeapComparator());

        while(left < n){
            if(heap.isEmpty()) {
                right = left;
            }else {
                if(heap.peek() == nums[left]){
                    ret += heap.size();
                }else{
                    heap.clear();
                    right = left;
                }
            }
            while(right < n && nums[right] >= nums[left] ){
                ret ++;
                heap.add(nums[right]);
                right++;
            }

            heap.remove(nums[left]);
            left ++;
        }

        return ret;
    }

}
