package com.leetcode.src;

public class AnagramSolution {
    public boolean isAnagram(String s, String t)
    {
        int[] index = new int[26];
        for (int i = 0; i < 26; i++) index[i] = 0;
        for (char a : s.toCharArray())
        {
            index[a - 'a']++;
        }
        for (char c : t.toCharArray())
        {
            index[c - 'a']--;
        }
        for (int i : index)
        {
            if (i != 0) return false;
        }
        return true;
    }
}
