package com.leetcode.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidStringSolution {
    public boolean isValid(String s) {
        List<Character> stack = new ArrayList<Character>();
        for (char in : s.toCharArray()) {
            if (in == '(' || in == '[' || in == '{') {
                stack.add(in);
            } else if (in == ')' || in == ']' || in == '}') {
                if (stack.size() > 0 && (stack.get(stack.size() - 1) == '(' && in == ')'
                        || stack.get(stack.size() - 1) == '{' && in == '}'
                        || stack.get(stack.size() - 1) == '[' && in == ']')) {
                    stack.remove(stack.size() - 1);
                } else {
                    return false;
                }
            }
        }
        if (stack.size() == 0)
            return true;
        return false;
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char in : s.toCharArray()) {
            if (in == '(' || in == '[' || in == '{') {
                stack.add(in);
            } else if (in == ')' || in == ']' || in == '}') {
                if (!stack.empty() && (stack.peek() == '(' && in == ')'
                        || stack.peek() == '{' && in == '}'
                        || stack.peek() == '[' && in == ']')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (stack.empty())
            return true;
        return false;
    }

    public boolean isValidFastest(String s) {

        char[] stack = new char[s.length()];
        int top = -1;

        for (char in : s.toCharArray()) {
            if (in == '(' || in == '[' || in == '{') {
                stack[++top] = in;
            } else if (in == ')' || in == ']' || in == '}') {
                if (top >= 0 && (stack[top] == '(' && in == ')'
                        || stack[top] == '{' && in == '}'
                        || stack[top] == '[' && in == ']')) {
                    top--;
                } else {
                    return false;
                }
            }
        }

        if (top == -1) return true;
        return false;
    }
}

