package com.leetcode.src;

public class LongestValidParantheses {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] map = new int[s.length()];
        char[] chars = s.toCharArray();
        int longest = 0;
        for (int i = 0; i < n; i++) {
            map[i] = 0;
        }

        for (int i = 1; i < n; i++) {
            if (chars[i] == ')' && chars[i - 1] == '(') {
                if (i >= 2) {
                    map[i] = map[i - 2] + 2;
                } else {
                    map[i] = 2;
                }
            } else if (chars[i] == ')') {
                if (i - map[i - 1] - 1 >= 0 && chars[i - map[i - 1] - 1] == '(') {
                    map[i] = map[i - 1] + 2;
                    if (i - map[i] >= 0) {
                        map[i] += map[i - map[i]];
                    }
                }
            }

            longest = Math.max(longest, map[i]);
        }

        return longest;

    }

    public int longestValidParentheses2(String s) {
        int n = s.length();
        int[] map = new int[s.length()];
        int longest = 0;
        for (int i = 0; i < n; i++) {
            map[i] = 0;
        }

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                if (i >= 2) {
                    map[i] = map[i - 2] + 2;
                } else {
                    map[i] = 2;
                }
            } else if (s.charAt(i) == ')') {
                if (i - map[i - 1] - 1 >= 0 && s.charAt(i - map[i - 1] - 1) == '(') {
                    map[i] = map[i - 1] + 2;
                    if (i - map[i] >= 0) {
                        map[i] += map[i - map[i]];
                    }
                }
            }

            longest = Math.max(longest, map[i]);
        }

        return longest;

    }
}
