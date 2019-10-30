package com.leetcode.src;

public class MinSubArrayLen
{
    public int minSubArrayLen(int s, int[] nums)
    {
            int start = 0; 
            int end = 0;
            int n = nums.length;
            int minLen = nums.length+1;
            int sum = 0;
            while(end < n){
                sum += nums[end];
                while(start <= end && sum >= s){
                    if(sum >= s){
                        minLen = Math.min(end-start+1, minLen);
                    }
                    
                    sum -= nums[start];
                    start++;
                }
                
                end++;
            }
            
            if(minLen == nums.length+1) return 0;
            return minLen;
    }
}