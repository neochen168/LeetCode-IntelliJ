package com.leetcode.src;

public class ZeroSolution {
    public void MoveZeroes(int[] nums)
    {
        int countOfZeros = 0;
        for (int i = 0; i < nums.length; i++)
        {
            nums[i - countOfZeros] = nums[i];
            if (nums[i] == 0) countOfZeros++;
        }
        for (; countOfZeros > 0; countOfZeros--)
        {
            nums[nums.length - countOfZeros] = 0;
        }
    }
}
