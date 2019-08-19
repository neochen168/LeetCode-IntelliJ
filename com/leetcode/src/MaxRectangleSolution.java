package com.leetcode.src;

public class MaxRectangleSolution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        int currLeft = 0;
        int currRight = n;
        int maxRect = 0;

        for(int i = 0; i < n; i++){
            left[i] = 0;
            right[i] = n;
            height[i] = 0;
        }

        for(int i = 0; i < matrix.length; i++){
            currLeft = 0;
            currRight = n;

            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    height[j]++;
                }else{
                    height[j] = 0;
                }
            }

            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    left[j] = Math.max(left[j], currLeft);
                }else {
                    currLeft = j + 1;
                    left[j] = 0;
                }
            }

            for(int j = n-1; j >= 0; j--){
                if(matrix[i][j] == '1'){
                    right[j] = Math.min(right[j], currRight);
                }else{
                    right[j] = n;
                    currRight = j;
                }
            }

            for(int j = 0; j < n; j++){
                maxRect = Math.max(maxRect, (right[j]-left[j])*height[j]);
            }
        }

        return maxRect;
    }
}
