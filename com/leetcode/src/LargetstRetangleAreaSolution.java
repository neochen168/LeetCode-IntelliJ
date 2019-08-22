package com.leetcode.src;

import java.util.Stack;

public class LargetstRetangleAreaSolution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 1) {
            return heights[0];
        }

        if (n == 0) return 0;

        int maxRec = 0;
        int pIndex = 0;
        Stack<Integer> stack  = new Stack<Integer>();
        Stack<Integer> hStack = new Stack<Integer>();
        stack.push(pIndex);
        hStack.push(heights[0]);
        pIndex++;

        while(pIndex < n){

            if(heights[pIndex] > hStack.peek()){
                stack.push(pIndex);
                hStack.push(heights[pIndex]);
            }else{
                int leftMin= stack.peek();
                while(!stack.empty() && hStack.peek() > heights[pIndex]){
                    leftMin = stack.peek();
                    maxRec = Math.max(hStack.peek() * (pIndex - leftMin), maxRec);
                    stack.pop();
                    hStack.pop();
                }

                stack.push(leftMin);
                hStack.push(heights[pIndex]);
            }

            pIndex++;
        }

        while(!stack.empty()){
            maxRec = Math.max(hStack.peek() * (n - stack.peek()), maxRec);
            stack.pop();
            hStack.pop();
        }

        return maxRec;
    }
}
