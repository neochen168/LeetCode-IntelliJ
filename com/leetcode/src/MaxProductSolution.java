package com.leetcode.src;

public class MaxProductSolution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] positiveDP = new int[n];
        int[] negDP = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++){
            positiveDP[i] = 1;
            negDP[i] = 1;
        }

        if(n == 1) return nums[0];
        if(nums[0] > 0) {
            positiveDP[0] = nums[0];
            max = Math.max(positiveDP[0], max);
        }
        else if(nums[0] < 0)
            negDP[0] = nums[0];

        for(int i = 1; i < n; i++){
            if(nums[i] == 0){
                continue;
            }else if(nums[i] > 0){
                positiveDP[i] = nums[i] * positiveDP[i-1];
                max = Math.max(positiveDP[i], max);
                if(negDP[i-1] < 0){
                    negDP[i] = nums[i] * negDP[i - 1];
                }
            }else {
                if(negDP[i-1] < 0){
                    positiveDP[i] = nums[i] * negDP[i - 1];
                    max = Math.max(positiveDP[i], max);
                }

                negDP[i]  = nums[i] * positiveDP[i-1];
            }
        }
        return max;
    }
}
