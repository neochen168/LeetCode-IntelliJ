/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 */
class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int l = (n + m + 1) / 2;
            int r = (n + m + 2) / 2;
            return (MedianBinarySearchFindMth(nums1, 0, nums2, 0, l) + MedianBinarySearchFindMth(nums1, 0, nums2, 0, r)) / 2.0;
        }

        private int MedianBinarySearchFindMth(int[] a, int ai, int[] b, int bi, int m)
        {
            if (ai > a.length - 1) return b[bi + m - 1];
            if (bi > b.length - 1) return a[ai + m - 1];
            int aM = Integer.MAX_VALUE;
            int bM = Integer.MAX_VALUE;
            //if (m == 1) return Math.Min(a[ai], b[bi]);
            if (ai + m / 2 - 1 < a.length) aM = a[ai + m / 2 - 1];
            if (bi + m / 2 - 1 < b.length) bM = b[bi + m / 2 - 1];

            if (aM < bM) return MedianBinarySearchFindMth(a, ai + m / 2, b, bi, m - m / 2);
            else return MedianBinarySearchFindMth(a, ai, b, bi + m / 2, m - m / 2);
        }

}

