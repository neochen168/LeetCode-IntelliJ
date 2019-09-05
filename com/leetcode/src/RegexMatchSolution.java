package com.leetcode.src;

public class RegexMatchSolution {

    public boolean isMatch(String s, String p) {
        char[] source = s.toCharArray();
        char[] express = p.toCharArray();

        boolean[][] dpCache = new boolean[source.length + 1][ express.length + 1];
        dpCache[0][0] = true;

        for (int i = 1; i <= express.length; i++)
        {
            dpCache[0][ i] = false;
            if (i > 1 && express[i - 1] == '*')
            {
                dpCache[0][ i] |= dpCache[0][ i - 2];
            }
        }

        for (int i = 1; i <= source.length; i++)
        {
            for (int j = 1; j <= express.length; j++)
            {
                if (express[j - 1] == source[i - 1] || express[j - 1] == '.')
                {
                    dpCache[i][ j] = dpCache[i - 1][ j - 1];
                }
                else if (express[j - 1] == '*')
                {
                    dpCache[i][ j] = dpCache[i][ j] || dpCache[i][ j - 1];
                    if (j > 1)
                    {
                        if (express[j - 2] == '.')
                        {
                            // ".*" means matching anything
                            for (int k = 1; k <= i && !dpCache[i][j]; k++)
                            {
                                dpCache[i][ j] |= dpCache[k][ j - 2] || dpCache[k][ j - 1];
                            }
                        }

                        dpCache[i][ j] |= dpCache[i][ j - 2];
                    }
                    if (i > 1 && source[i - 1] == source[i - 2])
                    {
                        dpCache[i][ j] = dpCache[i][ j] || dpCache[i - 1][ j - 1];
                    }
                }
            }
        }

        return dpCache[source.length][ express.length];
    }
}
