package com.leetcode.src;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ValidSubArraySolution {
    class MinHeapComparator implements Comparator<Integer> {
        public int compare(Integer i1, Integer i2) {
            return Integer.compare(i1, i2);
        }
    }

    public int validSubArraysDP(int[] nums){
        int n = nums.length;
        if (n == 0) return 0;

        int ret = 1;
        int[] dp = new int[n];
        int[] dpIndex = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            dpIndex[i] = i;
        }

        ret = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] >= nums[i - 1]) {
                dpIndex[i] = dpIndex[i - 1];
                dp[i] += dp[i-1];

            } else if (nums[i] >= nums[dpIndex[i - 1]]) {
                dpIndex[i] = dpIndex[i - 1];
                dp[i]++;
                for(int j = i-1; j > dpIndex[i-1]; j--){
                    if(nums[j] <= nums[i]){
                        dp[i] += dp[j] - 1; //minus the nums[j] itself
                        break;
                    }
                }
            }

            ret += dp[i];
        }

        return ret;
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
