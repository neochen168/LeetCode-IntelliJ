package com.leetcode.src;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxCoinDPSolution {


    public int maxCoins(int[] nums) {

        int[][] dp = new int[nums.length + 2][nums.length + 2];
        int[] newNums = new int[nums.length + 2];
        for (int i = 1; i < newNums.length - 1; i++) {
            newNums[i] = nums[i - 1];
        }
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;
        for (int j = 2; j < newNums.length; j++) {
            for (int i = 0; i < newNums.length - j; i++) {
                for (int k = i + 1; k < i + j; k++) {
                    dp[i][i + j] = Math.max(dp[i][i + j],
                            dp[i][k] + dp[k][i + j] + newNums[i] * newNums[k] * newNums[i + j]);
                }
            }
        }
        return dp[0][newNums.length - 1];
    }

}
