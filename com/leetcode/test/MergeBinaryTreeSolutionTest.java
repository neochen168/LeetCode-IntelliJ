package com.leetcode.test;

import com.leetcode.src.MergeBinaryTreeSolution;
import com.leetcode.src.TreeNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeBinaryTreeSolutionTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

@Test
    void mergeTwoTrees() {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        TreeNode t2 = new TreeNode(4);
        t2.left = new TreeNode(5);
        t2.right = new TreeNode(6);
        MergeBinaryTreeSolution sl = new MergeBinaryTreeSolution();
        TreeNode root = sl.mergeTrees(t1, t2);
        Assertions.assertEquals(root.val, 5);
        System.out.println(root.val);
        Assertions.assertEquals(root.left.val, 7);
        System.out.println(root.left.val);
        Assertions.assertEquals(root.right.val, 9);
        System.out.println(root.right.val);
    }

    @Test
    void mergeTwoTreesLeftOneChild() {
        TreeNode t1 = new TreeNode(1);
        t1.right = new TreeNode(3);
        TreeNode t2 = new TreeNode(4);
        t2.left = new TreeNode(5);
        t2.right = new TreeNode(6);
        MergeBinaryTreeSolution sl = new MergeBinaryTreeSolution();
        TreeNode root = sl.mergeTrees(t1, t2);
        Assertions.assertEquals(root.val, 5);
        System.out.println(root.val);
        Assertions.assertEquals(root.left.val, 5);
        System.out.println(root.left.val);
        Assertions.assertEquals(root.right.val, 9);
        System.out.println(root.right.val);
    }
}