package com.leetcode.src;

public class RemoveElement{
    public int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}